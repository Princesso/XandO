package com.example.israel.mylocapp.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.israel.mylocapp.MainActivity;

/**
 * @author .: Chukwudum Ekwueme
 * @email ..: chidumekwueme@gmail.com, chukwudum.ekwueme@cwlgroup.com
 * @created : 7/27/17 4:38 PM
 */
public class AppUtil {

    private String LOG_HANDLE = "XandO";

    private Context context;

    public AppUtil(Context context){

        this.context = context;
    }

    public void showMessage(String message){
        Toast.makeText(context, message ,
                Toast.LENGTH_LONG).show();
    }
    public static void log(String message){

        if(message != null){

            Log.d(MainActivity.LOG_HANDLE, message);

        }
    }
}
