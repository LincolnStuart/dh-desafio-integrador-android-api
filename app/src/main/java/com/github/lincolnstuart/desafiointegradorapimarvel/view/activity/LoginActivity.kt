package com.github.lincolnstuart.desafiointegradorapimarvel.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.lincolnstuart.desafiointegradorapimarvel.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}