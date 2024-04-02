package com.ahmetkaya.yemeksiparisiapi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.ahmetkaya.yemeksiparisiapi.R
import com.ahmetkaya.yemeksiparisiapi.databinding.FragmentDetayBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)
        val view = binding.root

        val bundle: DetayFragmentArgs by navArgs()
        val yemek = bundle.yemek

        binding.tVDetayAd.text = "${yemek.yemek_adi}"
        binding.tVDetayFiyat.text = "${yemek.yemek_fiyat} ₺"

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Glide.with(this).load(url).override(500,700).into(binding.iVDetayResim)


        return view
    }
}

