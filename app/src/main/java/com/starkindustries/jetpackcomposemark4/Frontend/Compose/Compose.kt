package com.starkindustries.jetpackcomposemark4.Frontend.Compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview
import com.starkindustries.jetpackcomposemark4.Data.ListItemData
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Compose() {
    var list by rememberSaveable {
        mutableStateOf(
            (1..20).map {
                ListItemData("Item $it", false)
            }
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(list.size) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    list=list.mapIndexed{
                        index,item->
                        if(it==index)
                            item.copy(isSelected = true)
                        else
                            item
                    }
                }
                .height(70.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = list[it].title,
                    fontWeight = FontWeight.W400,
                    fontSize = 15.sp
                )
                if(list.get(it).isSelected){
                    Icon(imageVector =Icons.Default.Check, contentDescription = "",
                        tint = Color.Green
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunction(){
    Compose()
}