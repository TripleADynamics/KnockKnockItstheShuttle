package com.example.andre.knockknockitstheshuttle;

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
    public void goToChoicesScreen(View v)
    {
        Button yourButton = (Button) findViewById(R.id.user);

        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(FirstScreen.this, FinalTime.class));
            }
        });
    }
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
