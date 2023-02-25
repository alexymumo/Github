package com.codes.githubapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GithubApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}