package com.example.lifecycleapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var lifecycleLog: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleLog = findViewById(R.id.lifecycleLog)

        // Restore saved logs if available
        savedInstanceState?.getString("logs")?.let {
            lifecycleLog.text = it
        }

        logLifecycleEvent("onCreate")
    }

    override fun onStart() {
        super.onStart()
        logLifecycleEvent("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifecycleEvent("onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifecycleEvent("onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleEvent("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleEvent("onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Save the current lifecycle logs
        outState.putString("logs", lifecycleLog.text.toString())
    }

    private fun logLifecycleEvent(eventName: String) {
        val time = SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())
        val date = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
        val logMessage = "$eventName at $time on $date\n"

        // Append the log message to the TextView
        lifecycleLog.append(logMessage)
    }
}

