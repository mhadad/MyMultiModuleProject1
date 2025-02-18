package com.mf.products_list.domain.models

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed class UiStates {
    @OptIn(ExperimentalContracts::class)
    inline fun isDataSuccess(): Boolean{
        contract {
            returns(true) implies (this@UiStates is DataSuccess)
            returns(false) implies (this@UiStates !is DataSuccess)
        }
        return this@UiStates is DataSuccess
    }
    @OptIn(ExperimentalContracts::class)
    inline fun isDataError(): Boolean{
        contract {
            returns(true) implies (this@UiStates is DataError)
            returns(false) implies (this@UiStates !is DataError)
        }
        return this@UiStates is DataError
    }
    @OptIn(ExperimentalContracts::class)
    inline fun isDataLoading(): Boolean{
        contract {
            returns(true) implies (this@UiStates is DataLoading)
            returns(false) implies (this@UiStates !is DataLoading)
        }
        return this@UiStates is DataLoading
    }
}

class DataSuccess(val data: List<ProductUiModel>) : UiStates()
class DataError(val message: String): UiStates()
object DataLoading: UiStates()
object UnInitialized: UiStates()
