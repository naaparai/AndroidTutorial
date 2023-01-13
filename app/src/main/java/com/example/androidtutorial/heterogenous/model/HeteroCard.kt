package com.example.androidtutorial.heterogenous.model

sealed class HeteroCard(val type: HeteroCardType)
class ImageCard(val url: String) : HeteroCard(HeteroCardType.IMAGE)
class TextCard(val sometext: String) : HeteroCard(HeteroCardType.TEXT)
