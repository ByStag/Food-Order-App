package com.ahmetkaya.yemeksiparisiapi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmetkaya.yemeksiparisiapi.data.entity.Yemekler
import com.ahmetkaya.yemeksiparisiapi.databinding.CardTasarimBinding
import com.ahmetkaya.yemeksiparisiapi.ui.fragment.AnasayfaFragmentDirections
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class YemeklerAdapter(var mContext: Context, var yemekListesi: List<Yemekler>)
    : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yemek = yemekListesi.get(position)
        val tb = holder.tasarim

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Glide.with(mContext).load(url).override(400,550).into(tb.iVCardResim)

        tb.tVCardFiyat.text = "${yemek.yemek_fiyat} ₺"
        tb.tVCardYemekAdi.text = "${yemek.yemek_adi}"

        tb.cardViewYemek.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yemek = yemek)
            Navigation.findNavController(it).navigate(gecis)
        }

    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }
}

