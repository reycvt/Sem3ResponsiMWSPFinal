package com.example.restapimwsp.api.response.Inresponse

import com.google.gson.annotations.SerializedName

data class response(
    @SerializedName("error") val error:Boolean,
    @SerializedName("message") val message:String,
    @SerializedName("data") val data: List<Item>
)
data class Item(
    @SerializedName("nim") val nim:String,
    @SerializedName("nama") val nama:String,
    @SerializedName("jenis_kelamin") val jenisklamin:String,
    @SerializedName("prodi") val prodi:String
)
