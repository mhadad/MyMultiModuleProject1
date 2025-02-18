package com.mf.products_list.data.models

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed class DataRequestState {
    @OptIn(ExperimentalContracts::class)
     fun hasData(): Boolean{
        contract {
            returns(true) implies (this@DataRequestState is DataRequestSuccess)
        }
        return this@DataRequestState is DataRequestSuccess
    }

    @OptIn(ExperimentalContracts::class)
    inline fun hasError(): Boolean {
        contract {
            returns(true) implies (this@DataRequestState is DataRequestError)
        }
        return this@DataRequestState is DataRequestError
    }
}
class DataRequestSuccess(val data: ProductsDataModel) : DataRequestState(){}
class DataRequestError(val errorMessage: String) : DataRequestState(){}
object DataRequestLoading: DataRequestState()