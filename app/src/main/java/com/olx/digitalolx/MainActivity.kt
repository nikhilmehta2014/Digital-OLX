package com.olx.digitalolx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.afdhal_fa.imageslider.model.SlideUIModel
import com.olx.digitalolx.databinding.ActivityMainBinding
import com.olx.digitalolx.util.hideKeyboard

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()

        setClickListeners()
        addItemsToSpinner()
        setupSlider()
    }

    private fun setClickListeners() {
        binding.ivSearchSubmit.setOnClickListener {
            hideKeyboard()
        }
    }

    private fun addItemsToSpinner() {
        val searchCategories = mutableListOf<String>()
        searchCategories.add("Car")
        searchCategories.add("Store")
        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, searchCategories)
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spSearch.adapter = dataAdapter
    }

    private fun setupSlider() {
        val bannerList = mutableListOf<SlideUIModel>()
        bannerList.add(SlideUIModel("https://s.id/Ccoeo", "1"))
        bannerList.add(SlideUIModel("https://s.id/Ccoeo", "2"))
        bannerList.add(SlideUIModel("https://s.id/Ccoeo", "3"))
        binding.bannerMain.setImageList(bannerList)
    }
}