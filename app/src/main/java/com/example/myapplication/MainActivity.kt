package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var number1 : EditText
    private lateinit var number2 : EditText
    private lateinit var resultNumber : TextView

    private lateinit var showResult : Button
    private lateinit var plusBtn : Button
    private lateinit var minusBtn : Button
    private lateinit var divBtn : Button
    private lateinit var multiplyBtn : Button
    private lateinit var clearBtn : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActivity()
    }





    private fun initActivity(){
        number1 = findViewById(R.id.input1)
        number2 = findViewById(R.id.input2)

        plusBtn = findViewById(R.id.plus)
        minusBtn = findViewById(R.id.minus)
        divBtn = findViewById(R.id.divide)
        multiplyBtn = findViewById(R.id.multiply)
        clearBtn = findViewById(R.id.clear)
        showResult = findViewById(R.id.result)


        val intent = Intent(this, ResultActivity::class.java)
        resultMethod(intent)
        add(intent)
        min(intent)
        div(intent)
        mult(intent)
        clear()

    }



    private fun resultMethod(intent: Intent){
        showResult.setOnClickListener{
            startActivity(intent)
        }
    }



    private fun clear(){
        clearBtn.setOnClickListener {
            number1.setText("")
            number2.setText("")
        }
    }


    private fun add(intent: Intent){
        plusBtn.setOnClickListener{
            if(number1.text.isEmpty() || number2.text.isEmpty()){
                intent.putExtra("answ", "Немає відповіді")
            }

            else
            {

                val lastNumber =
                    number1.text.toString().toFloat()+ number2.text.toString().toFloat()
                intent.putExtra("answ", lastNumber.toString())
            }
        }
    }




    private fun min(intent: Intent){
        minusBtn.setOnClickListener{
            if(number1.text.isEmpty() || number2.text.isEmpty()){
                intent.putExtra("answ", "Немає відповіді")
            }

            else {
                val lastNumber =
                    number1.text.toString().toFloat() - number2.text.toString().toFloat()
                intent.putExtra("answ", lastNumber.toString())
            }
        }
    }




    private fun mult(intent: Intent){
        multiplyBtn.setOnClickListener{
            if(number1.text.isEmpty() || number2.text.isEmpty()){
                intent.putExtra("answ", "Немає відповіді")
            }

            else {
                val lastNumber =
                    number1.text.toString().toFloat() * number2.text.toString().toFloat()
                intent.putExtra("answ", lastNumber.toString())
            }
        }
    }






    private fun div(intent: Intent){
        divBtn.setOnClickListener{
            if(number1.text.isEmpty() || number2.text.isEmpty() || number2.text.equals("0")){
                intent.putExtra("answ", "Немає відповіді")
            }

            else {
                val lastNumber =
                    number1.text.toString().toFloat() / number2.text.toString().toFloat()
                intent.putExtra("answ", lastNumber.toString())
            }
        }
    }

}