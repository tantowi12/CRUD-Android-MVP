package com.example.bismilahcrud.network

import com.example.bismilahcrud.model.ResultStaff
import com.example.bismilahcrud.model.ResultStatus
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

object NetworkConfig {

    fun getInterceptor() : OkHttpClient{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return okHttpClient
    }

    //retrofit

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()

            .baseUrl()
            .Client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create()).build()
            .build()
    }

    fun getService() = getRetrofit().create(StaffService::class.java)
}

interface StaffService{
    // fungsi create data
    @FormUrlEncoded
    @POST("addStaff")
    fun addStaff(@Field("name") name : String,
    @Field("hp") hp :String,
    @Field("alamat") alamat : String) : Call<ResultStatus>

    // fungsi get data
    @GET("getDataStaff")

    fun getData() : Call<ResultStaff>

    // fungsi delete data
    @FormUrlEncoded
    @@POST("deleteStaff")
    fun deleteStaff(@Field("deleteStaff") id: String?) : Call<ResultStatus>

    // fungsi update data
    @FormUrlEncoded
    @POST("updateStaff")
    fun updateStaff(@Field("id") id: String,
    @Field("name") name: String,
    @Field("hp") hp : String,
    @Field("alamat") alamat : String) : Call<ResultStatus>
}