package com.example.bismilahcrud.model

import com.google.gson.annotations.SerializedName

data class ResultStaff (
    @field:SerializedName("pesan")
    val pesan: String? = null,

    @field:SerializedName("staff")
    val staff: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)