package com.lomu.weather_app.activity


import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.lomu.weather_app.R
import com.lomu.weather_app.data.Information
import com.lomu.weather_app.fragment.ForeCastFragment
import com.lomu.weather_app.fragment.ToDayFragment
import com.lomu.weather_app.manage.ManagerData
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException


class MainActivity : BaseActivity(R.layout.activity_main){
    private val client=OkHttpClient()
    override fun setup() {
        setFragment(ToDayFragment())
        callback()
        okHttpRequestToGetData()
    }

    private fun okHttpRequestToGetData() {
        val request=Request.Builder().url("https://api.hgbrasil.com/weather").build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
               val data=response.body?.string()
               val gson=Gson()
               val dataFormat= gson.fromJson(data, Information::class.java)
               ManagerData.apply {
                   addForeCast(dataFormat.results.forecast)
                   addResult(dataFormat.results)
               }
            }
        })
    }

    private fun callback() {
        navId.setOnItemSelectedListener {
          executeCodeClickOnNav(it)
        }
    }

    private fun executeCodeClickOnNav(it:MenuItem)=run{
        when(it.itemId){
            R.id.homeId->{
                setFragment(ToDayFragment())
            }
            else->{
                setFragment(ForeCastFragment())
            }
        }
     true
    }

    private fun setFragment(fragment: Fragment){
        val trans=supportFragmentManager.beginTransaction()
        trans.replace(R.id.fragmentId,fragment)
        trans.commit()
    }
}
