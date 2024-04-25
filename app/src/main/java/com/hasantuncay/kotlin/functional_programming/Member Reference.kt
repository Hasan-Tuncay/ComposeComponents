package com.hasantuncay.kotlin.functional_programming

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Greeting(name: String, onClick: (String) -> Unit) {
    Text(text = "Merhaba, $name!", modifier = Modifier.clickable { onClick(name) })
}

@Composable
fun UserList(users: List<String>, onUserClick: (String) -> Unit) {

    LazyColumn {
        items(users.size) { user ->

            Greeting(name = users[user], onClick = onUserClick)
        }
    }
}

// Kullanıcı tıklama aksiyonunu işleyen fonksiyon
fun onUserSelected(userName: String) {
    println("$userName seçildi.")
}

//@Composable
//fun MyApp() {
//    val users = listOf("Alice", "Bob", "Charlie")
//    UserList(users = users, onUserClick = ::onUserSelected)
//}
@Composable
fun CustomButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Tıkla")
    }
}

//@Composable
//fun MyApp() {
//    CustomButton {
//        println("Butona tıklandı!")
//    }
//}
data class User(val name: String,val age:Int)
@Composable
fun UsersList(users: List<User>, filter: (User) -> Boolean) {
    val filteredUsers = users.filter(filter)
    val filteredUsersNormal = users.filter { user -> user.age >= 18 }
    println("filteredUsers $filteredUsers.")
    LazyColumn {
        items(filteredUsers.size) { user ->
            Text("Kullanıcı: ${filteredUsers.get(user).name}, Yaş: ${filteredUsers.get(user).age}")
        }
    }
}

@Composable
fun MyApp() {
    val users = listOf(User("Ali", 20), User("Ayşe", 17), User("Mehmet", 22))
    UsersList(users = users) { user ->
        user.age >= 18

    }
    val isAdult: (User) -> Boolean = { user -> user.age >= 18 }
}
@Preview
@Composable
fun PreviewGreeting(){
    MyApp()
}