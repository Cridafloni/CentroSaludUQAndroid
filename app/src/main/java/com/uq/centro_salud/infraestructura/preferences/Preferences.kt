package com.uq.centro_salud.infraestructura.preferences

import android.content.Context

object Preferences {

    private const val PREF_ID = "csu_pref"
    private const val APITOKEN = "API_TOKEN"

    fun putToken(context: Context, value: String) {
        context.getSharedPreferences(PREF_ID, Context.MODE_PRIVATE)
            .edit().putString(APITOKEN, value).apply()
    }

    fun getToken(context: Context): String {
        return context.getSharedPreferences(PREF_ID, Context.MODE_PRIVATE)
            .getString(APITOKEN, "") ?: ""
    }
}