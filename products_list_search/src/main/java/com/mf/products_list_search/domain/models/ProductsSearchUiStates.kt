package com.mf.products_list_search.domain.models

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed class ProductsSearchUiStates<out T> {
    @OptIn(ExperimentalContracts::class)
    inline fun isDataSuccess(): Boolean {
        contract {
            returns(true) implies (this@ProductsSearchUiStates is DataSuccess)
            returns(false) implies (this@ProductsSearchUiStates !is DataSuccess)
        }
        return this@ProductsSearchUiStates is DataSuccess
    }

    @OptIn(ExperimentalContracts::class)
    inline fun isDataError(): Boolean {
        contract {
            returns(true) implies (this@ProductsSearchUiStates is DataError)
            returns(false) implies (this@ProductsSearchUiStates !is DataError)
        }
        return this@ProductsSearchUiStates is DataError
    }

    @OptIn(ExperimentalContracts::class)
    inline fun isDataLoading(): Boolean {
        contract {
            returns(true) implies (this@ProductsSearchUiStates is DataLoading)
            returns(false) implies (this@ProductsSearchUiStates !is DataLoading)
        }
        return this@ProductsSearchUiStates is DataLoading
    }

    class DataSuccess(val data: List<ProductUiModel>) :
        ProductsSearchUiStates<List<ProductUiModel>>()

    class DataError(val message: String) : ProductsSearchUiStates<String>()
    object DataLoading : ProductsSearchUiStates<Nothing>()
    object UnInitialized : ProductsSearchUiStates<Nothing>()
}