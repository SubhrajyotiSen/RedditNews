package com.subhrajyoti.redditnews.di.news

import com.subhrajyoti.redditnews.di.AppModule
import com.subhrajyoti.redditnews.di.NetworkModule
import com.subhrajyoti.redditnews.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class)
)
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)

}