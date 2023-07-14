package com.weha.foregroundservice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.weha.foregroundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onStart() {
        super.onStart()
        val isStarted = ForegroundService.isServiceStarted(this)
        if (!isStarted) {
            ForegroundService.startService(this, "Foreground Service is running...")
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartService.setOnClickListener {
            ForegroundService.startService(this, "Foreground Service is running...")
        }
        binding.btnStopService.setOnClickListener {
            ForegroundService.stopService(this)
        }
    }
}