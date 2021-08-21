plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.tinswaterreminderapp"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    val nav_version = "2.3.5"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    val lifecycle_version = "2.4.0-alpha02"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    val dagger_version = "2.37"
    implementation("com.google.dagger:dagger:$dagger_version")
    kapt("com.google.dagger:dagger-compiler:$dagger_version")
    implementation("com.google.dagger:dagger-android-support:$dagger_version")
    kapt("com.google.dagger:dagger-android-processor:$dagger_version")

    val preference_version = "1.1.1"
    implementation("androidx.preference:preference-ktx:$preference_version")

    val moshi_version = "1.12.0"
    implementation("com.squareup.moshi:moshi:$moshi_version")
    implementation("com.squareup.moshi:moshi-kotlin:$moshi_version")

    val jetpack_compose = "1.0.1"
    implementation("androidx.compose.ui:ui:$jetpack_compose")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:$jetpack_compose")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:$jetpack_compose")
    // Material Design
    implementation("androidx.compose.material:material:$jetpack_compose")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:$jetpack_compose")
    implementation("androidx.compose.material:material-icons-extended:$jetpack_compose")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:$jetpack_compose")

    implementation("com.jakewharton.timber:timber:4.7.1")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$jetpack_compose")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
