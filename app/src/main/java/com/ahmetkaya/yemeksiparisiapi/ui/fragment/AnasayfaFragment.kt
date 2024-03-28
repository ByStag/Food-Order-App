package com.ahmetkaya.yemeksiparisiapi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ahmetkaya.yemeksiparisiapi.data.entity.Yemekler
import com.ahmetkaya.yemeksiparisiapi.databinding.FragmentAnasayfaBinding
import com.ahmetkaya.yemeksiparisiapi.ui.adapter.YemeklerAdapter
import com.ahmetkaya.yemeksiparisiapi.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.rVYemek.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)


        viewModel.yemekListesi.observe(viewLifecycleOwner){
            val adapter = YemeklerAdapter(requireContext(), it)
            binding.rVYemek.adapter = adapter
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
}

