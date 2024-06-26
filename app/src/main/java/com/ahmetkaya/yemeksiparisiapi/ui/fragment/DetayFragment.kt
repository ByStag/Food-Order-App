package com.ahmetkaya.yemeksiparisiapi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetkaya.yemeksiparisiapi.R
import com.ahmetkaya.yemeksiparisiapi.databinding.FragmentDetayBinding
import com.ahmetkaya.yemeksiparisiapi.ui.viewmodel.DetayViewModel
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)
        val view = binding.root

        val bundle: DetayFragmentArgs by navArgs()
        val yemek = bundle.yemek
        var adet = 1
        val yemekFiyat = yemek.yemek_fiyat.toString()
        var toplamFiyat = yemek.yemek_fiyat.toString()

        binding.tVDetayAd.text = "${yemek.yemek_adi}"
        binding.tVDetayFiyat.text = "${yemek.yemek_fiyat} ₺"
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Glide.with(this).load(url).override(500,700).into(binding.iVDetayResim)
        binding.tVToplamFiyat.text = toplamFiyat

        binding.bAdetArttir.setOnClickListener {
            adet += 1
            toplamFiyat = (yemekFiyat.toInt() * adet).toString()
            binding.tVAdetSayisi.text = adet.toString()
            binding.tVToplamFiyat.text = toplamFiyat
        }

        binding.bAdetAzalt.setOnClickListener {
            if (adet > 1){
                adet -= 1
                toplamFiyat = (yemekFiyat.toInt() * adet).toString()
                binding.tVAdetSayisi.text = adet.toString()
                binding.tVToplamFiyat.text = toplamFiyat
            }
        }

        binding.bSepetEkle.setOnClickListener {
            viewModel.sepetEkle(yemek.yemek_adi, yemek.yemek_resim_adi, yemek.yemek_fiyat, adet, "kaya")
            Snackbar.make(it, yemek.yemek_adi +" "+ "Sepete Eklendi.", Snackbar.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}

