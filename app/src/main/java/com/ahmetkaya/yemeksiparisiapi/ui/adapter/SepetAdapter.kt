package com.ahmetkaya.yemeksiparisiapi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ahmetkaya.yemeksiparisiapi.data.entity.Sepet
import com.ahmetkaya.yemeksiparisiapi.data.entity.Yemekler
import com.ahmetkaya.yemeksiparisiapi.databinding.SepetCardTasarimBinding
import com.ahmetkaya.yemeksiparisiapi.ui.viewmodel.SepetViewModel
import com.bumptech.glide.Glide

class SepetAdapter(var mContext: Context, var sepetListesi: List<Sepet>, var viewModel: SepetViewModel)
    : RecyclerView.Adapter<SepetAdapter.SepetCardTutucu>(){


    inner class SepetCardTutucu(var tasarim: SepetCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTutucu {
        val tasarim = SepetCardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return SepetCardTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: SepetCardTutucu, position: Int) {
        val sepetKart = sepetListesi.get(position)
        val tb = holder.tasarim
        val sepetToplamFiyat = (sepetKart.yemek_siparis_adet * sepetKart.yemek_fiyat).toString()

        tb.tVSepetAd.text = sepetKart.yemek_adi
        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepetKart.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(490,490).into(tb.iVYemekResim)
        tb.tVSepetFiyat.text = "${sepetKart.yemek_fiyat}"
        tb.tVCardToplamFiyat.text = sepetToplamFiyat
        tb.tVAdet.text = "${sepetKart.yemek_siparis_adet}"


    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }
}