package com.suitmedia.test.ui.first

import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.suitmedia.test.databinding.FragmentFirstBinding
import com.suitmedia.test.ui.common.BaseFragment

class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    override fun setupUI() {}

    override fun setupActions() {
        with(binding) {
            btnNext.setOnClickListener {
                val name = etName.text.toString()
                if (name.isEmpty()) {
                    etName.error = "Field cannot be empty"
                    etName.requestFocus()
                    return@setOnClickListener
                }
                findNavController().navigate(
                    FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                        name,
                        ""
                    )
                )
            }
            btnCheck.setOnClickListener {
                val inputText = etCheck.text.toString()
                if (inputText.isEmpty()) {
                    etCheck.error = "Field cannot be empty"
                    etCheck.requestFocus()
                    return@setOnClickListener
                }
                val message = if (isPalindrome(inputText)) {
                    "isPalindrome"
                } else {
                    "not palindrome"
                }
                AlertDialog.Builder(requireContext()).setMessage(message)
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }.create().show()
            }
        }
    }

    override fun setupObservers() {}

    private fun isPalindrome(string: String): Boolean {
        val toCheck = string.replace(" ", "")
        for (i in 0..<toCheck.length / 2) {
            if (toCheck[i] != toCheck[toCheck.length - i - 1]) {
                return false
            }
        }
        return true
    }
}