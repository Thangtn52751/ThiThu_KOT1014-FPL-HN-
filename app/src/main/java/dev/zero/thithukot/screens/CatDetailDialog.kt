package dev.zero.thithukot.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import dev.zero.thithukot.model.Cat

@Composable
fun CatDetailDialog(cat: Cat, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            elevation = 8.dp,
            modifier = Modifier
                .fillMaxWidth(0.95f) // Chiếm 95% chiều ngang màn hình
                .wrapContentHeight()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Chi tiết loài mèo",
                    style = MaterialTheme.typography.h6
                )

                Spacer(modifier = Modifier.height(12.dp))

                AsyncImage(
                    model = "https://cataas.com/cat/${cat.id}",
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text("Tên (tags): ${cat.tags.joinToString(", ")}")
                Spacer(modifier = Modifier.height(4.dp))
                Text("ID: ${cat.id}")

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Đóng")
                    }
                }
            }
        }
    }
}
