package com.uq.centro_salud.dominio.dto


import com.google.gson.annotations.SerializedName

data class LoteResponseItem(
    @SerializedName("activo")
    val activo: Boolean,
    @SerializedName("cantidad_entrada")
    val cantidadEntrada: Int,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("fecha_ingreso")
    val fechaIngreso: String,
    @SerializedName("fecha_vencimiento")
    val fechaVencimiento: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lote_del_producto")
    val loteDelProducto: String,
    @SerializedName("producto")
    val producto: String
)