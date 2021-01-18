package com.github.lincolnstuart.desafiointegradorapimarvel.util

import android.util.Patterns

object GeneralValidation {
    fun validateEmail(email: String) =  !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun validatePassword(password: String) = password.count() < 3

    fun validateName(name: String) = name.count() < 2
}