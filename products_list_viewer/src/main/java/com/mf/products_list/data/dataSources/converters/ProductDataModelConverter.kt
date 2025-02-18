package com.mf.products_list.data.dataSources.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mf.products_list.data.models.DimensionsDataModel
import com.mf.products_list.data.models.MetaDataModel
import com.mf.products_list.data.models.ReviewsDataModel
import com.mf.products_list.domain.models.MetaUiModel

class ProductDataModelConverter {
    private val gson = Gson()
    @TypeConverter
    fun fromStringList(data: List<String>): String{
        return gson.toJson(data)
    }

    @TypeConverter
    fun toStringList(data: String): List<String>{
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun fromDoubleList(data: List<Double>): String{
        return gson.toJson(data)
    }

    @TypeConverter
    fun toDoubleList(data: String): List<Double>{
        val type = object : TypeToken<List<Double>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun fromMetaModelList(data: List<MetaDataModel>): String{
        return  gson.toJson(data)
    }

    @TypeConverter
    fun toMetaModelList(data: String): List<MetaDataModel>{
        val type = object : TypeToken<List<MetaDataModel>>() {}.type
        return gson.fromJson(data, type)
    }
    @TypeConverter
    fun fomReviewsModelList(data: List<ReviewsDataModel>): String{
        return gson.toJson(data)
    }

    @TypeConverter
    fun toReviewsModelList(data: String): List<ReviewsDataModel>{
        val type = object : TypeToken<List<ReviewsDataModel>>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun fromDimensionsModel(data: DimensionsDataModel): String{
        return  gson.toJson(data)
    }

    @TypeConverter
    fun toDimensionsModel(data: String): DimensionsDataModel{
        val type = object : TypeToken<DimensionsDataModel>() {}.type
        return gson.fromJson(data, type)
    }

    @TypeConverter
    fun fromMetaModel(data: MetaDataModel): String{
        return  gson.toJson(data)
    }

    @TypeConverter
    fun toMetaModel(data: String): MetaDataModel{
        val type = object : TypeToken<MetaDataModel>() {}.type
        return gson.fromJson(data, type)
    }

}