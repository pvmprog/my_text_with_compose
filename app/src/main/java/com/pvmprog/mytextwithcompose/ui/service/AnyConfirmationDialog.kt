package com.pvmprog.mytextwithcompose.ui.service

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pvmprog.mytextwithcompose.R

@Composable
fun AnyConfirmationDialog(
    onOperationConfirm: () -> Unit,
    onOperationCancel: () -> Unit,
    modifier: Modifier = Modifier,
    idStrResource:Int = R.string.delete_question
) {
    AlertDialog(onDismissRequest = { /* Do nothing */ },
        title = { Text(stringResource(R.string.attention)) },
        text = { Text(stringResource(idStrResource)) },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onOperationCancel) {
                Text(stringResource(R.string.no))
            }
        },
        confirmButton = {
            TextButton(onClick = onOperationConfirm) {
                Text(stringResource(R.string.yes))
            }
        })
}
