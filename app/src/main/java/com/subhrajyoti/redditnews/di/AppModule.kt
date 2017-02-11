package com.subhrajyoti.redditnews.di

import android.content.Context
import com.subhrajyoti.redditnews.MyApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: MyApp) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app;
    }

    @Provides
    @Singleton
    fun provideApplication(): MyApp {
        return app;
    }
}