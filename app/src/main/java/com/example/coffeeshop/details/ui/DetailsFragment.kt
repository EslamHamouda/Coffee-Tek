package com.example.coffeeshop.details.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.coffeeshop.R
import com.example.coffeeshop.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    lateinit var binding:FragmentDetailsBinding
    val args:DetailsFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.itemImage.setImageResource(args.item.image)
        binding.itemName.text=args.item.name
        binding.addToCartButton.setOnClickListener{
            Toast.makeText(requireContext(),"Done!",Toast.LENGTH_SHORT).show()
        }
        binding.arrowBack.setOnClickListener{goHome()}
    }

    private fun goHome(){
        findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToHomeFragment())
    }

}