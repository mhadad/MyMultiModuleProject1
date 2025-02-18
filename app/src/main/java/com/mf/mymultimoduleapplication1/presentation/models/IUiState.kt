package com.mf.mymultimoduleapplication1.presentation.models

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed class IUiState {
    @OptIn(ExperimentalContracts::class)
    fun isEventProductList(): Boolean{
        contract {
            returns(true) implies (this@IUiState is UiStateProductsListImpl)
        }
        return this is UiStateProductsListImpl
    }
    @OptIn(ExperimentalContracts::class)
    fun isEventProductSearch(): Boolean{
        contract {
            returns(true) implies (this@IUiState is UiStateProductsSearchImpl)
        }
        return this is UiStateProductsSearchImpl
    }

}