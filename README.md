# GNSS Satellite Tracker 🛰️

An Android application built with Jetpack Compose that tracks and displays GNSS (Global Navigation Satellite System) satellite information in real-time.

## Features

- 📡 Real-time GNSS satellite tracking
- 🎯 Location permission handling
- 📊 Display satellite constellation data
- 🎨 Modern Material Design UI with Jetpack Compose
- ⚡ MVVM architecture pattern

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Location Services**: Android LocationManager
- **Minimum SDK**: Android 5.0 (API 21)

## Project Structure

```
app/
├── src/
│   └── main/
│       ├── AndroidManifest.xml                      # App manifest & permissions
│       │
│       ├── java/com/example/gnss/
│       │   ├── MainActivity.kt                      # Entry point & permission handling
│       │   ├── GnssViewModel.kt                     # Business logic & GNSS callbacks
│       │   │
│       │   └── ui/
│       │       ├── GnssScreen.kt                    # Main Compose UI screen
│       │       │
│       │       └── theme/
│       │           ├── Color.kt                     # Color definitions
│       │           ├── Theme.kt                     # App theme configuration
│       │           └── Type.kt                      # Typography definitions
│       │
│       └── res/
│           ├── values/
│           │   ├── strings.xml                      # String resources
│           │   ├── colors.xml                       # Legacy XML colors
│           │   └── themes.xml                       # System-level themes
│           │
│           ├── drawable/
│           │   ├── ic_launcher_background.xml       # Launcher icon background
│           │   └── ic_launcher_foreground.xml       # Launcher icon foreground
│           │
│           ├── mipmap-*/                            # App icons (all densities)
│           │   ├── mipmap-anydpi-v26/
│           │   ├── mipmap-hdpi/
│           │   ├── mipmap-xhdpi/
│           │   ├── mipmap-xxhdpi/
│           │   └── mipmap-xxxhdpi/
│           │
│           └── xml/
│               ├── backup_rules.xml                 # Backup configuration
│               └── data_extraction_rules.xml        # Data extraction rules
```

## Key Components

### 1. MainActivity.kt
- Application entry point
- Handles runtime location permission requests
- Manages activity lifecycle

### 2. GnssViewModel.kt
- Interfaces with Android's LocationManager
- Registers GNSS status callbacks
- Processes and exposes satellite data to the UI
- Handles GNSS measurement updates

### 3. GnssScreen.kt
- Jetpack Compose UI implementation
- Displays satellite information in a list/grid format
- Observes ViewModel state changes
- Handles user interactions

### 4. Theme Configuration
- **Color.kt**: Defines app color palette
- **Theme.kt**: Configures Material Design theme
- **Type.kt**: Typography scale and font definitions

## Permissions

The app requires the following permission declared in `AndroidManifest.xml`:

```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

This permission is necessary to access GNSS satellite data and location services.

## Getting Started

### Prerequisites

- Android Studio Arctic Fox (2020.3.1) or later
- Android SDK 21 or higher
- Kotlin 1.5.0 or higher

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/gnss-tracker.git
```

2. Open the project in Android Studio

3. Sync Gradle files

4. Run the app on an emulator or physical device with GPS capabilities

### Building

```bash
./gradlew build
```

## Usage

1. Launch the app
2. Grant location permission when prompted
3. View real-time satellite information including:
   - Satellite constellation (GPS, GLONASS, Galileo, etc.)
   - Signal strength (C/N0)
   - Azimuth and elevation angles
   - Satellite PRN/SVID numbers

## Architecture

This app follows the MVVM (Model-View-ViewModel) architecture pattern:

- **Model**: GNSS data from LocationManager
- **View**: Jetpack Compose UI (GnssScreen.kt)
- **ViewModel**: GnssViewModel.kt manages business logic and exposes UI state


## Acknowledgments

- Built with [Jetpack Compose](https://developer.android.com/jetpack/compose)
- Uses Android [Location APIs](https://developer.android.com/training/location)
