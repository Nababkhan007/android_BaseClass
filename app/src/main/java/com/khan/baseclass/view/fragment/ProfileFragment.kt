package com.khan.baseclass.view.fragment

import android.os.Bundle
import com.khan.baseclass.R
import com.khan.baseclass.databinding.FragmentProfileBinding
import com.khan.baseclass.viewModel.ProfileViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {

    override fun getFragmentView() = R.layout.fragment_profile

    override fun getViewModel() = ProfileViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.profileTv.text = requireActivity().getString(R.string.profile)
    }
}