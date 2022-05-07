package com.agening.cleanarch.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.agening.cleanarch.databinding.ActivityMainBinding
import com.agening.cleanarch.domain.models.UserName
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val vm: MainViewModel by viewModel()

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