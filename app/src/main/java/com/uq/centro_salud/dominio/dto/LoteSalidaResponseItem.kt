package com.uq.centro_salud.dominio.dto


import com.google.gson.annotations.SerializedName

data class LoteSalidaResponseItem(
    @SerializedName("cantidad_salida")
    val cantidadSalida: Int,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("fecha_salida")
    val fechaSalida: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lote")
    val lote: Int
)