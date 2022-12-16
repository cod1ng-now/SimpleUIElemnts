package com.example.simpleuielements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import android.widget.RadioGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup()
        completeTextView()
    }

    private fun completeTextView() {
        val array = arrayOf("KOTLIN", "JAVA", "SWIFT", "DART", "PYTHON", "JAVASCRIPT", "C++", "C#")
        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteText)
        val multiAutoCompleteTextView: MultiAutoCompleteTextView = findViewById(R.id.multiCompleteText)
        val arrayAdapter=ArrayAdapter(this, android.R.layout.simple_list_item_1, array)

        autoCompleteTextView.setAdapter(arrayAdapter)

        multiAutoCompleteTextView.setAdapter(arrayAdapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

    }


    private fun radioGroup() {
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        radioGroup.setOnCheckedChangeListener{group, checkedId ->
            when(checkedId){
                R.id.red -> changeRadioGroupColor(group, R.color.red)
                R.id.blue -> changeRadioGroupColor(group, R.color.blue)
                R.id.green -> changeRadioGroupColor(group, R.color.green)
            }
        }
    }

    private fun changeRadioGroupColor(radioGroup: RadioGroup, @ColorRes colorId: Int){
        radioGroup.setBackgroundColor(
            ContextCompat.getColor(this, colorId)
        )
    }
}