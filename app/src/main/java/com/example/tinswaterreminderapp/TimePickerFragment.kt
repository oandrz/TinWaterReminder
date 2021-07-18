package com.example.tinswaterreminderapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tinswaterreminderapp.databinding.FragmentTimePickerBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TimePickerFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: TimePickerViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(TimePickerViewModel::class.java)
    }

    private var binding: FragmentTimePickerBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimePickerBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun setupView() {
        setupEtLunch()
        setupEtDinner()
        setupEtSleep()
    }

    private fun setupEtSleep() {
        binding?.etSleepTime?.setOnClickListener {

        }
    }

    private fun setupEtDinner() {
        binding?.etDinnerTime?.setOnClickListener {

        }
    }

    private fun setupEtLunch() {
        binding?.etLunchTime?.setOnClickListener {

        }
    }

    companion object {
        const val TAG = "TimePickerFragment"

        fun newInstance(): TimePickerFragment = TimePickerFragment()
    }
}