/*
 * Copyright (c) Koninklijke Philips N.V., 2021.
 * All rights reserved.
 */
package com.example.androidtutorial.heterogenous.provider

import com.example.androidtutorial.heterogenous.model.HeteroCardType
import com.example.androidtutorial.heterogenous.model.TextCard
import com.example.androidtutorial.heterogenous.provider.base.BaseHeteroDataProvider
import javax.inject.Inject

class TextSectionProvider @Inject constructor() : BaseHeteroDataProvider<TextCard>() {

    private lateinit var textCard: TextCard

    override suspend fun getCard(): TextCard {
        textCard = TextCard("some text")
        listener?.onSectionAdded(textCard)
        return textCard
    }

    override fun removeCard(shouldRemove: Boolean, card: HeteroCardType) {
        if (shouldRemove) {
            this.listener?.onSectionDeleted(card)
        } else {
            this.listener?.onSectionAdded(textCard)
        }
    }

    override fun getCardType() = HeteroCardType.TEXT
}
