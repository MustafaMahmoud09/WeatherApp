package com.lomu.weather_app.data


data class Information(val by:String, val valid_key:Boolean, val results: Result, val execution_time:Double, val from_cache:Boolean)