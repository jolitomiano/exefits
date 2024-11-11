plugins {
    alias(libs.plugins.android.application) // Version catalog for Android application plugin
    alias(libs.plugins.kotlin.android)     // Version catalog for Kotlin plugin
}

android {
    namespace = "com.sample.exefitness"
    compileSdk = 35 // Compiling against the latest Android API level

    defaultConfig {
        applicationId = "com.sample.exefitness"
        minSdk = 26 // Minimum supported Android version
        targetSdk = 35 // Target the latest Android API level for runtime compatibility
        versionCode = 1 // Version code for the app
        versionName = "1.0" // Version name for the app

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true // Enable support for vector drawables
    }

    buildTypes {
        release {
            isMinifyEnabled = false // Disable code shrinking for release builds
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 // Use Java 17
        targetCompatibility = JavaVersion.VERSION_17 // Use Java 17
    }

    kotlinOptions {
        jvmTarget = "17" // Target Java 17 for Kotlin
    }

    buildFeatures {
        compose = true // Enable Jetpack Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.9.10" // Latest Kotlin Compiler Extension for Compose
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}" // Exclude unnecessary files from the APK
        }
    }
}

dependencies {
    // Core Android dependencies
    implementation(libs.androidx.core.ktx) // Core KTX library for concise Android development
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle support for Kotlin
    implementation(libs.androidx.activity.compose) // Compose support for activities

    // Jetpack Compose dependencies
    implementation(platform(libs.androidx.compose.bom)) // BOM to manage Compose versions
    implementation("androidx.compose.ui:ui") // Compose UI library
    implementation("androidx.compose.ui:ui-tooling-preview") // Compose tooling previews
    implementation("androidx.compose.material3:material3") // Material 3 support
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose") // ViewModel support for Compose

    // Navigation for Jetpack Compose
    implementation("androidx.navigation:navigation-compose:2.8.4") // Navigation component for Compose

    // Testing dependencies
    testImplementation(libs.junit) // Unit testing with JUnit
    androidTestImplementation(libs.androidx.junit) // Android JUnit extension
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose BOM for testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4") // Compose UI testing

    // Debugging dependencies
    debugImplementation("androidx.compose.ui:ui-tooling") // Debugging tools for Compose UI
    debugImplementation("androidx.compose.ui:ui-test-manifest") // Compose test manifest debugging
}
