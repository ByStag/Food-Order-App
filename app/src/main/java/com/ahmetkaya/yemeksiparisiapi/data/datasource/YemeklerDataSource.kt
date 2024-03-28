package com.ahmetkaya.yemeksiparisiapi.data.datasource

import com.ahmetkaya.yemeksiparisiapi.data.entity.Yemekler
import com.ahmetkaya.yemeksiparisiapi.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(var ydao: YemeklerDao) {
    suspend fun yemekleriYukle() : List<Yemekler> =
        withContext(Dispatchers.IO){
            return@withContext ydao.yemekleriYukle().yemekler
        }
}

