package com.pvmprog.mytextwithcompose.data.repository

import android.content.Context
import android.widget.Toast
import com.pvmprog.mytextwithcompose.R
import com.pvmprog.mytextwithcompose.data.locale.DataExampleImpl
import com.pvmprog.mytextwithcompose.data.model.ExampleCode
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val localdata: DataExampleImpl,
    private val context: Context
): AppRepository  {

    override fun getAllExamples(): List<ExampleCode> {
        val list = localdata.getExamples()
        val message = context.getString(R.string.examples_loaded)
        Toast.makeText(
            context,
            message+" (${list.size})",
            Toast.LENGTH_SHORT
        ).show()

        return list
    }

}