package com.example.calc

class CalculatorBrain {
    private var firstNumber: Double? = null
    private var secundNumber: Double? = null
    private var calculationOperator:  Char? = null
    private var result: Double? = null

    fun addNumberAndOperator(number: Double, operator: Char){
        if (firstNumber == null){
            firstNumber = number
            calculationOperator = operator

        } else if (firstNumber != null && secundNumber == null &&  calculationOperator != null){

            secundNumber = number
            calculate()

            firstNumber = result
            secundNumber = null

            calculationOperator = operator

        } else if (firstNumber != null && secundNumber == null &&  calculationOperator == null){

            calculationOperator = operator

            secundNumber = number
            calculate()

            firstNumber = result
            secundNumber = null

            calculationOperator = operator
        }
    }

    fun reset(){
        firstNumber = null
        calculationOperator = null
        secundNumber = null
        result = null
    }

    fun equals(number: Double): Double{
        var returnTheValue = if (firstNumber != null) firstNumber!! else 0.0

        if (firstNumber != null && secundNumber == null && calculationOperator != null){

            secundNumber = number

            calculate()
            returnTheValue = result!!

            calculationOperator = null
            firstNumber = result!!
            secundNumber = null
            result = null
        }

        return returnTheValue
    }

    private fun calculate(){

        if (firstNumber != null && secundNumber != null){
            when (calculationOperator){

                '+' -> result = firstNumber!! + secundNumber!!
                '-' ->  result = firstNumber!! - secundNumber!!
                'x' ->  result = firstNumber!! * secundNumber!!
                '/' ->  result = firstNumber!! / secundNumber!!

                else -> {
                    println("Did not find the operator")
                }
            }
        }

    }

}

