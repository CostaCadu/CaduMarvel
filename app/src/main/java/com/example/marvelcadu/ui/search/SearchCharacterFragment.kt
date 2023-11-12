package com.example.marvelcadu.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.marvelcadu.databinding.FragmentSearchCharacterBinding
import com.example.marvelcadu.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchCharacterFragment : BaseFragment<FragmentSearchCharacterBinding, SearchCharacterViewModel>() {
    override val viewModel: SearchCharacterViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchCharacterBinding =
        FragmentSearchCharacterBinding.inflate(inflater, container, false)
}