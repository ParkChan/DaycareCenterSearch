package com.laonsports.kids.network.retrofit

import com.laonsports.kids.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun RetrofitBuilder(baseUrl: String, okHttpClient: OkHttpClient): Retrofit {
    val retrofitBuilder = Retrofit.Builder()
    retrofitBuilder.baseUrl(baseUrl)
    retrofitBuilder.addConverterFactory(GsonConverterFactory.create())
    retrofitBuilder.client(okHttpClient)
    retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    return retrofitBuilder.build()
}

fun getOkHttpClient(): OkHttpClient {
    val okHttpClient = OkHttpClient.Builder()
    okHttpClient.addNetworkInterceptor(getLogInterceptor())
    return okHttpClient.build()
}

private fun getLogInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (BuildConfig.DEBUG)
        HttpLoggingInterceptor.Level.BODY
    else
        HttpLoggingInterceptor.Level.NONE
    return logging
}