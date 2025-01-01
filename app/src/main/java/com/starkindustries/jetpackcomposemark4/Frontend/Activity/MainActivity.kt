package com.starkindustries.jetpackcomposemark4.Frontend.Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.starkindustries.jetpackcomposemark4.Data.ListItemData
import com.starkindustries.jetpackcomposemark4.Frontend.Compose.Compose
import com.starkindustries.jetpackcomposemark4.ui.theme.JetPackComposeMark4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeMark4Theme {
                Application()
            }
        }
    }
}

@Composable
fun Application(){
    var list by rememberSaveable {
        mutableStateOf(
            (1..20).map {
                ListItemData("Item $it",false)
            }
        )
    }
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        items(list.size){
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp).clickable {
                    list=list.mapIndexed{
                        index,item->
                        if(it==index)
                            item.copy(isSelected =true)
                        else
                            item
                    }
                },
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = list.get(it).title)
                if(list.get(it).isSelected){
                    Image(imageVector = Icons.Default.Check, contentDescription = "")
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewFunction(){
Application()
}


