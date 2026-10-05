package edu.iau.cshj.csc402.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

             WelcomeScreen()
            // StudentIdScreen()
            // AttendanceCounter()
            // GreetingCard()
            // CourseListScreen()
           // TaskTrackerScreen()
        }
    }
}