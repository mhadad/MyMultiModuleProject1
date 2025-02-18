package com.mf.products_list.presentation.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mf.products_list.domain.models.DataError
import com.mf.products_list.domain.models.DataSuccess
import com.mf.products_list.presentation.composables.ProductsListView
import com.mf.products_list.presentation.view_models.ProductsListScreenViewModel

@Composable
fun ProductsListScreen(modifier: Modifier) {
    val productsListScreenViewModel = hiltViewModel<ProductsListScreenViewModel>()
    val productsFLow = productsListScreenViewModel.productsFLow.collectAsStateWithLifecycle()
    LaunchedEffect(Unit){
        productsListScreenViewModel.getAllData()
    }
    if(productsFLow.value.isDataSuccess())
        ProductsListView((productsFLow.value as DataSuccess).data, modifier)
    else if(productsFLow.value.isDataError())
        Text((productsFLow.value as DataError).message)
    else if(productsFLow.value.isDataLoading())
        CircularProgressIndicator()

}