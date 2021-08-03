package com.example.tinswaterreminderapp.ui.schedulelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tinswaterreminderapp.databinding.FragmentScheduleListBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ScheduleListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: ScheduleListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ScheduleListViewModel::class.java)
    }

    private var binding: FragmentScheduleListBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentScheduleListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}
