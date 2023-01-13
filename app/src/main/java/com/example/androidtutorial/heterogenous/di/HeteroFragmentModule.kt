/*
 * Copyright (c) Koninklijke Philips N.V., 2021.
 * All rights reserved.
 */

package com.example.androidtutorial.heterogenous.di

import com.example.androidtutorial.heterogenous.HeteroAdapter
import com.example.androidtutorial.heterogenous.factory.HeteroVHFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object HeteroFragmentModule {

    @Provides
    fun provideHeteroVhFactory(): HeteroVHFactory {
        return HeteroVHFactory()
    }

    @Provides
    fun provideHeteroAdapter(heteroVHFactory: HeteroVHFactory): HeteroAdapter {
        return HeteroAdapter(heteroVHFactory)
    }
}
