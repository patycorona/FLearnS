package com.example.flearns.platform.di.component

import com.example.flearns.platform.di.module.RepositoryModule
import com.example.flearns.platform.di.module.RetrofitModule
import com.example.flearns.platform.di.module.UseCaseModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RepositoryModule::class,
        UseCaseModule::class,
        RetrofitModule::class
    ]
)

interface MainComponent {
}