package com.example.desafio.util

import java.math.BigDecimal
import java.text.NumberFormat

fun Double.toReal() : String {
    return NumberFormat.getCurrencyInstance()?.format(BigDecimal(this))?:0.0.toString()
}