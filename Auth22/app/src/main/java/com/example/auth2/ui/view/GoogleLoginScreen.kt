package com.example.auth2.ui.view

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.auth2.viewmodel.AuthViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn

@Composable
fun GoogleLoginScreen(viewModel: AuthViewModel = viewModel(), onLoginSuccess: () -> Unit) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Login with Google", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))
        Button (onClick = {
            val googleSignInClient = viewModel.getGoogleSignInClient(context)
            val signInIntent = googleSignInClient.signInIntent
            // Handle Google Sign-In Result in Activity
        }) {
            Text(text = "Sign in with Google")
        }
    }
}
