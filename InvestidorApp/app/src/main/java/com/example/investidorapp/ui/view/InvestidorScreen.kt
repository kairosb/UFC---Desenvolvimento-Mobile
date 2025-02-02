package com.example.investidorapp.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.investidorapp.model.Investimento
import com.example.investidorapp.viewmodel.InvestimentosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvestidorScreen(viewModel: InvestimentosViewModel) {
    val investimentos by viewModel.investimento.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    var snackbarMessage by remember { mutableStateOf<String?>(null) }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Investidor App",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1E88E5), // Azul forte
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = Color(0xFFF0F2F5) // Fundo cinza claro
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ListaInvestimentos(investimentos)

            snackbarMessage?.let { message ->
                LaunchedEffect(message) {
                    snackbarHostState.showSnackbar(message)
                    snackbarMessage = null
                }
            }
        }
    }
}

@Composable
fun ListaInvestimentos(investimentos: List<Investimento>) {
    if (investimentos.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Nenhum investimento cadastrado.",
                color = Color.Gray
            )
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(investimentos) { investimento ->
                InvestimentoItem(investimento)
            }
        }
    }
}

@Composable
fun InvestimentoItem(investimento: Investimento) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1976D2) // Azul escuro
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Ícone",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    text = investimento.nome,
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Valor: R$ ${investimento.valor}",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
