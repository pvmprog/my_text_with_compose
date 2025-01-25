package com.pvmprog.mytextwithcompose.di

import android.content.Context
import com.pvmprog.mytextwithcompose.data.locale.DataExampleImpl
import com.pvmprog.mytextwithcompose.data.repository.AppRepository
import com.pvmprog.mytextwithcompose.data.repository.AppRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAppRepository(
        localdata: DataExampleImpl,
        context: Context
    ): AppRepository {
        return AppRepositoryImpl(localdata,context)
    }

}