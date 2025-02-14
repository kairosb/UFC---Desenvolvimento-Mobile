package com.example.auth2.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.auth2.viewmodel.AuthViewModel

@Composable
fun LogoutScreen(viewModel: AuthViewModel = viewModel(), onLogoutSuccess: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Are you sure you want to logout?", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))
        Button (onClick = {
            viewModel.logout()
            onLogoutSuccess()
        }) {
            Text(text = "Logout")
        }
    }
}
