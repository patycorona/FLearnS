package com.example.flearns.platform.di.module

import com.example.flearns.data.database.FirebaseAction
import com.example.flearns.data.network.CoreHomeApi
import com.example.flearns.data.repository.CategoryClassRepositoryImpl
import com.example.flearns.data.repository.FbUserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    fun fbUserRepositoryProvider(fbActions: FirebaseAction):
            FbUserRepositoryImpl = FbUserRepositoryImpl(fbActions)

    @Provides
    fun categoryClassRepositoryProvider(coreHomeApi: CoreHomeApi):
            CategoryClassRepositoryImpl = CategoryClassRepositoryImpl(coreHomeApi)
}