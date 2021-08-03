package com.example.tinswaterreminderapp

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.tinswaterreminderapp.databinding.ActivityMainBinding
import com.example.tinswaterreminderapp.ui.timepicker.TimePickerFragment
import com.example.tinswaterreminderapp.usecase.GetTimeFlagUseCase
import com.example.tinswaterreminderapp.usecase.SaveTimeFlagUseCase
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var getTimeFlagUseCase: GetTimeFlagUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigationGraph()
    }

    private fun setupNavigationGraph() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_main)
        graph.startDestination = if (getTimeFlagUseCase.run()) {
            R.id.scheduleListFragment
        } else {
            R.id.timePickerFragment
        }
        navHostFragment.navController.graph = graph
    }
}
