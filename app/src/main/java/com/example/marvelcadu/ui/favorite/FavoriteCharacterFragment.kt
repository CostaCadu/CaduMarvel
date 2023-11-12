package com.example.marvelcadu.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.marvelcadu.databinding.FragmentFavoriteCharacterBinding
import com.example.marvelcadu.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavoriteCharacterFragment : BaseFragment<FragmentFavoriteCharacterBinding, FavoriteCharacterViewModel>() {
    override val viewModel: FavoriteCharacterViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteCharacterBinding =
        FragmentFavoriteCharacterBinding.inflate(inflater, container, false)
}