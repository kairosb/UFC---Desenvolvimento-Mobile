package com.example.auth2.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth2.data.AuthRepository
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {
    var loginResult: ((Boolean) -> Unit)? = null
    var registerResult: ((Boolean) -> Unit)? = null

    fun register(email: String, password: String, onResult: (Boolean) -> Unit, name: String) {
        viewModelScope.launch {
            val result = repository.registerUser(email, password, name)
            onResult(result)
        }
    }

    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val success = repository.loginUser(email, password)
            onResult(success)
        }

    }

    fun resetPassword(email: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = repository.resetPassword(email)
            onResult(result)
        }
    }

    fun getUserName(onResult: (String?) -> Unit) {
        viewModelScope.launch {
            val result = repository.getUserName()
            onResult(result)
        }
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    fun loginWithGoogle(idToken: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = repository.loginWithGoogle(idToken)
            onResult(result)
        }
    }

    fun isUserLogged(): Boolean {
        return repository.isUserLogged()
    }

    fun getGoogleSignInClient(context: Context): GoogleSignInClient {
        return repository.getGoogleSignInClient(context)
    }
}