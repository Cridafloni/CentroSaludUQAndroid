package com.uq.centro_salud.infraestructura.api

import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {

    //192.168.1.10

    val BASE_URL = "http://192.168.1.15:8000/"
    var retrofit: Retrofit? = null

    fun getRetrofitInstance():Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        }
        return retrofit
    }

    fun getApiService() = getRetrofitInstance()!!.create(InvetarioAPI::class.java)



}