# SAS18SkillBuilding1

## Overview
SAS18SkillBuilding1 is an Android application built with Jetpack Compose that fetches and displays HTML content from a specified URL. The app demonstrates how to make network requests using Kotlin coroutines and displays the fetched data in a scrollable `TextView` format.

## Features
- Fetches HTML content from a given URL.
- Uses Kotlin Coroutines (`Dispatchers.IO`) for network requests.
- Displays fetched content in a `Scaffold` with a `TopAppBar`.
- Implements Jetpack Compose for a modern UI experience.
- Handles errors and logs exceptions for debugging.

## Technologies Used
- **Language**: Kotlin
- **Framework**: Android Jetpack Compose
- **Networking**: `HttpURLConnection`
- **Concurrency**: Kotlin Coroutines (`Dispatchers.IO`)
- **UI Components**: `Scaffold`, `Column`, `Text`, `TopAppBar`

## Project Structure
```
SAS18SkillBuilding1/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/sas18skillbuilding1/
│   │   │   │   ├── MainActivity.kt  # Main logic and UI setup
│   │   │   │   ├── Theme.kt  # Theme styling for Jetpack Compose
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   ├── AndroidManifest.xml  # App manifest file
```

## Code Explanation
1. **Fetching HTML Content**:
   - The app uses `HttpURLConnection` to fetch HTML content from `https://example.com`.
   - The network request runs in the `IO` thread using `withContext(Dispatchers.IO)`.

2. **Displaying Data**:
   - The fetched HTML content is displayed in a `Text` component inside a `Scaffold`.
   - `LaunchedEffect(Unit)` triggers the fetch request when the app starts.

3. **Error Handling**:
   - If the network request fails, it logs an error message and displays `"Failed to fetch HTML"` in the UI.

## How to Run
1. Clone this repository:
   ```sh
   git clone https://github.com/your-repo/SAS18SkillBuilding1.git
   ```
2. Open the project in Android Studio.
3. Build and run the application on an emulator or a physical device.


## Screenshots

| App UI | Website | Console |
|---|---|---|
| ![App UI](https://github.com/user-attachments/assets/309ae5fd-a4c1-463d-ab22-8918c93e4113) | ![Website](https://github.com/user-attachments/assets/a9c52156-16bd-4ab7-aa6f-712d97a1b37f) | ![Console](https://github.com/user-attachments/assets/6b9af1fb-63e3-4412-85d2-b8898311ea90) |
