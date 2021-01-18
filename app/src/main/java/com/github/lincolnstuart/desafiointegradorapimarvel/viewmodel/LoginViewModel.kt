package com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel

import androidx.lifecycle.ViewModel
import com.github.lincolnstuart.desafiointegradorapimarvel.model.login.business.LoginBusiness

class LoginViewModel : ViewModel() {
    val business: LoginBusiness by lazy {
        LoginBusiness()
    }
}