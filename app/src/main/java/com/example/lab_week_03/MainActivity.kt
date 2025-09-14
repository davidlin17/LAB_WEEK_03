package com.example.lab_week_03

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    interface CoffeeListener { fun onSelected(id: Int) }

    class MainActivity : AppCompatActivity(), CoffeeListener {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { v, insets ->
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val sb = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(sb.left, sb.top, sb.right, sb.bottom)
                    insets
                    v.setPadding(sb.left, sb.top, sb.right, sb.bottom); insets
                }
                Log.d(TAG, "onCreate")
            }
            override fun onStart() { super.onStart(); Log.d(TAG, "onStart") }
            override fun onResume() { super.onResume(); Log.d(TAG, "onResume") }
            override fun onPause() { super.onPause(); Log.d(TAG, "onPause") }
            override fun onStop() { super.onStop(); Log.d(TAG, "onStop") }
            override fun onDestroy() { super.onDestroy(); Log.d(TAG, "onDestroy") }

            companion object { private const val TAG = "MainActivity" }
            override fun onSelected(id: Int) {
                val detail = supportFragmentManager.findFragmentById(R.id.fragment_detail) as DetailFragment
                detail.setCoffeeData(id)
            }
        }