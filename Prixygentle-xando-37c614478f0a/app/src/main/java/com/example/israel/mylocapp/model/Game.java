package com.example.israel.mylocapp.model;

import android.content.Context;
import android.widget.TextView;

import java.util.HashMap;

import lombok.Data;

/**
 * @author .: Chukwudum Ekwueme
 * @email ..: chidumekwueme@gmail.com, chukwudum.ekwueme@cwlgroup.com
 * @created : 7/27/17 3:57 PM
 */

@Data
public class Game {

    private Context context;

    public Game(){

    }
    private TextView playerIndicator;

    private HashMap<String, TextView> gameSquaresHashMap;




    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{

        private Game game;

        public Builder(){
            game = new Game();
            game.setGameSquaresHashMap(new HashMap<String, TextView>());
        }

        public Builder withSquare1(TextView square1){

            game.getGameSquaresHashMap().put("0", square1);

            return this;
        }

        public Builder withPlayerIndicator(TextView playerIndicator){

            game.setPlayerIndicator(playerIndicator);
            return this;
        }
        public Builder withSquare9(TextView square9){

            game.getGameSquaresHashMap().put("8", square9);
            return this;
        }
        public Builder withSquare8(TextView square8){

            game.getGameSquaresHashMap().put("7", square8);
            return this;
        }

        public Builder withSquare7(TextView square7){

            game.getGameSquaresHashMap().put("6", square7);
            return this;
        }

        public Builder withSquare6(TextView square6){

            game.getGameSquaresHashMap().put("5", square6);
            return this;
        }

        public Builder withSquare5(TextView square5){

            game.getGameSquaresHashMap().put("4", square5);
            return this;
        }

        public Builder withSquare4(TextView square4){

            game.getGameSquaresHashMap().put("3", square4);

            return this;
        }

        public Builder withSquare3(TextView square3){

            game.getGameSquaresHashMap().put("2", square3);
            return this;
        }

        public Builder withSquare2(TextView square2){

            game.getGameSquaresHashMap().put("1", square2);
            return this;
        }

        public Builder withContext(Context context){

            game.setContext(context);
            return this;
        }


        public Game build(){

            return this.game;
        }

    }
}
