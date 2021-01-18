package com.github.lincolnstuart.desafiointegradorapimarvel.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.github.lincolnstuart.desafiointegradorapimarvel.R
import com.github.lincolnstuart.desafiointegradorapimarvel.databinding.ActivityRegistrationBinding
import com.github.lincolnstuart.desafiointegradorapimarvel.util.extension.validateField
import com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel.LoginViewModel
import com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel.RegistrationViewModel
import com.google.android.material.textfield.TextInputLayout

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegistrationBinding
    private lateinit var viewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = getString(R.string.register)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
    }

    private fun initComponents() {
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
        binding.btRegistrationSubmit.setOnClickListener {
            if (validateForm())
                startActivity(Intent(this@RegistrationActivity, ComicListActivity::class.java))
        }
    }

    private fun validateForm(): Boolean {
        return validateName(binding.tilRegistrationName)
                && validateEmail(binding.tilRegistrationEmail)
                && validatePassword(binding.tilRegistrationPassword)
    }

    private fun validateName(til: TextInputLayout): Boolean {
        return til.validateField(getString(R.string.invalid_name_minimum)) {
            viewModel.business.validateName(it)
        }
    }

    private fun validateEmail(til: TextInputLayout): Boolean {
        return til.validateField(getString(R.string.invalid_email)) {
            viewModel.business.validateEmail(it)
        }
    }

    private fun validatePassword(til: TextInputLayout): Boolean {
        return til.validateField(getString(R.string.invalid_password_minimum)) {
            viewModel.business.validatePassword(it)
        }
    }

}