package com.example.sas18skillbuilding1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sas18skillbuilding1.ui.theme.SAS18SkillBuilding1Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SAS18SkillBuilding1Theme {
                HTMLFetcherApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HTMLFetcherApp() {
    var htmlContent by remember { mutableStateOf("Fetching...") }

    LaunchedEffect(Unit) {
        htmlContent = fetchHTML("https://example.com")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("HTML Fetcher") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(text = htmlContent)
        }
    }
}

suspend fun fetchHTML(link: String): String {
    return withContext(Dispatchers.IO) {
        try {
            val url = URL(link)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connect()

            val inputStream = connection.inputStream
            val reader = BufferedReader(InputStreamReader(inputStream))
            val content = reader.readText()

            reader.close()
            inputStream.close()
            connection.disconnect()
            content
        } catch (e: Exception) {
            Log.e("HTMLFetcher", "Error fetching HTML", e)
            "Failed to fetch HTML"
        }
    }
}
