package com.ahmetkaya.yemeksiparisiapi.retrofit


class ApiUtils {
    companion object{
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getYemeklerDao() : YemeklerDao{
            return RetrofitClint.getClint(BASE_URL).create(YemeklerDao::class.java)
        }
    }
}