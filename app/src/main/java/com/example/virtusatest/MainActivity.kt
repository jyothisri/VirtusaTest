package com.example.virtusatest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var mApiService: ApicalInterface
    lateinit var listAdapter: ListAdapter
    var arrayListPeople: ArrayList<GetPeople> = arrayListOf()
    var arrayListRooms: ArrayList<GetRoomsData> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mApiService = ApiRetrofit.client.create(ApicalInterface::class.java)
        rv_list.layoutManager = LinearLayoutManager(this)

        // arrayList.add(GetResponseList("test","test","createAt",1,true,"tag","title"))

        // getDetailsListCal()
        getPeopleDetailsListCal()

        listAdapter = ListAdapter(this, arrayListPeople,arrayListRooms)

    }


    private fun getPeopleDetailsListCal() {
        var mApiService: ApicalInterface = ApiRetrofit.client.create(ApicalInterface::class.java)
        val call = mApiService.getPeoples()
        call.enqueue(object : Callback<List<GetPeople>> {

            override fun onResponse(
                call: Call<List<GetPeople>>,
                response: Response<List<GetPeople>>
            ) {
                Log.d("Jyothi", "Total List: " + response.body())
                val result = response.body()
                if (result != null) {
                    for (item in result)
                        arrayListPeople.add(
                            GetPeople(
                                item.createdAt, item.firstName, item.avatar, item.lastName,
                                item.email, item.jobtitle, item.favouriteColor,item.id
                            )
                        )
                }
                getRoomsDetailsListCal()
            }

            override fun onFailure(call: Call<List<GetPeople>>, t: Throwable) {
                Log.e("Jyothi", "Got error : " + t.localizedMessage)

            }

        })

    }
    private fun getRoomsDetailsListCal() {
        var mApiService: ApicalInterface = ApiRetrofit.client.create(ApicalInterface::class.java)
        val call = mApiService.getRooms()
        call.enqueue(object : Callback<List<GetRoomsData>> {

            override fun onResponse(
                call: Call<List<GetRoomsData>>,
                response: Response<List<GetRoomsData>>
            ) {
                Log.d("Jyothi", "Total List: " + response.body())
                val result = response.body()
                if (result != null) {
                    for (item in result)
                        arrayListRooms.add(
                            GetRoomsData(
                                item.createdAt, item.isOccupied, item.maxOccupancy, item.id
                            )
                        )
                }
                if (arrayListRooms != null && arrayListPeople!= null) {
                    rv_list!!.adapter = listAdapter
                }
            }

            override fun onFailure(call: Call<List<GetRoomsData>>, t: Throwable) {
                Log.e("Jyothi", "Got error : " + t.localizedMessage)

            }

        })

    }
}