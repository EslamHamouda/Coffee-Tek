package com.example.coffeeshop.on_boarding.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R
import com.example.coffeeshop.SplashFragmentDirections
import com.example.coffeeshop.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {
  private lateinit var binding: FragmentOnboardingBinding
  var isLogin=false
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View {
    binding=FragmentOnboardingBinding.inflate(inflater)
    setUser()
    go()
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    binding.btnRegister.setOnClickListener{goRegister()}
    binding.btnLogin.setOnClickListener{goLogin()}

  }

  private fun goRegister(){
    findNavController().navigate(
      OnboardingFragmentDirections.actionOnboardingFragmentToRegisterFragment())
  }

  fun goLogin(){
    findNavController().navigate(
      OnboardingFragmentDirections.actionOnboardingFragmentToLoginFragment())
  }

  private fun go() {
    isLogin =
      requireActivity().getSharedPreferences("PREFERENCE", AppCompatActivity.MODE_PRIVATE)
        .getBoolean("isLogin", false)
    if (isLogin==true) {
      findNavController().navigate(OnboardingFragmentDirections.actionOnboardingFragmentToHomeFragment())
    }
  }

  private fun setUser(){
   requireActivity().getSharedPreferences("PREFERENCE", AppCompatActivity.MODE_PRIVATE).edit()
      .putString("email", "eslam.ee600@gmail.com").apply()
  requireActivity().getSharedPreferences("PREFERENCE", AppCompatActivity.MODE_PRIVATE).edit()
      .putString("password", "123456789").apply()
  }

}