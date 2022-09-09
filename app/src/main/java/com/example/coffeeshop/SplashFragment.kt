package com.example.coffeeshop

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.coffeeshop.R


class SplashFragment : Fragment(R.layout.fragment_splash) {
    var isLogin = false
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
           goOnboarding()
        }, 3000)
    }

    fun goOnboarding() {
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToOnboardingFragment())
    }




}
