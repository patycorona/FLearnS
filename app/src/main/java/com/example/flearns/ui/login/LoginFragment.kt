package com.example.flearns.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.example.flearns.databinding.FragmentLoginBinding
import com.example.flearns.ui.MainActivity
import com.example.flearns.ui.component.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null
   // private val LOGIN_VIDEO = "/" + com.example.flearns.R.raw.login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            (activity as MainActivity)
                .changeScreen(Screen.LoginFragment)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(LayoutInflater.from(context),null, false)

        initListener()
        return binding?.root
    }

    private fun initListener(){

        binding?.apply {

            btnEnter.setOnClickListener {
                Toast.makeText(context,"BIENVENIDO...", Toast.LENGTH_SHORT).show()
            }

            tvRegistro.setOnClickListener {
                (activity as MainActivity)
                    .changeScreen(Screen.UserRegisterFragment)
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}