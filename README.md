![kotlin-version](https://img.shields.io/badge/kotlin-2.0.0-blue?logo=kotlin)

Kotlin Multiplatform sample (with Compose) to demonstrate Gemini Generative AI APIs (text and image based queries). 
Uses [Generative AI SDK](https://github.com/PatilShreyas/generative-ai-kmp).


Running on
* iOS 
* Android

## Structure

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


## Environment setup

Follow more [here](https://www.jetbrains.com/help/kotlin-multiplatform-dev/compose-multiplatform-setup.html)

## Gemini API Setup

Google AI Studio Key (for prototyping)

* Get API Key by following [this guide](https://ai.google.dev/tutorials/setup) from Google AI Studio
* Use `apiKey` in `SportsViewModel`.

## Firebase Setup

_Work in progress_

Add GoogleService-Info.plist and GoogleService-Info.json file for Android and iOS

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)