package com.agening.cleanarch.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.agening.cleanarch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        vm.resultLive.observe(this) {
            binding.dataTextView.text = it
        }

        Log.e("AAA", "Activity created")

        binding.sendButton.setOnClickListener {
            vm.save(binding.dataEditText.text.toString())
        }

        binding.receiveButton.setOnClickListener {
            vm.load()
        }
    }
}