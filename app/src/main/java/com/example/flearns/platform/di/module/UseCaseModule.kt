package com.example.flearns.platform.di.module

import com.example.flearns.data.repository.CategoryClassRepositoryImpl
import com.example.flearns.data.repository.FbUserRepositoryImpl
import com.example.flearns.domain.usecase.CategoryClassUseCase
import com.example.flearns.domain.usecase.FbUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun fbUserUseCaseProvider(fbUserRepositoryImpl: FbUserRepositoryImpl) =
        FbUserUseCase(fbUserRepositoryImpl)

    @Provides
    fun categoryClassUseCaseProvider(categoryClassRepositoryImpl : CategoryClassRepositoryImpl) =
        CategoryClassUseCase(categoryClassRepositoryImpl)
}
