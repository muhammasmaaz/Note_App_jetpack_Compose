package com.example.note_app_jetpack_compose

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.note_app_jetpack_compose.Model.Qoute
import com.google.gson.Gson

object DataManger {


    var data = emptyArray<Qoute>()
    var currentQuote:Qoute?=null
    var currentpage = mutableStateOf(Pages.LISTING)
    var isdataloaded = mutableStateOf(false)

    fun loadassertfromfile(context: Context) {



        val jf=BuildConfig.json
        val inputStream = context.assets.open(jf)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Qoute>::class.java)

        isdataloaded.value = true

    }

    fun switchPages(quote: Qoute?) {
        if (currentpage.value == Pages.LISTING) {
            currentQuote=quote
            currentpage.value=Pages.DETAIL
        }else
        {
            currentpage.value=Pages.LISTING
        }
    }
}