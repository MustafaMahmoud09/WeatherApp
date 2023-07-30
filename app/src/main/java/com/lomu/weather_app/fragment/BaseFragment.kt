package com.lomu.weather_app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment(private val idLayout:Int):Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(idLayout,container,false)
    }

    override fun onStart() {
        super.onStart()
        setup()
    }
    abstract fun setup()
}