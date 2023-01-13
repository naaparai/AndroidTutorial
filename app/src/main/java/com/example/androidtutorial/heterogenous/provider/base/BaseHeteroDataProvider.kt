/*
 * Copyright (c) Koninklijke Philips N.V., 2021.
 * All rights reserved.
 */
package com.example.androidtutorial.heterogenous.provider.base

import com.example.androidtutorial.heterogenous.model.HeteroCard

abstract class BaseHeteroDataProvider<T : HeteroCard> : HeteroDataProvider<T> {

    protected var listener: HeteroSectionUpdateListener<T>? = null
    override fun setCallback(listener: HeteroSectionUpdateListener<T>) {
        this.listener = listener
    }

    override fun removeCallback(listener: HeteroSectionUpdateListener<T>) {
        this.listener = null
    }
}
