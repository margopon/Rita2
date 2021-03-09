package com.example.rita2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener { setTextFields("0",true) }
        btn_1.setOnClickListener { setTextFields("1",true) }
        btn_2.setOnClickListener { setTextFields("2",true) }
        btn_3.setOnClickListener { setTextFields("3",true)}
        btn_4.setOnClickListener { setTextFields("4",true)}
        btn_5.setOnClickListener { setTextFields("5",true)}
        btn_6.setOnClickListener { setTextFields("6",true)}
        btn_7.setOnClickListener { setTextFields("7",true)}
        btn_8.setOnClickListener { setTextFields("8",true)}
        btn_9.setOnClickListener { setTextFields("9",true)}
        btn_dot.setOnClickListener { setTextFields(".",true) }

        btn_minus.setOnClickListener { setTextFields("-",false)}
        btn_plus.setOnClickListener { setTextFields("+",false)}
        btn_mult.setOnClickListener { setTextFields("*",false)}
        btn_div.setOnClickListener { setTextFields("/",false)}
        btn_open.setOnClickListener { setTextFields("(",false)}
        btn_close.setOnClickListener { setTextFields(")",false)}

        btn_ac.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }
        btn_back.setOnClickListener {
            val str = math_operation.text.toString()
            if(str.isNotEmpty()) {
                math_operation.text = str.substring(0, str.length - 1)
            result_text.text = ""
            }
        }
        btn_equal.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            } catch (e:Exception) {
                Log.d("Error", "message: ${e.message}")
            }
        }
    }
    fun setTextFields(str: String, ochistka: Boolean)
    {
        if(result_text.text.isNotEmpty()) {
            math_operation.text = ""
        }

        if(ochistka)
        {
            result_text.text = ""
            math_operation.append(str)
    }
        else
        {
            math_operation.append(result_text.text)
            math_operation.append(str)
            result_text.text = ""
        }
    }
}