package com.lomu.weather_app.fragment


import com.lomu.weather_app.R
import com.lomu.weather_app.manage.ManagerData
import com.lomu.weather_app.manage.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_fore_cast.*


class ForeCastFragment : BaseFragment(R.layout.fragment_fore_cast){
    override fun setup() {
     adapter()
    }

    private fun adapter() {
        val adapter= RecyclerAdapter(ManagerData.getForeCast())
        recyclerForecast.adapter=adapter
    }
}