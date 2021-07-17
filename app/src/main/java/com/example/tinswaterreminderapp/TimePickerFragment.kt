package com.example.tinswaterreminderapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tinswaterreminderapp.databinding.FragmentTimePickerBinding

internal class TimePickerFragment : Fragment() {

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