package com.github.lincolnstuart.desafiointegradorapimarvel.util.extension

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.validateField(
    errorMessage: String,
    test: (String) -> Boolean
): Boolean {
    this.editText?.let {
        if (test(it.text.toString())) {
            this.error = errorMessage
            return false
        }
    }
    this.isErrorEnabled = false
    return true
}