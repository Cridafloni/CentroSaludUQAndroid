package com.uq.centro_salud.presentacion.adapter

import com.uq.centro_salud.infraestructura.db.Entities.ArticulosEntity

interface OnItemClick {
    fun onItemClick(articulosEntity: ArticulosEntity)
}