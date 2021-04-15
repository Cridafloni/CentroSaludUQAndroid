package com.uq.centro_salud.infraestructura.api

import com.uq.centro_salud.dominio.dto.*
import com.uq.centro_salud.dominio.dto.login.LoginRequest
import com.uq.centro_salud.dominio.dto.login.LoginResponse
import com.uq.centro_salud.infraestructura.db.Entities.ArticulosEntity
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*


interface InvetarioAPI {

    @FormUrlEncoded
    @POST("products-byType/")
    fun getProductsByType(@Field("invima") invima: String): Observable<TiposArticuloResponse>

    @GET("api-rest/products-all/")
    fun getallArticles(@Header("Authorization") authorization:String): Observable<List<ArticulosEntity>>

    @FormUrlEncoded
    @POST("api-rest/lote-byInvima/")
    fun getlotes(@Header("Authorization") authorization:String, @Field("invima") invima: String): Observable<LoteResponse>


    @FormUrlEncoded
    @POST("lote-salidas/")
    fun getSalidas(@Field("invima") invima: String): Observable<LoteSalidaResponse>


    @FormUrlEncoded
    @POST("lote-entradas/")
    fun getEntradas(@Field("invima") invima: String): Observable<LoteEntradaResponse>


    @POST("rest-auth/login/")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>



}