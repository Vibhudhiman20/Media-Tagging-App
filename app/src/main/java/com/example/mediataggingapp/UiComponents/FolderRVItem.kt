package com.example.mediataggingapp.UiComponents

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mediataggingapp.R
import com.example.mediataggingapp.data.FolderDetails
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@ExperimentalFoundationApi
@Composable
fun FolderRVItem(navController: NavController) {

    val context = LocalContext.current
    val dataFileString = getJsonDataFromAsset(context, "FolderList.json")
    val gson = Gson()
    val gridSampleType = object : TypeToken<List<FolderDetails>>() {}.type
    val folderData: List<FolderDetails> = gson.fromJson(dataFileString, gridSampleType)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(10.dp)
        ) {

            items(folderData) { data ->
                FolderDataGridItem(data, navController)
            }
        }
    }
}

fun getJsonDataFromAsset(context: Context, data: String): String {
    return context.assets.open(data).bufferedReader().use { it.readText() }
}

@Composable
fun FolderDataGridItem(data: FolderDetails, navController: NavController) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable {
                val itemVal = Gson().toJson(data)
                navController.navigate("grid_detail/$itemVal")
            },
        shape = RoundedCornerShape(5.dp),
    ) {
        Column(modifier = Modifier) {
            Image(
                painter = painterResource(
                    id = R.drawable.folder_img
                ),
                contentDescription = "Grid Image",
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(5.dp)),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = data.name,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.padding(1.dp))
            Text(
                text = data.description ,
                modifier = Modifier.padding(7.dp, 0.dp, 0.dp, 20.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
