package com.uq.centro_salud.dominio.base

import android.app.Application
import android.content.Context
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class App : Application() {


    private var scheduler: Scheduler? = null


    fun subscribeScheduler(): Scheduler? {
        if (scheduler == null) {
            scheduler = Schedulers.io()
        }
        return scheduler
    }

    companion object {
        private fun get(context: Context): App? {
            return context.applicationContext as App
        }

        fun create(context: Context?): App? {
            return get(context!!)
        }
    }

}