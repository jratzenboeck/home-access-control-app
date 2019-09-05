package com.example.homeaccesscontrol.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.*
import java.io.IOException

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = fetchJSON()
    }
    private val _marc = MutableLiveData<String>().apply {
        value = "Marc is cool"
    }
    private val _pushMe = MutableLiveData<String>().apply {
        value = "Push me baby girl"
    }
    val text: LiveData<String> = _text
    val marc: LiveData<String> = _marc
    val pushMe: LiveData<String> = _pushMe
}

fun fetchJSON(): String {
    val url = "https://dog.ceo/api/breeds/image/random"

    val request = Request.Builder().url(url).build()

    var client = OkHttpClient()
    var theResponse = ""

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            theResponse = "Failed to execute request"
        }

        override fun onResponse(call: Call, response: Response) {
            val body = response.body?.string()
            theResponse = body.toString()
        }
    })
    return theResponse
}
