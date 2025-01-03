package com.example.joku_battle

import android.app.Application
import com.example.joku_battle.api.TokenManager

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        TokenManager.init(this)
    }
}