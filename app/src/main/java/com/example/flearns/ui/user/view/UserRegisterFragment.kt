package com.example.flearns.ui.user.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.flearns.R
import com.example.flearns.databinding.FragmentUserRegisterBinding
import com.example.flearns.domain.model.ConstantGeneral.Companion.CODE
import com.example.flearns.domain.model.ConstantGeneral.Companion.MSG_ERROR
import com.example.flearns.domain.model.ConstantGeneral.Companion.MSG_REGISTER_SUCCESS
import com.example.flearns.domain.model.ResultModel
import com.example.flearns.domain.model.UserModel
import com.example.flearns.ui.MainActivity
import com.example.flearns.ui.component.Screen
import com.example.flearns.ui.user.viewmodel.FbUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserRegisterFragment : Fragment() {

    private var binding : FragmentUserRegisterBinding? = null
    private val fbUserViewModel: FbUserViewModel by viewModels()

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

        binding = FragmentUserRegisterBinding.inflate(LayoutInflater.from(context),null,false)

        initListener()
        initObserver()
        return binding?.root
    }

    private fun initListener(){

        binding?.apply {
            btnEnter.setOnClickListener {
                validateFields()
            }
        }
    }

    private var ResultObserver  = Observer<ResultModel> { resultModel ->
        if (resultModel.code == CODE) {
            Toast.makeText(
                requireContext(), MSG_REGISTER_SUCCESS,
                Toast.LENGTH_SHORT
            ).show()
            (activity as MainActivity)
                .changeScreen(Screen.LoginFragment)
        } else {
            Toast.makeText(
                requireContext(), MSG_ERROR,
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    private fun validateFields(){
        binding?.apply {
            if(!edUserName.text.isNullOrEmpty() && !edPassword.text.isNullOrEmpty() &&
                !edConfirmPwd.text.isNullOrEmpty()){

                if(edPassword.text.toString() == edConfirmPwd.text.toString()){

                    val userRegister = UserModel(edUserName.text.toString(),edPassword.text.toString())
                    userRegisterFirebase(userRegister)

                }else{
                    Toast.makeText(context, R.string.msg_error_pwd, Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(context, R.string.reg_user_empty, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun userRegisterFirebase(usermodel : UserModel){
        fbUserViewModel.userRegisterFirebase(usermodel)
    }

    private fun initObserver(){
        fbUserViewModel.userResultModel.observe(viewLifecycleOwner, ResultObserver)
    }

    companion object {

        @JvmStatic
        fun newInstance() = UserRegisterFragment().apply {
            arguments = Bundle().apply {
            }
        }
    }
}