package com.serhio.homeaccountingapp;
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun SettingsMenu(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.8f))
            .clickable(enabled = true, onClick = {})
            .zIndex(1f),
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .border(2.dp, Color.White, RoundedCornerShape(8.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Gray.copy(alpha = 0.8f), Color.Black.copy(alpha = 0.8f))
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .widthIn(max = 300.dp)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Налаштування",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Мова:", color = Color.White)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                LanguageOption("UK")
                LanguageOption("EN")
                LanguageOption("RU")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color.Gray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Валюта:", color = Color.White)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CurrencyOption("UAH")
                CurrencyOption("USD")
                CurrencyOption("EUR")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TextButton(onClick = onDismiss) {
                    Text("Закрити", color = Color.Red)
                }
                TextButton(onClick = { /* Handle save action */ }) {
                    Text("Зберегти", color = Color.Green)
                }
            }
        }
    }
}

@Composable
fun LanguageOption(language: String) {
    Button(
        onClick = { /* Handle language change */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow.copy(alpha = 0.5f),
            contentColor = Color.White
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
    ) {
        Text(text = language)
    }
}

@Composable
fun CurrencyOption(currency: String) {
    Button(
        onClick = { /* Handle currency change */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue.copy(alpha = 0.5f),
            contentColor = Color.White
        ),
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
    ) {
        Text(text = currency)
    }
}