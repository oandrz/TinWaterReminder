package com.example.tinswaterreminderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.tinswaterreminderapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addTimeFragment()
    }

    private fun addTimeFragment() {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.container,
                TimePickerFragment.newInstance(),
                TimePickerFragment.TAG
            ).commit()
    }
}