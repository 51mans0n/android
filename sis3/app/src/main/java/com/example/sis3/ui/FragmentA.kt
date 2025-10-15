package com.example.sis3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sis3.databinding.FragmentABinding

class FragmentA : Fragment() {
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnItem1.setOnClickListener {
            val action = FragmentADirections.actionFragmentAToFragmentB(
                title = "Sunset",
                description = "Warm orange sky over the city"
            )
            findNavController().navigate(action)
        }
        binding.btnItem2.setOnClickListener {
            val action = FragmentADirections.actionFragmentAToFragmentB(
                title = "Mountains",
                description = "Clouds touching mountain peaks"
            )
            findNavController().navigate(action)
        }
        binding.btnItem3.setOnClickListener {
            val action = FragmentADirections.actionFragmentAToFragmentB(
                title = "Forest",
                description = "Green pathway through the forest"
            )
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
