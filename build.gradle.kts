// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.1")

        val kotlinVersion = "1.5.21"
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

        val nav_version = "2.3.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
