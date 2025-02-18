package com.mf.products_list_search.presentation.composables

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.mf.products_list_search.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun Searchbar(modifier: Modifier, onSearchQuerySubmit: (query: String)-> Unit) {
    var searchFieldState by rememberSaveable{ mutableStateOf("") }
    LaunchedEffect(searchFieldState) {
        onSearchQuerySubmit(searchFieldState)
    }
    TextField(value = searchFieldState,
        modifier = modifier,
        onValueChange = {searchFieldState = it},
        label = { Text("Search") },
        maxLines = 1,
        trailingIcon = {
        Image(painter = painterResource(R.drawable.baseline_search_24),
            contentDescription = "Search", modifier = Modifier.clickable{ onSearchQuerySubmit(searchFieldState)})
    },
//        keyboardActions = KeyboardActions(
//            onSearch = {onSearchQuerySubmit(searchFieldState.toString())},
//            onDone = {onSearchQuerySubmit(searchFieldState.toString())}
//        )
    )


}