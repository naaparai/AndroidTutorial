/*
 * Copyright (c) Koninklijke Philips N.V., 2021.
 * All rights reserved.
 */

package com.example.androidtutorial.heterogenous.di

import com.example.androidtutorial.heterogenous.model.HeteroCard
import com.example.androidtutorial.heterogenous.provider.ImageSectionProvider
import com.example.androidtutorial.heterogenous.provider.TextSectionProvider
import com.example.androidtutorial.heterogenous.provider.base.HeteroDataProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object HeteroViewModelModule {

    @Provides
    fun provideHeteroProvider(): List<HeteroDataProvider<HeteroCard>> {
        //  We have to make sure, each provider extends from parent provider
        @Suppress("UNCHECKED_CAST")
        return mutableListOf(
            ImageSectionProvider() as HeteroDataProvider<HeteroCard>,
            TextSectionProvider() as HeteroDataProvider<HeteroCard>
        )
    }
}
