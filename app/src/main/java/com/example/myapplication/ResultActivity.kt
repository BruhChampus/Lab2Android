package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity:AppCompatActivity(){

    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.result_layout)
        textResult = findViewById(R.id.resultNumber)
        textResult.setText(intent.getStringExtra("answ").toString())

    }
}
