/*
 * Copyright (c) Koninklijke Philips N.V., 2021.
 * All rights reserved.
 */
package com.example.androidtutorial.heterogenous.provider

import com.example.androidtutorial.heterogenous.model.HeteroCardType
import com.example.androidtutorial.heterogenous.model.ImageCard
import com.example.androidtutorial.heterogenous.provider.base.BaseHeteroDataProvider
import javax.inject.Inject

class ImageSectionProvider @Inject constructor() :
    BaseHeteroDataProvider<ImageCard>() {

    private lateinit var imageCard: ImageCard

    override suspend fun getCard(): ImageCard {
        imageCard = ImageCard("https://picsum.photos/200")
        listener?.onSectionAdded(imageCard)
        return imageCard
    }

    override fun removeCard(shouldRemove: Boolean, card: HeteroCardType) {
        if (shouldRemove) {
            this.listener?.onSectionDeleted(card)
        } else {
            this.listener?.onSectionAdded(imageCard)
        }
    }

    override fun getCardType() = HeteroCardType.IMAGE
}
