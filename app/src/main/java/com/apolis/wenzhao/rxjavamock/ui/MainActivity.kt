package com.apolis.wenzhao.rxjavamock.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.apolis.wenzhao.rxjavamock.R
import com.apolis.wenzhao.rxjavamock.adapter.AdapterRecyclerView
import com.apolis.wenzhao.rxjavamock.databinding.ActivityMainBinding
import com.apolis.wenzhao.rxjavamock.viewmodel.PropertyViewModel

class MainActivity : AppCompatActivity() {

    lateinit var propertyViewModel: PropertyViewModel
    lateinit var binding: ActivityMainBinding
    private val mAdapter: AdapterRecyclerView = AdapterRecyclerView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        propertyViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(PropertyViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initList()
        observerData()
    }

    override fun onStart() {
        super.onStart()
        propertyViewModel.getData()
    }

    private fun initList(){
        binding.recyclerView.apply {
            adapter = mAdapter
        }
    }

    private fun observerData(){
        propertyViewModel.getPropertyObserver().observe(this, Observer {
            if(it != null){
                mAdapter.setData(it)
            }
        })
    }
}