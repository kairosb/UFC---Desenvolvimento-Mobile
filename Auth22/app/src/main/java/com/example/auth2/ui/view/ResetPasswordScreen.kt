package com.example.auth2.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.auth2.viewmodel.AuthViewModel

@Composable
fun ResetPasswordScreen(viewModel: AuthViewModel = viewModel(), onBackToLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var successMessage by remember { mutableStateOf<String?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Reset Password", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(value = email, onValueChange = { email = it }, modifier = Modifier.fillMaxWidth())

        successMessage?.let {
            Text(text = it, color = MaterialTheme.colorScheme.primary)
        }

        errorMessage?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.resetPassword(email) { success ->
                if (success) {
                    successMessage = "Reset link sent to your email"
                } else {
                    errorMessage = "Failed to send reset link"
                }
            }
        }) {
            Text(text = "Reset Password")
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = onBackToLogin) {
            Text(text = "Back to Login")
        }
    }
}
