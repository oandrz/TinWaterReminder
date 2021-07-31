package com.example.tinswaterreminderapp.ui.timepicker

import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tinswaterreminderapp.databinding.FragmentTimePickerBinding
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import java.lang.IllegalStateException
import java.util.*
import javax.inject.Inject

class TimePickerFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: TimePickerViewModel by lazy {
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
        setupObserver()
        setupView()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                when(state) {
                    is TimePickerState.ShowTimePicker -> {
                        showTimePickerDialog(state.treshold)
                    }
                    is TimePickerState.RenderTimePicker -> {
                        renderTimePicker(state.treshold, state.time)
                    }
                    is TimePickerState.None -> { /** TODO: 20/7/21 Ignore **/  }
                    else -> throw IllegalStateException("State doesn't exist")
                }
            }
        }
    }

    private fun setupView() {
        setupEtLunch()
        setupEtDinner()
        setupEtSleep()
    }

    private fun setupEtSleep() {
        binding?.etSleepTime?.setOnClickListener {
            viewModel.handleEtSleepTime()
        }
    }

    private fun setupEtDinner() {
        binding?.etDinnerTime?.setOnClickListener {
            viewModel.handleEtDinnerTime()
        }
    }

    private fun setupEtLunch() {
        binding?.etLunchTime?.setOnClickListener {
            viewModel.handleEtLunchTime()
        }
    }

    private fun showTimePickerDialog(event: TresholdEvent) {
        val now = Calendar.getInstance()
        TimePickerDialog(
            requireContext(),
            { _, hourOfDay, minute -> viewModel.handleTimePickerSet(event, hourOfDay, minute) },
            now.get(Calendar.HOUR_OF_DAY),
            now.get(Calendar.MINUTE),
            true
        )
        .show()
    }

    private fun renderTimePicker(event: TresholdEvent, time: String) {
        when(event) {
            TresholdEvent.LUNCH -> binding?.etLunchTime?.setText(time)
            TresholdEvent.DINNER -> binding?.etDinnerTime?.setText(time)
            TresholdEvent.SLEEP -> binding?.etSleepTime?.setText(time)
        }
    }

    companion object {
        const val TAG = "TimePickerFragment"

        fun newInstance(): TimePickerFragment = TimePickerFragment()
    }
}
