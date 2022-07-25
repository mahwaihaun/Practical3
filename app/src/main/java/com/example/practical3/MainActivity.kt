package com.example.practical3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practical3.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    //TODO 2: Create san instance of View Binding
    //lateinit = late initialize
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO 3: Initialize binding object
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val agePosition = binding.spinnerAge.selectedItemPosition
            val gender = binding.radioGroupGender.checkedRadioButtonId
            val smoker = binding.checkboxIsSmoker.isChecked
            var premium = when (agePosition) {
                0 -> 60
                1 -> 70
                2 -> 90
                3 -> 120
                4, 5 -> 150
                else -> 0
            }
            var extraPaymentMale = when (agePosition) {
                0 -> 0
                1 -> 50
                2 -> 100
                3 -> 150
                4, 5 -> 200
                else -> 0
            }

            var extraPaymentSmoker = when (agePosition) {
                0 -> 0
                1 -> 100
                2 -> 150
                3 -> 200
                4 -> 250
                5 -> 300
                else -> 0

            }
            if (gender == binding.radioButtonMale.id) {
                premium += extraPaymentMale
            }
            if (smoker) {
                premium += extraPaymentSmoker
            }
            val premiumOutput = NumberFormat.getCurrencyInstance().format(premium)
            binding.textViewPremium.text = premiumOutput

        }

        binding.btnReset.setOnClickListener {
            binding.spinnerAge.setSelection(0)
            binding.radioGroupGender.clearCheck()
            binding.checkboxIsSmoker.isChecked=false
            binding.textViewPremium.text = ""
        }
    }
}