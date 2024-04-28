package com.route.week4_islami.api



import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiManager {
    private lateinit var retrofit:Retrofit
    init {
        // () to make custom logger make object from
        // httpLoggingInterceptor.Logger
        val logging = HttpLoggingInterceptor(
            object :HttpLoggingInterceptor.Logger{
                override fun log(message: String) {
                    Log.e("api",message)
                }

            }
        )
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client= OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        retrofit =Retrofit.Builder()
            .client(client)
            .baseUrl("http://mp3quran.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // return object of WebServices
    // return class return all abstract funs
    fun getServices():WebServices{
        return retrofit.create(WebServices::class.java)
    }
}