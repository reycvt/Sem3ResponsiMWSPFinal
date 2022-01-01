package com.example.restapimwsp.api.response.Inresponse

import com.google.gson.annotations.SerializedName

data class ParticipantResponse(

	@field:SerializedName("data")
	val data: List<DataItem>,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)

data class DataItem(

	@field:SerializedName("nim")
	val nim: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: String,

	@field:SerializedName("prodi")
	val prodi: String
)
