package com.example.auth2.ui.view


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.auth2.viewmodel.AuthViewModel

@Composable
fun HomeScreen(viewModel: AuthViewModel = viewModel(), onLogout: () -> Unit) {

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Welcome!", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onLogout) {
            Text(text = "Logout")
        }
    }
}
