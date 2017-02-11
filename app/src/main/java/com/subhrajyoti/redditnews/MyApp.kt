package com.subhrajyoti.redditnews

import android.app.Application
import com.subhrajyoti.redditnews.di.AppModule
import com.subhrajyoti.redditnews.di.news.DaggerNewsComponent
import com.subhrajyoti.redditnews.di.news.NewsComponent

class MyApp : Application() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}