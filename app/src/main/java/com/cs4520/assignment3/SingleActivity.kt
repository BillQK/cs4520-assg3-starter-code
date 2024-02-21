package com.cs4520.assignment3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cs4520.assignment3.databinding.ActivityMainBinding

class SingleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
    }

}