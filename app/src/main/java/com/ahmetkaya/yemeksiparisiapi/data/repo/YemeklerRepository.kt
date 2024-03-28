package com.ahmetkaya.yemeksiparisiapi.data.repo

import com.ahmetkaya.yemeksiparisiapi.data.datasource.YemeklerDataSource
import com.ahmetkaya.yemeksiparisiapi.data.entity.Yemekler

class YemeklerRepository(var yds : YemeklerDataSource) {


    suspend fun yemekleriYukle() : List<Yemekler> = yds.yemekleriYukle()
}

