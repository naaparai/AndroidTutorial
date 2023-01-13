/*
 * Copyright (c) Koninklijke Philips N.V., 2021.
 * All rights reserved.
 */

package com.example.androidtutorial.heterogenous.provider.base

import com.example.androidtutorial.heterogenous.model.HeteroCard
import com.example.androidtutorial.heterogenous.model.HeteroCardType

interface HeteroSectionUpdateListener<T : HeteroCard> {
    fun onSectionAdded(card: T)
    fun onSectionUpdated(card: T)
    fun onSectionDeleted(cardType: HeteroCardType)
}
