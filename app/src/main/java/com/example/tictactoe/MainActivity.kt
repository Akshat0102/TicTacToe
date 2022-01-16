package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    enum class Turn {
        NOUGHT,
        CROSS
    }

    private var firstTurn = Turn.NOUGHT
    private var currentTurn = Turn.NOUGHT

    private var boardList = mutableListOf<Button>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBoard()

    }

    private fun initBoard() {
        boardList.add(binding.btn01)
        boardList.add(binding.btn02)
        boardList.add(binding.btn03)
        boardList.add(binding.btn04)
        boardList.add(binding.btn05)
        boardList.add(binding.btn06)
        boardList.add(binding.btn07)
        boardList.add(binding.btn08)
        boardList.add(binding.btn09)
    }

    companion object{
        const val NOUGHT = "O"
        const val CROSS = "X"
    }

    fun markBoard(view: View) {
        if (view !is Button) return
        addToBoard(view)
    }

    private fun addToBoard(button: Button) {

        if(button.text != "") return

        if(currentTurn == Turn.NOUGHT){
            button.text = NOUGHT
            currentTurn = Turn.CROSS
        }
        else if(currentTurn == Turn.CROSS){
            button.text = CROSS
            currentTurn = Turn.NOUGHT
        }
        setTurnLabel()
    }

    private fun setTurnLabel() {
        var turnText = ""
        if(currentTurn == Turn.CROSS){
            turnText = "Turn $CROSS"
        }
        else if(currentTurn == Turn.NOUGHT){
            turnText = "Turn $NOUGHT"
        }
        
        binding.turnText.text = turnText
    }
}