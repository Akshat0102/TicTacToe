package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    enum class Turn {
        NOUGHT,
        CROSS
    }

    private var firstTurn = Turn.NOUGHT
    private var currentTurn = Turn.NOUGHT

    private var crossScore = 0
    private var noughtScore = 0

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

    companion object {
        const val NOUGHT = "O"
        const val CROSS = "X"
    }

    fun markBoard(view: View) {
        if (view !is Button) return
        addToBoard(view)

        if (fullBoard()) {
            result("Draw")
        }
        if (checkForVictory(NOUGHT)) {
            noughtScore++
            result("NOUGHTS WIN")
        }
        if (checkForVictory(CROSS)) {
            crossScore++
            result("CROSSES WIN")
        }
    }

    private fun checkForVictory(s: String): Boolean {

        //horizontal matching
        if (match(binding.btn01, s) && match(binding.btn02, s) && match(binding.btn03, s))
            return true
        if (match(binding.btn04, s) && match(binding.btn05, s) && match(binding.btn06, s))
            return true
        if (match(binding.btn07, s) && match(binding.btn08, s) && match(binding.btn09, s))
            return true

        //vertical matching
        if (match(binding.btn01, s) && match(binding.btn04, s) && match(binding.btn07, s))
            return true
        if (match(binding.btn02, s) && match(binding.btn05, s) && match(binding.btn08, s))
            return true
        if (match(binding.btn03, s) && match(binding.btn06, s) && match(binding.btn09, s))
            return true

        //diagonal matching
        if (match(binding.btn01, s) && match(binding.btn05, s) && match(binding.btn09, s))
            return true
        if (match(binding.btn03, s) && match(binding.btn05, s) && match(binding.btn07, s))
            return true
        return false
    }

    private fun match(button: Button, symbol: String): Boolean = button.text == symbol

    private fun result(title: String) {

        val message = "\n Noughts $noughtScore\n\nCrosses $crossScore"
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Reset") { _, _ ->
                resetBoard()
            }
            .setCancelable(false)
            .show()
    }

    private fun resetBoard() {
        for (button in boardList) {
            button.text = ""
        }
        if (firstTurn == Turn.NOUGHT) firstTurn = Turn.CROSS
        else if (firstTurn == Turn.CROSS) firstTurn = Turn.NOUGHT

        currentTurn = firstTurn
        setTurnLabel()
    }

    private fun fullBoard(): Boolean {
        for (button in boardList) {
            if (button.text == "") return false
        }
        return true
    }

    private fun addToBoard(button: Button) {

        if (button.text != "") return

        if (currentTurn == Turn.NOUGHT) {
            button.text = NOUGHT
            currentTurn = Turn.CROSS
        } else if (currentTurn == Turn.CROSS) {
            button.text = CROSS
            currentTurn = Turn.NOUGHT
        }
        setTurnLabel()
    }

    private fun setTurnLabel() {
        var turnText = ""
        if (currentTurn == Turn.CROSS) {
            turnText = "Turn $CROSS"
        } else if (currentTurn == Turn.NOUGHT) {
            turnText = "Turn $NOUGHT"
        }
        binding.turnText.text = turnText
    }
}