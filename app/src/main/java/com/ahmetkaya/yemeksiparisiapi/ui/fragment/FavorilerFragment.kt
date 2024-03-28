package com.ahmetkaya.yemeksiparisiapi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ahmetkaya.yemeksiparisiapi.R
import com.ahmetkaya.yemeksiparisiapi.databinding.FragmentFavorilerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavorilerFragment : Fragment() {
    private lateinit var binding: FragmentFavorilerBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavorilerBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }
}