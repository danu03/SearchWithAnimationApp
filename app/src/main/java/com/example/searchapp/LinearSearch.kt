package com.example.searchapp

import java.util.*

class LinearSearch {
    fun search(list: List<String>, wantedValue: String) : String? {
        for(value in list){
            if(value.lowercase(Locale.getDefault()).contains(wantedValue)) return value
        }
        return "Data tidak ditemukan"
    }
}