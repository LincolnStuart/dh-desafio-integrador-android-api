package com.github.lincolnstuart.desafiointegradorapimarvel.model.registration.business

import android.util.Patterns
import com.github.lincolnstuart.desafiointegradorapimarvel.util.GeneralValidation

class RegistrationBusiness {

    fun validateEmail(email: String) =  GeneralValidation.validateEmail(email)

    fun validatePassword(password: String) = GeneralValidation.validatePassword(password)

    fun validateName(name: String) = GeneralValidation.validateName(name)
}