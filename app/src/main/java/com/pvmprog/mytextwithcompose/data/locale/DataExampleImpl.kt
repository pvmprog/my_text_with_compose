package com.pvmprog.mytextwithcompose.data.locale

import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import javax.inject.Inject

class DataExampleImpl @Inject constructor() : DataExample {
    override fun getExamples(): List<ExampleCode> {
        return DataCodeUI.codeUI
    }
}