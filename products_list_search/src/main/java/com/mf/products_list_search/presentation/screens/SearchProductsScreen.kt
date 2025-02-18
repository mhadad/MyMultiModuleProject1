package com.mf.products_list_search.presentation.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mf.products_list_search.domain.models.ProductsSearchUiStates.*
import com.mf.products_list_search.presentation.composables.ProductsListView
import com.mf.products_list_search.presentation.composables.Searchbar
import com.mf.products_list_search.presentation.viewModels.ProductsSearchViewModel
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mf.products_list_search.domain.models.ProductsSearchUiStates

@Composable
fun SearchProductsScreen(modifier: Modifier) {
    val productsListScreenViewModel = hiltViewModel<ProductsSearchViewModel>()
    val productsFLow = productsListScreenViewModel.productsFlow.collectAsStateWithLifecycle(initialValue = DataLoading)
    var execSearch by rememberSaveable{mutableStateOf(false)}
    var execSearchState = rememberUpdatedState(execSearch)
    var searchQuery by rememberSaveable{ mutableStateOf("")}
    LaunchedEffect(Unit){
        productsListScreenViewModel.getAllProducts(0)
    }
    LaunchedEffect(execSearch){
        if(execSearchState.value == true) {
            productsListScreenViewModel.execSearch(searchQuery)
            execSearch = false
        }
    }
    if(productsFLow.value.isDataSuccess()) {
//        Box (
//            Modifier.fillMaxSize(1f).padding(start = 15.dp, end = 15.dp),

//        ) {
            // search bar with pagination and two filters for reseting the search anad for navigating back to the list screen
//            Searchbar(modifier.padding(bottom = 0.dp).weight(0.15f).fillMaxWidth(1.0f), onSearchQuerySubmit = {
            Column(modifier) {
                Searchbar(
                    Modifier.padding(bottom = 5.dp).fillMaxWidth(1.0f),
                    onSearchQuerySubmit = {
                        searchQuery = it
                        execSearch = true
                    })
                ProductsListView(
                    (productsFLow.value as ProductsSearchUiStates.DataSuccess).data,
//                Modifier.padding(top = 0.dp).weight(0.85f)
                    Modifier.padding(top = 0.dp)
                )
            }
//        }
    }
    else if(productsFLow.value.isDataError())
        Text((productsFLow.value as DataError).message)
    else if(productsFLow.value.isDataLoading())
        CircularProgressIndicator()

}


