package com.github.lincolnstuart.desafiointegradorapimarvel.model.login.business

import android.util.Patterns
import com.github.lincolnstuart.desafiointegradorapimarvel.util.GeneralValidation

class LoginBusiness {

    fun validateEmail(email: String) =  GeneralValidation.validateEmail(email)

    fun validatePassword(password: String) = GeneralValidation.validatePassword(password)
}