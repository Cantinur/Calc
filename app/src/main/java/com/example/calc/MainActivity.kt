package com.example.calc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var currentDisplayValue: String = "0"
    private var hasComma = false
    private var isNegative = false
    private val brain = CalculatorBrain()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCalc.text = currentDisplayValue

        btn0.setOnClickListener { numberBtnClick(btn0.text.toString()) }
        btn1.setOnClickListener { numberBtnClick(btn1.text.toString()) }
        btn2.setOnClickListener { numberBtnClick(btn2.text.toString()) }
        btn3.setOnClickListener { numberBtnClick(btn3.text.toString()) }
        btn4.setOnClickListener { numberBtnClick(btn4.text.toString()) }
        btn5.setOnClickListener { numberBtnClick(btn5.text.toString()) }
        btn6.setOnClickListener { numberBtnClick(btn6.text.toString()) }
        btn7.setOnClickListener { numberBtnClick(btn7.text.toString()) }
        btn8.setOnClickListener { numberBtnClick(btn8.text.toString()) }
        btn9.setOnClickListener { numberBtnClick(btn9.text.toString()) }

        btnComma.setOnClickListener {
            if (!hasComma) {
                currentDisplayValue = currentDisplayValue.plus('.')
                println(currentDisplayValue)
                txtCalc.text = currentDisplayValue
                hasComma = true
            }
        }

        funReset.setOnClickListener {
            brain.reset()
            currentDisplayValue = "0"
            txtCalc.text = currentDisplayValue
            hasComma = false
        }

        funChange.setOnClickListener {
            currentDisplayValue = if (!isNegative) "-$currentDisplayValue" else currentDisplayValue.removePrefix("-")
            isNegative = !isNegative
            txtCalc.text = currentDisplayValue
        }

        funDiv.setOnClickListener { doCalculation('/') }
        funPluss.setOnClickListener { doCalculation('+') }
        funMin.setOnClickListener { doCalculation('-') }
        funMulti.setOnClickListener { doCalculation('x') }


        funEqual.setOnClickListener{
            val result = brain.equals( txtCalc.text.toString().toDouble() )
            currentDisplayValue = result.toString()
            txtCalc.text = currentDisplayValue
            currentDisplayValue = "0"
            hasComma = false
        }

    }

    private fun doCalculation( operator: Char ){
        brain.addNumberAndOperator(txtCalc.text.toString().toDouble(), operator)
        currentDisplayValue = "0"
        hasComma = false
    }

    private fun numberBtnClick(text: String){
        currentDisplayValue =  if (currentDisplayValue == "0") text else currentDisplayValue.plus(text)
        txtCalc.text = currentDisplayValue
    }
}
