package com.lomu.weather_app.manage

import com.lomu.weather_app.data.ForeCast
import com.lomu.weather_app.data.Result
import java.util.*

object ManagerData {
private val foreCast=LinkedList<ForeCast>()
private var result: Result?=null
    fun addForeCast(list:LinkedList<ForeCast>){
        foreCast.removeAll(foreCast)
        foreCast.addAll(list)
    }

    fun getForeCast()= foreCast

    fun addResult(list: Result){
       result =list
    }

    fun getResult()= result

}