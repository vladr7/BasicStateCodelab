package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    var count by remember { mutableStateOf(0) }

    Column(modifier = modifier) {
        StatelessCounter(count, { count++ })

        val list = wellnessViewModel.tasks
        WellnessTasksList(
            list = list,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckedTask = { task, checked -> wellnessViewModel.checkedChanged(task, checked) }
        )
    }

}