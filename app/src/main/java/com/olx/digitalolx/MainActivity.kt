package com.olx.digitalolx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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
}