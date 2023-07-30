package com.lomu.weather_app.fragment



import com.lomu.weather_app.R
import com.lomu.weather_app.manage.ManagerData
import kotlinx.android.synthetic.main.fragment_to_day.*


class ToDayFragment  : BaseFragment(R.layout.fragment_to_day){
    override fun setup() {
        setData()
    }
    private fun setData() {
        val result = ManagerData.getResult()
        cityNameId.text = result?.city_name
        dateTextId.text = result?.date
        tempId.text = result?.temp.toString()
        windId.text = result?.wind_speedy
        humidityId.text = "${result?.humidity}%"
    }
}