package com.lomu.weather_app.data

import com.lomu.weather_app.data.ForeCast
import java.util.*

data class Result(val temp:Int,val date:String,val time:String,val condition_code:String,
                  val description:String,val currently:String,val cid:String,val city:String,val img_id:String,val humidity:Int
                  ,val cloudiness:Double,val rain:Double,val wind_speedy:String,val wind_direction:Int,val sunrise:String,
                   val condition_slug:String,val city_name:String,val forecast:LinkedList<ForeCast>)
