package com.pvmprog.mytextwithcompose.data.repository

import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import dagger.Provides


interface AppRepository {
    fun getAllExamples(): List<ExampleCode>
}