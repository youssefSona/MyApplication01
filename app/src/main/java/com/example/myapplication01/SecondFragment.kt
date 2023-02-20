package com.example.myapplication01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication01.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private val numOfRAM = 16
    private val numOfVGA = 4

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val b: FragmentSecondBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)

//        b.buttonnext.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_secondFragment_to_thirdFragment))
        b.buttonnext.setOnClickListener {
            it.findNavController().navigate(
                SecondFragmentDirections.actionSecondFragmentToThirdFragment(
                    numOfRAM,
                    numOfVGA
                )
            )
        }

        return b.root
    }

}
