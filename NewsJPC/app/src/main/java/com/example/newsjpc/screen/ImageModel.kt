package com.example.newsjpc

data class ImageModel(val image:Int)

fun ImList():List<ImageModel>{
    val fruitsList = mutableListOf<ImageModel>()
    fruitsList.add(ImageModel(R.drawable.vertical1))
    fruitsList.add(ImageModel(R.drawable.vertical2))
    fruitsList.add(ImageModel(R.drawable.vertical3))
    fruitsList.add(ImageModel(R.drawable.vertical4))
    fruitsList.add(ImageModel(R.drawable.vertical5))
    fruitsList.add(ImageModel(R.drawable.vertical6))
 return fruitsList
}

