package com.example.marvelcadu.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.marvelcadu.databinding.FragmentDetailsCharacterBinding
import com.example.marvelcadu.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsCharacterFragment: BaseFragment<FragmentDetailsCharacterBinding, DetailsCharacterViewModel>() {
    override val viewModel: DetailsCharacterViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailsCharacterBinding  =
        FragmentDetailsCharacterBinding.inflate(inflater, container, false)
}