// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0")
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")

    }
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
    id("com.google.devtools.ksp") version "1.8.21-1.0.11" apply false

}
