package com.example.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentForFourBalBinding


class Fragment_for_four_bal : Fragment() {


    lateinit var binding: FragmentForFourBalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForFourBalBinding.inflate(inflater)
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
            if (editTextForBalFour.text.isNullOrEmpty()) editTextForBalFour.error =
                "Заполните поле значением от 1 до 100"
            if (editTextForKreditFour.text.isNullOrEmpty()) editTextForKreditFour.error =
                "Заполните поле"

            return editTextForBalOne.text.isNullOrEmpty()
                    || editTextForKreditOne.text.isNullOrEmpty()
                    || editTextForBalTwo.text.isNullOrEmpty()
                    || editTextForKreditTwo.text.isNullOrEmpty()
                    || editTextForBalThree.text.isNullOrEmpty()
                    || editTextForKreditThree.text.isNullOrEmpty()
                    || editTextForBalFour.text.isNullOrEmpty()
                    || editTextForKreditFour.text.isNullOrEmpty()


        }
    }


       private fun result(): String {
            val balOne: Double
            val kreditOne: Double
            val balTwo: Double
            val kreditTwo: Double
            val balThree: Double
            val kreditThree: Double
            val balFour: Double
            val kreditFour: Double

            binding.apply {
                balOne = editTextForBalOne.text.toString().toDouble()
                kreditOne = editTextForKreditOne.text.toString().toDouble()

                balTwo = editTextForBalTwo.text.toString().toDouble()
                kreditTwo = editTextForKreditTwo.text.toString().toDouble()

                balThree = editTextForBalThree.text.toString().toDouble()
                kreditThree = editTextForKreditThree.text.toString().toDouble()

                balFour = editTextForBalFour.text.toString().toDouble()
                kreditFour = editTextForKreditFour.text.toString().toDouble()

                return (((balOne * kreditOne) + (balTwo * kreditTwo) + (balThree * kreditThree) + (balFour * kreditFour)) / (kreditOne + kreditTwo + kreditThree + kreditFour)).toString()
            }

        }



        companion object {
            @JvmStatic
            fun newInstance() = Fragment_for_four_bal()
        }
    }
