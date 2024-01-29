package com.hasantuncay.composeComponents.components


import androidx.compose.runtime.Composable


import androidx.paging.Pager
import androidx.paging.compose.collectAsLazyPagingItems

import androidx.paging.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

import java.util.*

@Composable
fun PagingExample() {
    val pager = Pager(PagingConfig(pageSize = 20)) {
        RandomNumberPagingSource()
    }
    MessageList(pager)
}

class RandomNumberPagingSource : PagingSource<Int, Int>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Int> {
        val pageNumber = params.key ?: 0
        val randomNumbers = List(123) { Random().nextInt(20000) + 1 }
        return LoadResult.Page(
            data = randomNumbers,
            prevKey = if (pageNumber > 0) pageNumber - 1 else null,
            nextKey = if (randomNumbers.isNotEmpty()) pageNumber + 1 else null
        )
    }

    override fun getRefreshKey(state: PagingState<Int, Int>): Int? {
        return state.anchorPosition
    }
}

@Composable
fun MessageList(pager: Pager<Int, Int>) {

    var count by remember {
        mutableStateOf(0)
    }
    val lazyPagingItems = pager.flow.collectAsLazyPagingItems()
    LazyColumn {
        count++
        items(lazyPagingItems.itemCount) { index ->

            val message = lazyPagingItems[index]

          Text(text = "        ${count} : $message  ")
        }
    }
}

 @Preview
@Composable
fun PagingPreview(){
     PagingExample()
}


