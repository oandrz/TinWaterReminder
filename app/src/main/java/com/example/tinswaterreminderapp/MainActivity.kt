package com.example.tinswaterreminderapp

import android.os.Bundle
import com.example.tinswaterreminderapp.databinding.ActivityMainBinding
import com.example.tinswaterreminderapp.ui.timepicker.TimePickerFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {
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
