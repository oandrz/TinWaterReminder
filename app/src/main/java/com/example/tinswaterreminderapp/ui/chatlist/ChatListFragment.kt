package com.example.tinswaterreminderapp.ui.chatlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tinswaterreminderapp.databinding.FragmentChatListBinding
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

    private var binding: FragmentChatListBinding? = null

    /*
    * Call Window.setDecorFitsSystemWindows(boolean) with false and install an View.OnApplyWindowInsetsListener on your root content view that fits insets of type WindowInsets.Type.ime().
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE or WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentChatListBinding.inflate(inflater, container, false)
        setupView()
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

    override fun onDestroy() {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        super.onDestroy()
    }

    private fun setupView() {
        binding?.chatList?.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnLifecycleDestroyed(viewLifecycleOwner))
            setContent { MaterialTheme { ChatListContent() } }
        }
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenStarted {
        }
    }

    companion object {
        fun newInstance(): ChatListFragment = ChatListFragment()
    }
}
