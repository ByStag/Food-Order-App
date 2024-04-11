package com.ahmetkaya.yemeksiparisiapi.retrofit

import com.ahmetkaya.yemeksiparisiapi.data.entity.CRUDCevap
import com.ahmetkaya.yemeksiparisiapi.data.entity.SepetCevap
import com.ahmetkaya.yemeksiparisiapi.data.entity.YemeklerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/ -> Base URL
    //yemekler/tumYemekleriGetir.php -> Webservice URL
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun yemekleriYukle() : YemeklerCevap

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun sepetEkle(@Field("yemek_adi") yemek_adi: String,
                          @Field("yemek_resim_adi") yemek_resim_adi: String,
                          @Field("yemek_fiyat") yemek_fiyat: Int,
                          @Field("yemek_siparis_adet") yemek_siparis_adet: Int,
                          @Field("kullanici_adi") kullanici_adi: String) : CRUDCevap

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun yemekleriSepeteYukle(@Field("kullanici_adi") kullanici_adi: String) : SepetCevap
}

