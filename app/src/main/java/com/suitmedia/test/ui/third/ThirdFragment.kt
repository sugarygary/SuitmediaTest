package com.suitmedia.test.ui.third

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.suitmedia.test.databinding.FragmentThirdBinding
import com.suitmedia.test.domain.model.User
import com.suitmedia.test.ui.common.BaseFragment
import com.suitmedia.test.ui.third.adapter.LoadingStateAdapter
import com.suitmedia.test.ui.third.adapter.UserAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdFragment : BaseFragment<FragmentThirdBinding>(FragmentThirdBinding::inflate) {
    private val viewModel: ThirdViewModel by viewModels()
    private val args: ThirdFragmentArgs by navArgs()
    private lateinit var userAdapter: UserAdapter
    override fun setupUI() {
        userAdapter = UserAdapter(::onClickUser)
        val layoutManager =
            LinearLayoutManager(requireContext())
        with(binding) {
            rvUsers.layoutManager = layoutManager
            rvUsers.adapter = userAdapter.withLoadStateFooter(
                footer = LoadingStateAdapter {
                    userAdapter.retry()
                }
            )
        }
    }

    override fun setupActions() {
        with(binding) {
            toolbarThird.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            refreshLayout.setOnRefreshListener {
                viewModel.fetchUsers()
                refreshLayout.isRefreshing = false
            }
        }
    }

    override fun setupObservers() {
        viewModel.users.observe(viewLifecycleOwner) {
            userAdapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    private fun onClickUser(user: User) {
        val selected_username = "${user.firstName} ${user.lastName}"
        findNavController().navigate(
            ThirdFragmentDirections.actionThirdFragmentToSecondFragment(
                args.currentName,
                selected_username
            )
        )
    }
}