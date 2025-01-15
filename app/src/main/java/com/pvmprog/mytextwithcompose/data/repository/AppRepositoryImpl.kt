package com.pvmprog.mytextwithcompose.data.repository

import com.pvmprog.mytextwithcompose.data.locale.DataExampleImpl
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val localdata: DataExampleImpl
): AppRepository  {

    override fun getAllExamples(): List<ExampleCode> {
        val list = localdata.getExamples()
        return list
    }

}