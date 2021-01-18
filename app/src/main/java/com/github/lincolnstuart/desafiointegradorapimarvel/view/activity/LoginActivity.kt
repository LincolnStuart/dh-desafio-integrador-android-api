package com.github.lincolnstuart.desafiointegradorapimarvel.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.github.lincolnstuart.desafiointegradorapimarvel.R
import com.github.lincolnstuart.desafiointegradorapimarvel.databinding.ActivityLoginBinding
import com.github.lincolnstuart.desafiointegradorapimarvel.util.extension.validateField
import com.github.lincolnstuart.desafiointegradorapimarvel.viewmodel.LoginViewModel
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
    }

    private fun initComponents() {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.btLoginSubmit.setOnClickListener {
            if (validateForm())
                startActivity(Intent(this@LoginActivity, ComicListActivity::class.java))
        }
        binding.tvLoginCreateAccount.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegistrationActivity::class.java))
        }
    }

    private fun validateForm(): Boolean {
        return validateEmail(binding.tilLoginEmail)
                && validatePassword(binding.tilLoginPassword)
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