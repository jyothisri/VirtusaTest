package com.example.virtusatest

import retrofit2.Call
import retrofit2.http.GET

interface ApicalInterface {

        @GET("/api/v1/people")
         fun getPeoples() : Call<List<GetPeople>>
    @GET("/api/v1/rooms")
    fun getRooms() : Call<List<GetRoomsData>>

}