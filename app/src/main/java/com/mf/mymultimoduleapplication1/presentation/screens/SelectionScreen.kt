package com.mf.mymultimoduleapplication1.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.mf.mymultimoduleapplication1.presentation.models.IUiState
import com.mf.mymultimoduleapplication1.presentation.models.UiStateProductsListImpl
import com.mf.mymultimoduleapplication1.presentation.models.UiStateProductsSearchImpl
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.onSizeChanged

@Composable
fun SelectionScreen(modifier: Modifier, onScreenSelected:(action: IUiState) -> Unit) {
    val columnScrollState = rememberScrollState()
    var size by remember { mutableStateOf(IntSize.Zero) }


    Column(modifier.fillMaxSize(1.0f).padding(start = 25.dp, end = 25.dp).verticalScroll(columnScrollState), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, ) {
        Button(modifier = Modifier.onSizeChanged { if(it.width > size.width) {
            size = it
        } }.size(size.width.dp, size.height.dp),onClick = { onScreenSelected(UiStateProductsSearchImpl()) }) { Text("Products search screen")}
        Spacer(modifier = Modifier.height(25.dp))
        Button(modifier = Modifier.fillMaxWidth(1.0f).size(size.width.dp, size.height.dp).onSizeChanged {
            if(it.width> size.width)
                size = it
        },onClick = { onScreenSelected(UiStateProductsListImpl())}) { Text("Products List view screen")}
    }
}