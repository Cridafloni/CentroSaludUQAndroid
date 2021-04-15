package com.uq.centro_salud.dominio.dto.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("key")
    val key: String
)