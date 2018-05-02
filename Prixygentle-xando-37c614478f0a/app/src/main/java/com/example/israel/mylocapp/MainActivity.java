package com.example.israel.mylocapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.israel.mylocapp.model.AppUtil;
import com.example.israel.mylocapp.model.Game;
import com.example.israel.mylocapp.model.GameHandler;

public class MainActivity extends Activity{

    public static String LOG_HANDLE = "XandO";
        /**
         * fetch text views*/
        TextView firstRowFirstColumn,firstRowSecondColumn,firstRowThirdColumn;
        TextView secondRowFirstColumn,secondRowSecondColumn,secondRowThirdColumn;
        TextView thirdRowFirstColumn,thirdRowSecondColumn,thirdRowThirdColumn;
        TextView playerIndicator;

        Button resetButton;
        TextView displayProgress;

    private GameHandler gameHandler;

    private void loadWidgets(){

        firstRowFirstColumn = (TextView) findViewById(R.id.first_row_first_column);
        firstRowSecondColumn = (TextView) findViewById(R.id.first_row_second_column);
        firstRowThirdColumn = (TextView) findViewById(R.id.first_row_third_column);
        secondRowFirstColumn = (TextView) findViewById(R.id.second_row_first_column);
        secondRowSecondColumn = (TextView) findViewById(R.id.second_row_second_column);
        secondRowThirdColumn = (TextView) findViewById(R.id.second_row_third_column);
        thirdRowFirstColumn = (TextView) findViewById(R.id.third_row_first_column);
        thirdRowSecondColumn = (TextView) findViewById(R.id.third_row_second_column);
        thirdRowThirdColumn = (TextView) findViewById(R.id.third_row_third_column);
        resetButton=(Button)findViewById(R.id.reset_button);
        displayProgress=(TextView)findViewById(R.id.display_progress);
        playerIndicator = (TextView)findViewById(R.id.player_indicator);

    }

    //oncreate method
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppUtil.log("loading widgets");

        //load widgets
        loadWidgets();

        //start game
        startGame();



    }


    private void startGame(){

        //start new game
        gameHandler = new GameHandler(Game.builder()
                .withSquare1(firstRowFirstColumn)
                .withSquare2(firstRowSecondColumn)
                .withSquare3(firstRowThirdColumn)
                .withSquare4(secondRowFirstColumn)
                .withSquare5(secondRowSecondColumn)
                .withSquare6(secondRowThirdColumn)
                .withSquare7(thirdRowFirstColumn)
                .withSquare8(thirdRowSecondColumn)
                .withSquare9(thirdRowThirdColumn)
                .withPlayerIndicator(playerIndicator)
                .withContext(this)
                .build());

        AppUtil.log("about to start game");

        gameHandler.resetGame();
        AppUtil.log("game has started");

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameHandler.resetGame();
            }
        });

    }


}
