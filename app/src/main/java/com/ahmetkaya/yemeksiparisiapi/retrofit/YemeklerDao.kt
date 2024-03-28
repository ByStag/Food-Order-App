package com.ahmetkaya.yemeksiparisiapi.retrofit

import com.ahmetkaya.yemeksiparisiapi.data.entity.YemeklerCevap
import retrofit2.http.GET

interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/ -> Base URL
    //yemekler/tumYemekleriGetir.php -> Webservice URL
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun yemekleriYukle() : YemeklerCevap
}