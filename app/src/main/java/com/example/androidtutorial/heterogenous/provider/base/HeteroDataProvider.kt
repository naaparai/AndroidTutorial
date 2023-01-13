/*
 * Copyright (c) Koninklijke Philips N.V., 2021.
 * All rights reserved.
 */

package com.example.androidtutorial.heterogenous.provider.base

import com.example.androidtutorial.heterogenous.model.HeteroCard
import com.example.androidtutorial.heterogenous.model.HeteroCardType

interface HeteroDataProvider<T : HeteroCard> {
    suspend fun getCard(): T?
    fun setCallback(listener: HeteroSectionUpdateListener<T>)
    fun removeCard(shouldRemove: Boolean, card: HeteroCardType)
    fun removeCallback(listener: HeteroSectionUpdateListener<T>)
    fun getCardType(): HeteroCardType
}
