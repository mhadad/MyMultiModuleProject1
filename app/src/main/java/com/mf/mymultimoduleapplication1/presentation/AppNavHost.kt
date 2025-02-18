package com.mf.mymultimoduleapplication1.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mf.mymultimoduleapplication1.presentation.screens.SelectionScreen
import com.mf.products_list.presentation.screens.ProductsListScreen
import com.mf.products_list_search.presentation.screens.SearchProductsScreen

@Composable
fun AppNavHost(innerPaddingValues: PaddingValues) {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = "selection_screen") {
            composable("selection_screen") { SelectionScreen(Modifier.padding(innerPaddingValues)) {
                if(it.isEventProductSearch()){
                    navigationController.navigate("products_search")
                }
                else if(it.isEventProductList()){
                    navigationController.navigate("products_list")
                }
            }}
            composable("products_search"){ SearchProductsScreen(modifier = Modifier.padding(innerPaddingValues))}
            composable("products_list"){ ProductsListScreen(modifier = Modifier.padding(innerPaddingValues)) }
//            composable("details/{itemId}") { backStackEntry ->
//                val itemId = backStackEntry.arguments?.getString("itemId")
//                DetailsScreen(navController, itemId)
//            }
        }
    }