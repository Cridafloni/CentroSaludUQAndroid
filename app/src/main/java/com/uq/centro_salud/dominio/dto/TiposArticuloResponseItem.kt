package com.uq.centro_salud.dominio.dto


import com.google.gson.annotations.SerializedName

data class TiposArticuloResponseItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("fecha_registro")
    val fechaRegistro: String,
    @SerializedName("material")
    val material: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("presentacion")
    val presentacion: String,
    @SerializedName("proveedor")
    val proveedor: String,
    @SerializedName("registro_invima")
    val registroInvima: String,
    @SerializedName("tipo")
    val tipo: String
)