package com.suitmedia.test.ui.second

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.suitmedia.test.R
import com.suitmedia.test.databinding.FragmentSecondBinding
import com.suitmedia.test.ui.common.BaseFragment

class SecondFragment : BaseFragment<FragmentSecondBinding>(FragmentSecondBinding::inflate) {
    private val args: SecondFragmentArgs by navArgs()
    override fun setupUI() {
        with(binding) {
            tvCurrentUser.text = args.currentName
            tvChooseUser.text = if (args.selectedUsername.isNullOrEmpty()) {
                getString(R.string.selected_user_name)
            } else {
                args.selectedUsername
            }
        }
    }

    override fun setupActions() {
        with(binding) {
            toolbarSecond.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            btnChooseUser.setOnClickListener {
                findNavController().navigate(
                    SecondFragmentDirections.actionSecondFragmentToThirdFragment(
                        args.currentName
                    )
                )
            }
        }
    }

    override fun setupObservers() {}
}