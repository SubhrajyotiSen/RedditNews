package com.subhrajyoti.redditnews.features.news

import com.subhrajyoti.redditnews.api.NewsAPI
import com.subhrajyoti.redditnews.api.NewsRestAPI
import com.subhrajyoti.redditnews.commons.RedditNews
import com.subhrajyoti.redditnews.commons.RedditNewsItem
import rx.Observable

class NewsManager(private val apiNews: NewsAPI = NewsRestAPI()) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            subscriber ->
            val callResponse = apiNews.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news)

                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}