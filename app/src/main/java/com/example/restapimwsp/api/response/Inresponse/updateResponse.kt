package com.example.restapimwsp.api.response.Inresponse

import com.google.gson.annotations.SerializedName

data class UpdateResponse(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)
