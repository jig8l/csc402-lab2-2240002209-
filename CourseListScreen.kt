package edu.iau.cshj.csc402.lab2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.lab2.ui.theme.AndroidGreen
import edu.iau.cshj.csc402.lab2.ui.theme.Navy
import edu.iau.cshj.csc402.lab2.ui.theme.ScreenBackground

@Composable
fun CourseListScreen() {
    val courses = remember {
        listOf(
            Course("CSC 402", "Mobile Application Programming", 3, "Mon / Wed"),
            Course("CSC 311", "Database Systems", 4, "Sun / Tue"),
            Course("CSC 340", "Operating Systems", 3, "Mon / Wed"),
            Course("MATH 202", "Discrete Mathematics", 3, "Sun / Thu"),
            Course("ENG 214", "Technical Writing", 2, "Tue"),
            Course("PHYS 105", "General Physics II", 4, "Sun / Tue"),
            Course("ISLM 101", "Islamic Culture", 2, "Thu")
        )
    }

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
                Text(text = "Task 10 - Course List", color = Color.LightGray, fontSize = 14.sp)
            }
        }

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(courses) { course ->
                CourseRow(course)
            }
        }
    }
}

@Composable
fun CourseRow(course: Course) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(5.dp)
                    .height(60.dp)
                    .background(AndroidGreen)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = course.code, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = Navy)
                Text(
                    text = course.title,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(text = course.days, color = Color.Gray, fontSize = 11.sp)
            }

            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFE8F5E9))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(text = "${course.credits} cr", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E7D32))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListScreen()
}