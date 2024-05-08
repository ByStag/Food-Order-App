package com.ahmetkaya.yemeksiparisiapi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmetkaya.yemeksiparisiapi.data.entity.Sepet
import com.ahmetkaya.yemeksiparisiapi.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SepetViewModel @Inject constructor(var yrepo: YemeklerRepository): ViewModel() {
    var sepetListesi = MutableLiveData<List<Sepet>>()
    var toplamFiyat = MutableLiveData<Int>()

    init {
        yemekleriSepeteYukle("kaya")
    }


    fun yemekleriSepeteYukle(kullanici_adi: String){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                sepetListesi.value = yrepo.yemekleriSepeteYukle(kullanici_adi)
                toplamFiyatiHesapla()
            }catch (e: Exception){
                e.printStackTrace()
                sepetListesi.value = listOf()
                toplamFiyatiHesapla()
            }
        }
    }

    fun toplamFiyatiHesapla(){
        val toplam = sepetListesi.value?.sumOf { it.yemek_fiyat * it.yemek_siparis_adet }
        toplamFiyat.value = toplam ?: 0
    }

    fun yemekleriSil(sepet_yemek_id: Int, kullanici_adi: String) {
        CoroutineScope(Dispatchers.Main).launch {
           sepetListesi.value?.forEach {
               if (it.sepet_yemek_id == sepet_yemek_id){
                   yrepo.yemekleriSil(it.sepet_yemek_id, kullanici_adi)
               }
           }
            yemekleriSepeteYukle("kaya")
        }
    }

}

