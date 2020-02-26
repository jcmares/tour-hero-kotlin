package com.mares.testkotlin.net

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class  RetrofitBuilder {
    private val API_URL = "https://api.myjson.com/"
    private val logging : HttpLoggingInterceptor = HttpLoggingInterceptor()
    private val httpClient : OkHttpClient.Builder = OkHttpClient.Builder()

    init {
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(logging)
    }

    fun <T> createService(service : Class<T>) : T {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient.build())
            .build().create(service)
    }
}