package com.apolis.wenzhao.rxjavamock.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apolis.wenzhao.rxjavamock.databinding.RowAdapterRecyclerViewBinding
import com.apolis.wenzhao.rxjavamock.model.PropertyData

class AdapterRecyclerView (val context: Context) : RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder> () {

    private val listProperty = ArrayList<PropertyData>()

    inner class MyViewHolder(private val binding: RowAdapterRecyclerViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(propertyData: PropertyData){
            binding.propertyData = propertyData
            binding.executePendingBindings()
            binding.adapter = this@AdapterRecyclerView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowAdapterRecyclerViewBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listProperty.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listProperty[position])
    }

    fun setData(list: List<PropertyData>){
        listProperty.clear()
        listProperty.addAll(list)
        notifyDataSetChanged()
    }
}