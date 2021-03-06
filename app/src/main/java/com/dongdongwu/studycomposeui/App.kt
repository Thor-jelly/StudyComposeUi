package com.dongdongwu.studycomposeui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * 创建人：吴冬冬<br/>
 * 创建时间：2022/1/26 10:49 <br/>
 */
@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var app: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}