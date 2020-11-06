package com.khan.baseclass.view.fragment

import android.os.Bundle
import com.khan.baseclass.R
import com.khan.baseclass.databinding.FragmentHomeBinding
import com.khan.baseclass.listener.ResponseListener
import com.khan.baseclass.util.toast
import com.khan.baseclass.viewModel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(), ResponseListener {

    override fun getFragmentView() = R.layout.fragment_home

    override fun getViewModel() = HomeViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.homeTv.text = requireActivity().getString(R.string.home)

        binding.homeViewModel = viewModel
        viewModel.responseListener = this
    }

    override fun onStarted() {
        requireActivity().toast("Clicked!")
    }
}