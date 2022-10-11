package com.example.myapplication.fragment

import android.app.Activity
import android.os.Bundle
import android.text.BoringLayout.make
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentForThreeBalBinding
import android.widget.Toast.makeText as makeText1


class Fragment_for_three_bal : Fragment() {


    lateinit var binding: FragmentForThreeBalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForThreeBalBinding.inflate(inflater)


        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.buttonResult.setOnClickListener(View.OnClickListener {
            if (!isEmptyEditText()) {
                binding.TVForResult.text = result()
            }
        })


    }




    private fun isEmptyEditText(): Boolean {


        binding.apply {
            if (editTextForBalOne.text.isNullOrEmpty()) editTextForBalOne.error =
                "Заполните поле значением от 1 до 100"
            if (editTextForKreditOne.text.isNullOrEmpty()) editTextForKreditOne.error =
                "Заполните поле"

            if (editTextForBalTwo.text.isNullOrEmpty()) editTextForBalTwo.error =
                "Заполните поле значением от 1 до 100"
            if (editTextForKreditTwo.text.isNullOrEmpty()) editTextForKreditTwo.error =
                "Заполните поле"

            if (editTextForBalThree.text.isNullOrEmpty()) editTextForBalThree.error =
                "Заполните поле значением от 1 до 100"
            if (editTextForKreditThree.text.isNullOrEmpty()) editTextForKreditThree.error =
                "Заполните поле"

            return editTextForBalOne.text.isNullOrEmpty()
                    || editTextForKreditOne.text.isNullOrEmpty()
                    || editTextForBalTwo.text.isNullOrEmpty()
                    || editTextForKreditTwo.text.isNullOrEmpty()
                    || editTextForBalThree.text.isNullOrEmpty()
                    || editTextForKreditThree.text.isNullOrEmpty()
        }
    }


    private fun result (): String {
        val balOne: Double
        val kreditOne: Double
        val balTwo: Double
        val kreditTwo: Double
        val balThree: Double
        val kreditThree: Double

        var result: Double = 0.0

            balOne = binding.editTextForBalOne.text.toString().toDouble()
            kreditOne = binding.editTextForKreditOne.text.toString().toDouble()

            balTwo = binding.editTextForBalTwo.text.toString().toDouble()
            kreditTwo = binding.editTextForKreditTwo.text.toString().toDouble()

            balThree = binding.editTextForBalThree.text.toString().toDouble()
            kreditThree = binding.editTextForKreditThree.text.toString().toDouble()

      //  if(balOne<=100 || balTwo <=100 || balThree<=100) {
            result = (((balOne*kreditOne)+(balTwo*kreditTwo)+(balThree*kreditThree))/(kreditOne+kreditTwo+kreditThree))
      //  }
      //  else{
       // }

        return result.toString()

    }


        companion object {
            @JvmStatic
            fun newInstance() = Fragment_for_three_bal()
        }



}

