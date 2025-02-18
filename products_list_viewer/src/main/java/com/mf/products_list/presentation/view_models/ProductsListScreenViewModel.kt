package com.mf.products_list.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mf.products_list.domain.ProductsViewUseCase
import com.mf.products_list.domain.models.DataSuccess
import com.mf.products_list.domain.models.ProductUiModel
import com.mf.products_list.domain.models.UiStates
import com.mf.products_list.domain.models.UnInitialized
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsListScreenViewModel @Inject constructor(private val productsViewUseCase: ProductsViewUseCase ): ViewModel() {
    private val _productsFLow = MutableStateFlow<UiStates>(UnInitialized)
    val productsFLow = _productsFLow.asStateFlow()
    fun getAllData(){
        viewModelScope.launch(Dispatchers.IO){
            productsViewUseCase.getAllProducts().collect{it?.let {
                _productsFLow.emit(DataSuccess(data = it))
            }}
        }
    }
}