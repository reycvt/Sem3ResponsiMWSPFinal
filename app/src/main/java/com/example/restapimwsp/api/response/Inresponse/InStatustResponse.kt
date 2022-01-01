package com.example.restapimwsp.api.response.Inresponse

import com.google.gson.annotations.SerializedName

data class InStatustResponse(

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
)
