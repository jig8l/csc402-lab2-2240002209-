package edu.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import edu.iau.cshj.csc402.lab2.ui.theme.Navy
import edu.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

@Composable
fun GreetingCard() {
    var typedName by remember { mutableStateOf("") }
    var submittedName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Navy)
                .padding(vertical = 20.dp, horizontal = 16.dp)
        ) {
            Column {
                Text(text = "CSC 402 Lab 2", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(text = "Task 9 - Text Input & Card", color = Color.LightGray, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            OutlinedTextField(
                value = typedName,
                onValueChange = { typedName = it },
                label = { Text("Your name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { submittedName = typedName.trim() },
                enabled = typedName.isNotBlank(),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Navy)
            ) {
                Text(text = "Show greeting")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (submittedName.isBlank()) {
                        Text(text = "Enter a name above and press the button.", color = Color.Gray)
                    } else {
                        Text(text = "Marhaba, $submittedName!", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Navy)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Your name has ${submittedName.length} letters.", color = Color.Gray)
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(AndroidGreen)
                                .padding(horizontal = 12.dp, vertical = 4.dp)
                        ) {
                            Text(text = "CSC 402 - Lab 2", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    GreetingCard()
}