package com.example.tinswaterreminderapp.ui.brithday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinswaterreminderapp.databinding.FragmentBirthdayCardBinding
import javax.inject.Inject

class BirthdayCardFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: BirthdayCardViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(BirthdayCardViewModel::class.java)
    }

    private var binding: FragmentBirthdayCardBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBirthdayCardBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance(): BirthdayCardFragment = BirthdayCardFragment()
    }
}
