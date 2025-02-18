package com.mf.products_list.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.mf.products_list.domain.models.ProductUiModel
import com.mf.products_list.R

@Composable
fun ProductsListView(data: List<ProductUiModel>, modifier: Modifier) {
    LazyColumn(modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        contentPadding = PaddingValues(5.dp),
        ) {
        itemsIndexed(items= data, key = {index: Int, item: ProductUiModel->
            item.id
        }, itemContent = {_,  item->
            Card(shape = CardDefaults.elevatedShape,
                elevation = CardDefaults.elevatedCardElevation(10.dp, 10.dp, 10.dp,10.dp, 10.dp, 2.dp),
                ) {
                SubcomposeAsyncImage(
                    model = item.images.elementAtOrElse(0){R.drawable.baseline_broken_image_24},
                    contentDescription = item.description,
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center,
                    loading = { CircularProgressIndicator(modifier = Modifier.fillMaxWidth(0.9f)) },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .size(200.dp)
                    )
                Text("${item.rating}/5",
                    textDecoration = TextDecoration.Underline,
                    color = Color.Yellow,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic)
                Text(item.title,
                    fontSize = TextUnit(16.0f, TextUnitType.Sp),
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Normal
                )
                Text(text = item.description,
                    fontSize = TextUnit(12.0f, TextUnitType.Sp),
                    maxLines = 3,
                    softWrap = true,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Thin,
                    fontStyle = FontStyle.Italic
                )
            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp),
            )
        })
    }
}