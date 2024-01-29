package com.hasantuncay.composeComponents.components
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LazyColumn() {
    Column {

        val dataList = listOf("Öğe 1", "Öğe 2", "Öğe 3", "Öğe 4", "Öğe 5")

        LazyColumn {
            items(dataList) { item ->
                ListItem(item)
            }
        }

    }


}
@Composable
fun ListItem(item: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = item)

    }
}

@Preview
@Composable
fun ListsAndGridsPreview(){
    LazyColumn()
}