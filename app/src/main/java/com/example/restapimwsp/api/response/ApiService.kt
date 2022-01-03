package com.example.restapimwsp.api.response
//sesuaikan dengan folder atau class yang kalian buat

import com.example.restapimwsp.api.response.Inresponse.InStatustResponse
import com.example.restapimwsp.api.response.Inresponse.ParticipantResponse
import com.example.restapimwsp.api.response.Inresponse.UpdateResponse

//import dari library retrofit
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("read.php")
    fun getWebinar(): Call<ParticipantResponse>

    @FormUrlEncoded
    @POST("create.php")
    fun insertWebinar(
        @Field("nim") nim: String,
        @Field("nama") nama: String,
        @Field("jenis_kelamin") jenisKelamin: String,
        @Field("prodi") prodi: String,
    ): Call<InStatustResponse>

    @FormUrlEncoded
    @POST("update.php")
    fun updateWebinar(
//        @Path("id") id : Int,
        @Field("nim") nim: String,
        @Field("nama") nama: String?,
        @Field("jenis_kelamin") jenisKelamin: String?,
        @Field("prodi") prodi: String?,
    ): Call<UpdateResponse>

    @GET("delete.php")
    fun deleteWebinar(
        @Query("nim")nim: String
    ): Call<ParticipantResponse>

}