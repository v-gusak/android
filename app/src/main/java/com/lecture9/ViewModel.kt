package com.lecture9

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel(){
    var number = 0

    val currentNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val currentString: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}