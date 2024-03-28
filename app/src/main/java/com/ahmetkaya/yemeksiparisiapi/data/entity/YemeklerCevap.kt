package com.ahmetkaya.yemeksiparisiapi.data.entity

data class YemeklerCevap(var yemekler: List<Yemekler>,
                         var success: Int) {
}