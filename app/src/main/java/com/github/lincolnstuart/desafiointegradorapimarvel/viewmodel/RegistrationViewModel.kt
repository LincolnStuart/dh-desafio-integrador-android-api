package com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel

import androidx.lifecycle.ViewModel
import com.github.lincolnstuart.desafiointegradorapimarvel.model.registration.business.RegistrationBusiness

class RegistrationViewModel : ViewModel() {
    val business: RegistrationBusiness by lazy {
        RegistrationBusiness()
    }
}