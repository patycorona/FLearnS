package com.example.flearns.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.flearns.R
import com.example.flearns.databinding.FragmentLoginBinding
import com.example.flearns.domain.model.ConstantGeneral
import com.example.flearns.domain.model.UserModel
import com.example.flearns.domain.model.UserResultModel
import com.example.flearns.ui.MainActivity
import com.example.flearns.ui.component.Screen
import com.example.flearns.ui.user.viewmodel.FbUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null

    private val fbUserViewModel: FbUserViewModel by viewModels()
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
        initObserver()
        return binding?.root
    }

    private fun initListener(){

        binding?.apply {

            btnEnter.setOnClickListener {
                validateFields()
            }

            tvRegistro.setOnClickListener {
                (activity as MainActivity)
                    .changeScreen(Screen.UserRegisterFragment)
            }
        }
    }


    private var userResultObserver  = Observer<UserResultModel> { result ->
        if (result.code == ConstantGeneral.CODE) {
            Toast.makeText(context, result.user, Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(
                requireContext(), ConstantGeneral.MSG_ERROR,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    private fun validateFields(){
        binding?.apply {
            if(!edUserName.text.isNullOrEmpty() && !edPassword.text.isNullOrEmpty()){
                val user = UserModel(edUserName.text.toString(),edPassword.text.toString())
                loginFireBase(user)
            }
            else{
                Toast.makeText(context, R.string.reg_user_empty, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initObserver() {
        fbUserViewModel.userResultModel.observe(viewLifecycleOwner, userResultObserver)
    }

    private  fun loginFireBase(user:UserModel) {

        fbUserViewModel.loginFireBase(user)
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