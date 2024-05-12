package com.ahmetkaya.yemeksiparisiapi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahmetkaya.yemeksiparisiapi.databinding.FragmentSepetBinding
import com.ahmetkaya.yemeksiparisiapi.ui.adapter.SepetAdapter
import com.ahmetkaya.yemeksiparisiapi.ui.adapter.YemeklerAdapter
import com.ahmetkaya.yemeksiparisiapi.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {
    private lateinit var binding: FragmentSepetBinding
    private lateinit var viewModel: SepetViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSepetBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.sepetListesi.observe(viewLifecycleOwner) { sepetList ->
            val adapter = SepetAdapter(requireContext(), sepetList, viewModel)
            binding.rVSepet.adapter = adapter
            binding.rVSepet.layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.yemekleriSepeteYukle("kaya") // Burada viewModel.yemekleriSepeteYukle("kaya") çağrısı

        toplamSepetFiyat()
        siparisVer()

        return view
    }

    fun toplamSepetFiyat(){
        viewModel.toplamFiyat.observe(viewLifecycleOwner){
            binding.tVToplamFiyatSepet.text = it.toString()
            if(binding.tVToplamFiyatSepet.text.equals("0")){
                binding.tVToplamFiyatSepet.text = "0"
            }
        }
    }

    fun siparisVer(){
        binding.bSiparisVer.setOnClickListener {
            Snackbar.make(it,"Siparişinizi Onaylayın", Snackbar.LENGTH_LONG)
                .setAction("Onayla"){
                    Snackbar.make(it,"Siparişiniz onaylandı 30-40 dk arasında gelecektir.", Snackbar.LENGTH_LONG).show()
                }.show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SepetViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.yemekleriSepeteYukle("kaya")
    }

}

