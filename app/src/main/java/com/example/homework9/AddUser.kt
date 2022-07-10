package com.example.homework9

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework9.databinding.ActivityMainBinding
import com.example.homework9.databinding.SecondactivityBinding

class AddUser : AppCompatActivity() {
    private lateinit var binding: SecondactivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val surname = binding.etSurname.text.toString()
            val email = binding.etEmail.text.toString()
            val user = User(name, surname, email)
            list.add(user)
            finish()
        }


    }

}