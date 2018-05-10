package com.example.andre.knockknockitstheshuttle;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FinalTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_time);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


                // Read from the database
                DatabaseReference myRef =FirebaseDatabase.getInstance().getReference();
                FirebaseApp.initializeApp(this);
                final Controller aController= (Controller) getApplicationContext();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                myRef= database.getReference("Time");

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {


                        for(DataSnapshot timesnapshot: dataSnapshot.getChildren()){
                            FinalTime t = timesnapshot.getValue(FinalTime.class);



                        }
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.




                        String value = dataSnapshot.getValue(String.class);
                        Log.d("Main Activity","Value is: " + value);
                        TextView FinalTimeText= findViewById(R.id.FinalTimeText);
                        FinalTimeText.setText("FInal times"+ value);
                    }


                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w("Main Activity", "Failed to read value.", error.toException());
                    }

                });
            }

    }


