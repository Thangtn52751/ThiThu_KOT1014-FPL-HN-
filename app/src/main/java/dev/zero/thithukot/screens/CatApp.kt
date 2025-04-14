package dev.zero.thithukot.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import dev.zero.thithukot.api.RetrofitInstance
import dev.zero.thithukot.model.Cat
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding


@Composable
fun CatApp() {
    var cats by remember { mutableStateOf(listOf<Cat>()) }
    var selectedCat by remember { mutableStateOf<Cat?>(null) }

    LaunchedEffect(Unit) {
        try {
            cats = RetrofitInstance.api.getCats()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Danh sách mèo") }) }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            LazyColumn(contentPadding = PaddingValues(16.dp)) {
                items(cats) { cat ->
                    CatItem(cat) { selectedCat = cat }
                }
            }
        }

        selectedCat?.let {
            CatDetailDialog(cat = it, onDismiss = { selectedCat = null })
        }
    }

}
