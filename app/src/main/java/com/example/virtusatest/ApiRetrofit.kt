package com.example.virtusatest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRetrofit {
//`https://
//61e947967bc0550017bc61bf.mockapi.io/api/v1/
        private val BASE_URL = "https://61e947967bc0550017bc61bf.mockapi.io"
        private var mRetrofit: Retrofit? = null


        val client: Retrofit
            get() {
                if (mRetrofit == null) {
                    mRetrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return this.mRetrofit!!
            }

}