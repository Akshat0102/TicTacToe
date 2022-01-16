package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val playerO : Int = 0
    private val playerX : Int = 1

    private val activePlayer = playerO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn01: Button = findViewById(R.id.btn_01)
        val btn02: Button = findViewById(R.id.btn_02)
        val btn03: Button = findViewById(R.id.btn_03)
        val btn04: Button = findViewById(R.id.btn_04)
        val btn05: Button = findViewById(R.id.btn_05)
        val btn06: Button = findViewById(R.id.btn_06)
        val btn07: Button = findViewById(R.id.btn_07)
        val btn08: Button = findViewById(R.id.btn_08)
        val btn09: Button = findViewById(R.id.btn_09)

        btn01.setOnClickListener { markBox() }
        btn02.setOnClickListener { markBox() }
        btn03.setOnClickListener { markBox() }
        btn04.setOnClickListener { markBox() }
        btn05.setOnClickListener { markBox() }
        btn06.setOnClickListener { markBox() }
        btn07.setOnClickListener { markBox() }
        btn08.setOnClickListener { markBox() }
        btn09.setOnClickListener { markBox() }
    }

    private fun markBox() {


    }
}