package com.ahmetkaya.yemeksiparisiapi.data.repo

import com.ahmetkaya.yemeksiparisiapi.data.datasource.YemeklerDataSource
import com.ahmetkaya.yemeksiparisiapi.data.entity.Yemekler

class YemeklerRepository(var yds : YemeklerDataSource) {


    suspend fun yemekleriYukle() : List<Yemekler> = yds.yemekleriYukle()

    suspend fun sepetEkle(yemek_adi: String,
                          yemek_resim_adi: String,
                          yemek_fiyat: Int,
                          yemek_siparis_adet: Int,
                          kullanici_adi: String) = yds.sepetEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
}

