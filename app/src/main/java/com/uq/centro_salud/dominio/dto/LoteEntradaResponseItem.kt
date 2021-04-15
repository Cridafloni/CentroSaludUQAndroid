package com.uq.centro_salud.dominio.dto


import com.google.gson.annotations.SerializedName

data class LoteEntradaResponseItem(
    @SerializedName("cantidad_entrante")
    val cantidadEntrante: Int,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("fecha_entrada")
    val fechaEntrada: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("producto")
    val producto: Int
)