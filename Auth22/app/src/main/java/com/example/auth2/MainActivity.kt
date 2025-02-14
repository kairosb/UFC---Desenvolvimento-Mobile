package com.example.auth2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.auth2.ui.theme.Auth2Theme
import com.example.auth2.ui.view.HomeScreen
import com.example.auth2.ui.view.LoginScreen
import com.example.auth2.ui.view.RegisterScreen
import com.example.auth2.ui.view.ResetPasswordScreen
import com.example.auth2.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Auth2Theme {
                AuthApp()
            }
        }
    }
}

@Composable
fun AuthApp() {
    val navController = rememberNavController()
    val viewModel: AuthViewModel = viewModel()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = if (viewModel.isUserLogged()) "home" else "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") {
                LoginScreen (
                    viewModel = viewModel,
                    onNavigateToRegister = { navController.navigate("register") },
                    onLoginSuccess = { navController.navigate("home") }
                )
            }

            composable("register") {
                RegisterScreen (
                    viewModel = viewModel,
                    onNavigateToLogin = { navController.popBackStack("login", inclusive = false) }
                )
            }

            composable("resetPassword") {
                ResetPasswordScreen (
                    viewModel = viewModel,
                    onBackToLogin = { navController.popBackStack("login", inclusive = false) }
                )
            }

            composable("home") {
                HomeScreen (
                    viewModel = viewModel,
                    onLogout = {
                        viewModel.logout()
                        navController.navigate("login") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                )
            }
        }
    }
}
