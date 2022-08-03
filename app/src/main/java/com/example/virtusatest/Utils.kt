package com.example.virtusatest

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
     fun setDateFormate(dateTo: String): String {
        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val output = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")

        var d: Date? = null
        try {
            d = input.parse("2018-02-02T06:54:57.744Z")
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val formatted = output.format(d)
        //Log.i("DATE", "" + formatted)
        return formatted
    }
}