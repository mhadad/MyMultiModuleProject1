package com.mf.products_list_search.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mf.products_list_search.domain.ProductsViewUseCase
import com.mf.products_list_search.domain.models.ProductUiModel
import com.mf.products_list_search.domain.models.ProductsSearchUiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsSearchViewModel @Inject constructor(private val productsUseCase: ProductsViewUseCase): ViewModel() {
    private val _productsFlow: MutableStateFlow<ProductsSearchUiStates<*>> =
        MutableStateFlow<ProductsSearchUiStates<*>>(value = ProductsSearchUiStates.UnInitialized
//            replay = 10,
//            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )
    val productsFlow: SharedFlow<ProductsSearchUiStates<*>> = _productsFlow.asSharedFlow()
    private var productsList : List<ProductUiModel> = emptyList()
    fun getAllProducts(limit: Int = 0) {
        viewModelScope.launch(Dispatchers.IO) {
            _productsFlow.emit(ProductsSearchUiStates.DataLoading)
            productsUseCase.getAllProducts(limit).collect {
                _productsFlow.emit(it)
                if(it.isDataSuccess())
                    productsList = it.data
            }
        }
    }

    fun execSearch(query: String) {
        if(query.trim().isEmpty()) {
            getAllProducts()
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
             val currentStateVal = _productsFlow.value
            if(currentStateVal.isDataSuccess()) {
                _productsFlow.emit(ProductsSearchUiStates.DataSuccess(productsList.filter {
                    it.title?.let {
                        it.contains(query.trim())
                    } == true
//                if(it.isDataSuccess())
//                (it as ProductsSearchUiStates.DataSuccess).data.filter {
//                        it.title?.let {
//                            it.contains(query)
//                        } == true
//                    }
                }))
            }
//                        .collectLatest {
//                    if (it.isDataSuccess())
//                        it.data.filter {
//                            it.title?.let {
//                                it.contains(query)
//                            } == true
//                        }.isNotEmpty()
//            }
        }
    }
}