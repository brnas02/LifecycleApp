package com.example.lifecycleapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    // Declare a lateinit variable to reference the TextView
    private lateinit var lifecycleLog: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for this activity
        setContentView(R.layout.activity_main)

        // Initialize the TextView by finding it using its ID
        lifecycleLog = findViewById(R.id.lifecycleLog)

        // Restore saved logs if available
        savedInstanceState?.getString("logs")?.let {
            lifecycleLog.text = it
        }

        // Log the onCreate event
        logLifecycleEvent("onCreate")
    }

    override fun onStart() {
        super.onStart()
        // Log the onStart event
        logLifecycleEvent("onStart")
    }

    override fun onResume() {
        super.onResume()
        // Log the onResume event
        logLifecycleEvent("onResume")
    }

    override fun onPause() {
        super.onPause()
        // Log the onPause event
        logLifecycleEvent("onPause")
    }

    override fun onStop() {
        super.onStop()
        // Log the onStop event
        logLifecycleEvent("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Log the onDestroy event
        logLifecycleEvent("onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save the current content of the TextView (logs) to the Bundle
        outState.putString("logs", lifecycleLog.text.toString())
    }

    // Function to log lifecycle events with timestamp.
    private fun logLifecycleEvent(eventName: String) {
        // Get the current time and date
        val time = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

        // Format the log message
        val logMessage = "$eventName at $time on $date\n"

        // Append the log message to the TextView
        lifecycleLog.append(logMessage)
    }
}

