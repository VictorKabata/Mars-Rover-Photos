package com.vickbt.repository.di

import com.vickbt.domain.repositories.MarsPhotosRepository
import com.vickbt.repository.datasources.MarsPhotosRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<MarsPhotosRepository> { MarsPhotosRepositoryImpl(apiService = get()) }

}