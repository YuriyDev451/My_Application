package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragment.*

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var spinner: Spinner

        ArrayAdapter.createFromResource(
            this,
            R.array.array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            binding.spinner.adapter = adapter
        }

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> fragment(Fragment_for_three_bal(), R.id.place_holder_for_data_entry)

                    1 -> fragment(Fragment_for_four_bal(), R.id.place_holder_for_data_entry)

                    2 -> fragment(Fragment_for_five_bal(), R.id.place_holder_for_data_entry)

                    3 -> fragment(Fragment_for_six_bal(), R.id.place_holder_for_data_entry)

                    4 -> fragment(Fragment_for_seven_bal(), R.id.place_holder_for_data_entry)

                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }

    fun fragment(fragment: Fragment, id: Int) {

        supportFragmentManager
            .beginTransaction()
            .replace(id, fragment)
            .commit()
    }

}





