package com.example.coffeeshop.auth.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
  private lateinit var binding:FragmentLoginBinding
  private var username=""
  private var password=""
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    // Inflate the layout for this fragment
    binding= FragmentLoginBinding.inflate(inflater)
    return binding.root
  }
  override fun onViewCreated(view: View, savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    getUser()
    binding.btnLogin.setOnClickListener{goHome()}
    binding.tvRegister.setOnClickListener{goRegister()}
    binding.arrowBack.setOnClickListener{ requireActivity().finish() }
  }

  private fun goHome(){
    val user=binding.emailETLogin.text.toString()
    val pass=binding.passwordETLogin.text.toString()
    if (username == user && password == pass){
      findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
      requireActivity().getSharedPreferences("PREFERENCE", AppCompatActivity.MODE_PRIVATE).edit()
        .putBoolean("isLogin", true).apply()
    }else{
      binding.emailETLogin.error="Invalid Email!"
    }
  }

  private fun goRegister(){
    findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
  }

  private fun getUser(){
    username= requireActivity().getSharedPreferences("PREFERENCE", AppCompatActivity.MODE_PRIVATE)
      .getString("email", "").toString()
    password= requireActivity().getSharedPreferences("PREFERENCE", AppCompatActivity.MODE_PRIVATE)
      .getString("password", "").toString()
  }
}