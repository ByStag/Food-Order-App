package com.ahmetkaya.yemeksiparisiapi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmetkaya.yemeksiparisiapi.R
import com.ahmetkaya.yemeksiparisiapi.databinding.FragmentSepetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var binding: FragmentSepetBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSepetBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

}