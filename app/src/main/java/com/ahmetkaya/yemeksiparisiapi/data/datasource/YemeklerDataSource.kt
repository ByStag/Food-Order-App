package com.ahmetkaya.yemeksiparisiapi.data.datasource

import com.ahmetkaya.yemeksiparisiapi.data.entity.Sepet
import com.ahmetkaya.yemeksiparisiapi.data.entity.Yemekler
import com.ahmetkaya.yemeksiparisiapi.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(var ydao: YemeklerDao) {
    suspend fun yemekleriYukle() : List<Yemekler> =
        withContext(Dispatchers.IO){
            return@withContext ydao.yemekleriYukle().yemekler
        }

    suspend fun sepetEkle(yemek_adi: String,
                          yemek_resim_adi: String,
                          yemek_fiyat: Int,
                          yemek_siparis_adet: Int,
                          kullanici_adi: String) = ydao.sepetEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)

    suspend fun yemekleriSepeteYukle(kullanici_adi: String) : List<Sepet> =
        withContext(Dispatchers.IO){
            return@withContext ydao.yemekleriSepeteYukle(kullanici_adi).sepet_yemekler
        }

    suspend fun yemekleriSil(sepet_yemek_id: Int, kullanici_adi: String) = ydao.yemekleriSil(sepet_yemek_id,kullanici_adi)
}

