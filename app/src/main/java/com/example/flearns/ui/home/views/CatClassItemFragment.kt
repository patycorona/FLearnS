package com.example.flearns.ui.home.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.flearns.databinding.FragmentCatClassItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatClassItemFragment : Fragment() {

    private var binding: FragmentCatClassItemBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatClassItemBinding.inflate(LayoutInflater.from(context),null, false)
        return binding?.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CatClassItemFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}