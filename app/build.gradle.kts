plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-parcelize")
    id ("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.marvelcadu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.marvelcadu"
        minSdk = 24
        targetSdk = 31
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Timber
    implementation ("com.jakewharton.timber:timber:5.0.1")


    // Hilt
    implementation ("com.google.dagger:hilt-android:2.45")
    implementation ("androidx.room:room-runtime:2.5.2")
    implementation ("androidx.room:room-ktx:2.5.2")
    implementation ("com.google.dagger:hilt-android:2.37")
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    ksp("androidx.room:room-compiler:2.5.0")
    ksp ("com.google.dagger:dagger-compiler:2.45") // Dagger compiler
    ksp ("com.google.dagger:hilt-compiler:2.45")   // Hilt compiler
    ksp ("androidx.hilt:hilt-compiler:1.0.0")
    ksp("com.google.devtools.ksp:symbol-processing-api:1.5.30")

// Glide
    implementation("com.github.bumptech.glide:glide:4.15.0")
    ksp("com.github.bumptech.glide:ksp:4.15.0")
    implementation("com.github.bumptech.glide:okhttp3-integration:4.15.0")

    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.3.1")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")

    // Activity and Fragment KTX for viewModels()
    implementation ("androidx.activity:activity-ktx:1.3.0")
    implementation ("androidx.fragment:fragment-ktx:1.3.6")

    // Architectural Components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")

    // Navigation Components
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.5")





}