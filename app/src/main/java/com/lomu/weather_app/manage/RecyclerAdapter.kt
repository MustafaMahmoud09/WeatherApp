package com.lomu.weather_app.manage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lomu.weather_app.R
import com.lomu.weather_app.data.ForeCast
import java.util.*

class RecyclerAdapter (private val list:LinkedList<ForeCast>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
     abstract class ViewHolder(item:View):RecyclerView.ViewHolder(item) {
     abstract val date:TextView
     abstract val max:TextView
     abstract val min:TextView
    }

    class HolderOne(item: View): ViewHolder(item){
         override val date:TextView=item.findViewById(R.id.dateItemId)
         override val max:TextView=item.findViewById(R.id.maxId)
         override val min:TextView=item.findViewById(R.id.minId)
    }
    class HolderTwo(item: View): ViewHolder(item){
        override val date:TextView=item.findViewById(R.id.dateItemTwoId)
        override val max:TextView=item.findViewById(R.id.maxTwoId)
        override val min:TextView=item.findViewById(R.id.minTwoId)
    }

    override fun getItemViewType(position: Int)=position%2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=when(viewType){
        ONE_TYPE -> HolderOne(LayoutInflater.from(parent.context).inflate(R.layout.ui_item_list_one,parent,false))
        else-> HolderTwo(LayoutInflater.from(parent.context).inflate(R.layout.ui_item_list_two,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      setData(holder,position)
    }

    private fun setData(holder: ViewHolder, position: Int) {
    val foreCast= list[position]
    holder.date.text=foreCast.date
    holder.min.text=foreCast.min.toString()
    holder.max.text=foreCast.max.toString()
    }

    override fun getItemCount()=list.size
    companion object{
        private const val ONE_TYPE=0
        private const val TWO_TYPE=1
    }
}