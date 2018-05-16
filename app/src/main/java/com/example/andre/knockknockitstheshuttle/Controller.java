package com.example.andre.knockknockitstheshuttle;
//this is a controller that stores a FinalTime object which is an arraylist of times
// This allows the elements of the list to be found in other activities

import android.app.Application;

/**
 * Created by kopyr on 5/10/2018.
 */

public class Controller extends Application {
    private FinalTime time= new FinalTime();
    public void setData(FinalTime time){
        this.time = time;
    }
    public FinalTime getData()
    {
        return time;
    }
}
