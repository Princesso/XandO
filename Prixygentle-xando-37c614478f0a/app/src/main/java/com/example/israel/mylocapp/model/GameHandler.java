package com.example.israel.mylocapp.model;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author .: Chukwudum Ekwueme
 * @email ..: chidumekwueme@gmail.com, chukwudum.ekwueme@cwlgroup.com
 * @created : 7/27/17 4:34 PM
 */
public class GameHandler {

    private Game game;
    private AppUtil appUtil;

    private boolean isPlayer1Turn;
    private static String PLAYER_1_HANDLE = "Player 1";
    private static String PLAYER_2_HANDLE = "Player 2";
    private static int NUMBER_POSSIBLE_PLAYS = 9;
    private HashMap<String, String> plays;
    private static String PLAYER_ONE_KEY = "X";
    private static String PLAYER_TWO_KEY = "O";

    private List<String> winningCombinations;

    public GameHandler(Game game){
        
        winningCombinations = new ArrayList<>();
        winningCombinations.add("012");
        winningCombinations.add("345");
        winningCombinations.add("678");
        winningCombinations.add("048");
        winningCombinations.add("246");
        winningCombinations.add("036");
        winningCombinations.add("147");
        winningCombinations.add("258");
        
        appUtil = new AppUtil(game.getContext());
        this.game = game;
    }

    public void resetGame(){
        plays = new HashMap<>();
        isPlayer1Turn = true;
        updateTurnIndicator();
        setUpGameTileOnClickListeners();


    }
    
    public boolean hasPlayerWon(){

        boolean didPlayerWin = false;
        AppUtil.log("player played");

        String playerKey = (isPlayer1Turn) ? PLAYER_ONE_KEY : PLAYER_TWO_KEY;
        String allPlayersPlayedTileIndex = "";

        for(String key : plays.keySet()){

            String play = plays.get(key);

            if(playerKey.equalsIgnoreCase(play)){
                allPlayersPlayedTileIndex+= key;
            }

        }

        AppUtil.log("players plays" + allPlayersPlayedTileIndex);
        if(allPlayersPlayedTileIndex.length() < 3){

            AppUtil.log("nice one, you need to play at least three times to win");
            return false;
        }
        AppUtil.log("we just got all the players plays now to check if he won");

        for(String winningCombination : winningCombinations){

            boolean combinationMatch = false;

            AppUtil.log("checking if combination "+allPlayersPlayedTileIndex+" is in  : " + winningCombination);

            int numberGottenRight = 0;

            for(int i = 0; i < allPlayersPlayedTileIndex.length(); i++){

                char playedIndex = allPlayersPlayedTileIndex.charAt(i);


                AppUtil.log("checking if played index : " + playedIndex + " is in the combination " +
                 winningCombination);

                if(winningCombination.contains(String.valueOf(playedIndex))){
                    numberGottenRight ++;
                    AppUtil.log("it is contained ");
                }else {

                    AppUtil.log("it is not contained");
                }

                AppUtil.log("number gotten right : " + numberGottenRight);
                if(numberGottenRight == 3){
                    AppUtil.log("combination matched");
                    combinationMatch = true;
                    break;
                }
            }

            if(combinationMatch){
                didPlayerWin = true;
                AppUtil.log("hooray player won");
                break;
            }


        }
        
        return didPlayerWin;
    }


    private void setUpGameTileOnClickListeners(){

        //loop through all the keys
        for(final String key : game.getGameSquaresHashMap().keySet()){

            //make sure every tile is empty
            game.getGameSquaresHashMap().get(key).setText("");

            //set up onclick listener
            final TextView tile = game.getGameSquaresHashMap().get(key);
            tile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(plays.containsKey(key)){
                        appUtil.showMessage("Tile already selected");
                        return;
                    }
                    //maximum
                    if(plays.keySet().size() <  NUMBER_POSSIBLE_PLAYS){
                        String play  = (isPlayer1Turn)? PLAYER_ONE_KEY : PLAYER_TWO_KEY;
                        tile.setText(play);
                        plays.put(key, play);
                        //change turn after playing
                        if(plays.keySet().size() == NUMBER_POSSIBLE_PLAYS){

                            appUtil.showMessage("Game has ended, nobody won");
                        }else {

                            if(hasPlayerWon()){
                                String playerWhoWon = (isPlayer1Turn)? "Player 1" : "Player 2";

                                appUtil.showMessage(playerWhoWon + " has won, Hurray");
                                //reset game
                                //TODO : please ask if player wants to play again
                                resetGame();

                            }else {

                                changeTurn();

                            }

                        }
                    }else{
                        appUtil.showMessage("Game has ended, nobody won");
                    }

                }
            });

        }
    }

    private void changeTurn(){

        isPlayer1Turn = !isPlayer1Turn;
        updateTurnIndicator();
    }

    private void updateTurnIndicator(){

        if(isPlayer1Turn){
            game.getPlayerIndicator().setText(PLAYER_1_HANDLE);
        }else game.getPlayerIndicator().setText(PLAYER_2_HANDLE);
    }
}
