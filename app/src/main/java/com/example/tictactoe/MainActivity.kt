package com.example.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var actual_player="-"
    var board = "---"+
                "---"+
                "---"
    var game_over:Boolean = false

    var scoreX = 0
    var scoreO = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                /*scoreX++
                txtpuntuacionX.setText(scoreX)*/


//        Toast.makeText(this,winner(board,actual_player),Toast.LENGTH_LONG).show()
        //refresh(board)
    }

    fun button_pressed(view: View){
        if(game_over){
            return
        }
        var index = resources.getResourceName(view.id).last().toString().toInt()
        if (board[index] !='-'){
            return
        }
        var charA = board.toCharArray()
        charA[index] = actual_player.first().toChar()
        board = String(charA)

        //Alguien gano?
        var winX = "Gano X"
        var winO = "Gano O"
        var msj = ""
        when(winner(board, actual_player)) {
            "X" -> {
            game_over=true
            winX = "Gano X"
                Toast.makeText(this,winX,Toast.LENGTH_SHORT).show()
                scoreX++
                txtpuntuacionX.setText(scoreX)

        }
            "O" -> {
            game_over=true
            winO = "Gano O"
                Toast.makeText(this,winO,Toast.LENGTH_SHORT).show()
                scoreO++
                txtpuntuacionO.setText(scoreO)
        }
            "D" -> {
            game_over=true
            msj = "Empate"
                Toast.makeText(this,msj,Toast.LENGTH_SHORT).show()
        }
            else-> ""
        }

        if (actual_player == "X"){
            actual_player = "O"
        }else{
            actual_player = "X"
        }
        refresh(board)
//        var button = findViewById<Button>(view.id)
//        button.text = actual_player
//        board[] = actual_player
    }


    fun refresh(board: String) {
        for ((index, value) in board.withIndex()) {
            val id = resources.getIdentifier("cell_" + index.toInt(), "id", this.packageName)
            var b = findViewById<Button>(id)
            var symbol = value.toString()
            if(symbol != "-"){
                b.text = symbol
            }else{
                b.text = ""
            }
        }
    }
    fun winner(b: String, actual_player:String):String{
        if( (b[0]==b[1] && b[1]==b[2] && b[2]!='-')||
            (b[3]==b[4] && b[4]==b[5] && b[5]!='-')||
            (b[6]==b[7] && b[7]==b[8] && b[8]!='-')||
            (b[0]==b[3] && b[3]==b[6] && b[6]!='-')||
            (b[1]==b[4] && b[4]==b[7] && b[7]!='-')||
            (b[2]==b[5] && b[5]==b[8] && b[8]!='-')||
            (b[0]==b[4] && b[4]==b[8] && b[8]!='-')||
            (b[2]==b[4] && b[4]==b[6] && b[6]!='-')) {
            return actual_player
        }
        if(b.contains("-")){
            return "C"
        }
        return "D"
    }
    fun reset(view: View){
        board = "---------"
        game_over = false
        if (actual_player == "X"){
            actual_player = "O"
        }else{
            actual_player = "X"
        }
        refresh(board)
    }







}
