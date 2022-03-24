package com.example.play_0_0_2.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.play_0_0_2.ui.User
import com.example.play_0_0_2.ui.UserViewModel
import java.util.*

@Composable
fun UserView(vm:UserViewModel) {
   // val vm by remember { mutableStateOf(UserViewModel()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Users") },
                actions = {
                    IconButton(onClick = {
                        vm.addUser(User(UUID.randomUUID(), "User"))
                    }) {
                        Icon(Icons.Filled.Add, null)
                    }
                })
        },
        content = {
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(vm.users) {
                    Column {
                        Text(it.name)
                        Text("${it.id}")
                    }
                }
            }
        }
    )
}