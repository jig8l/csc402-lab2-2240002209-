package edu.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import edu.iau.cshj.csc402.lab2.ui.theme.Navy
import edu.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

@Composable
fun AttendanceCounter() {
    var count by remember { mutableStateOf(0) }

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
                Text(text = "Task 8 - Attendance Counter", color = Color.LightGray, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "STUDENTS PRESENT", color = Color.Gray, fontWeight = FontWeight.Bold, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "$count", fontSize = 52.sp, fontWeight = FontWeight.Bold, color = Navy)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { if (count > 0) count-- },
                    enabled = count > 0,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Black),
                    modifier = Modifier.width(80.dp)
                ) {
                    Text(text = "-", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(24.dp))

                Button(
                    onClick = { count++ },
                    colors = ButtonDefaults.buttonColors(containerColor = AndroidGreen, contentColor = Color.Black),
                    modifier = Modifier.width(80.dp)
                ) {
                    Text(text = "+", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { count = 0 },
                enabled = count > 0,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.Red)
            ) {
                Text(text = "Reset")
            }

            Spacer(modifier = Modifier.height(16.dp))

            val message = if (count == 0) "Tap + to check a student in." else "$count of 30 students checked in."
            Text(text = message, color = Color.Gray, fontSize = 14.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    AttendanceCounter()
}