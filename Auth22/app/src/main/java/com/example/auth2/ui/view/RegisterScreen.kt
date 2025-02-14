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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.auth2.viewmodel.AuthViewModel

@Composable
fun RegisterScreen(viewModel: AuthViewModel = viewModel(), onNavigateToLogin: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Register", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(value = name, onValueChange = { name = it }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(value = email, onValueChange = { email = it }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        errorMessage?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.register(email, password, { success ->
                if (success) {
                    onNavigateToLogin()
                } else {
                    errorMessage = "Registration failed"
                }
            }, name)
        }) {
            Text(text = "Register")
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextButton (onClick = onNavigateToLogin) {
            Text(text = "Already have an account? Login here")
        }
    }
}
