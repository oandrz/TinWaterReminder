package com.example.tinswaterreminderapp.ui.chatlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tinswaterreminderapp.databinding.FragmentTimePickerBinding
import com.example.tinswaterreminderapp.util.alarm.AlarmReceiver
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ChatListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var alarmReceiver: AlarmReceiver

    private val viewModel: ChatListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(ChatListViewModel::class.java)
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
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenStarted {
        }
    }

    companion object {
        fun newInstance(): ChatListFragment = ChatListFragment()
    }
}
