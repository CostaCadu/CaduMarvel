package com.example.marvelcadu


import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelApplication : Application(){

    override fun onCreate() {
        super.onCreate()

    }
}