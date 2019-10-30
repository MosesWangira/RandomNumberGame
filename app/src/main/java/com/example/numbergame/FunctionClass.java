package com.example.numbergame;

import android.widget.TextView;

public class FunctionClass {

    /**
     * generating random number
     * */
    public static int math_random_generator(){
        double number_generated = Math.random() * 100;
        //cast random number generated to int
        int casted_number_generated = (int) number_generated;

        return casted_number_generated;
    }



}
