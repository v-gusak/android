package com.lecture8

data class Item(val name: String, val count: Int) {
    val imageUrl = "https://picsum.photos/150?random=$count"
    val imageUrlSecond = "https://picsum.photos/150?random=${count*10}"
}
