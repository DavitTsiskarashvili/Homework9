package com.example.homework9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework9.databinding.ActivityMainBinding
import com.example.homework9.databinding.SecondactivityBinding
import com.example.homework9.databinding.UserinfoBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter = Adapter(list)
        binding.rvApp.layoutManager = LinearLayoutManager(this)


        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddUser::class.java))
        }
    }

    override fun onRestart() {
        super.onRestart()
        binding.rvApp.adapter = adapter
    }
}