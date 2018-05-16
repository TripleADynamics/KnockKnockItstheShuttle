package com.example.andre.knockknockitstheshuttle;
//This screen gives the user the choice to be either a user or a driver

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstScreen extends AppCompatActivity {


    int y= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
    }
    //This method directs the user to the screen where the estimated times to the shuttle are all displayed
    public void goToChoicesScreen(View v)
    {
        Button yourButton = (Button) findViewById(R.id.user);

        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(FirstScreen.this, FinalTime.class));
            }
        });
    }
    //This method directs the user to the screen where the driver can update their location
    public void driverScreen(View v)
    {
        Button yourButton = (Button) findViewById(R.id.driver);

        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(FirstScreen.this, MainActivity.class));
            }
        });
    }

}
