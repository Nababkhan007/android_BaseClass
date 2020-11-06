package com.khan.baseclass.view.fragment

import android.os.Bundle
import com.khan.baseclass.R
import com.khan.baseclass.databinding.FragmentSettingsBinding
import com.khan.baseclass.viewModel.SettingsViewModel

class SettingsFragment : BaseFragment<FragmentSettingsBinding, SettingsViewModel>() {

    override fun getFragmentView() = R.layout.fragment_settings

    override fun getViewModel() = SettingsViewModel::class.java

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.settingsTv.text = requireActivity().getString(R.string.settings)
    }
}