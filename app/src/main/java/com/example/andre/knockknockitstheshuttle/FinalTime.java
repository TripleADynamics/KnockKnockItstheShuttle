package com.example.andre.knockknockitstheshuttle;
/**
 * methods learned from https://www.tutorialspoint.com/firebase/firebase_read_data.htm
 * This class retrieves the data for the times from firebase and displays it
 */



import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FinalTime extends AppCompatActivity {

    private ListView myListView;
    private ArrayList<String>ShuttleTimes = new ArrayList<>();
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_time);

                // Read from the database
                //FirebaseApp.initializeApp(this);
                //final Controller aController= (Controller) getApplicationContext();
                database = FirebaseDatabase.getInstance();
                myRef = database.getReference();
                arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ShuttleTimes);
                myListView = (ListView) findViewById(R.id.ShuttleList);
                myListView.setAdapter(arrayAdapter);
                Log.d("FinalTime", "In FinalTime.java file");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("FinalTime", "Entered onDataChangeMethod");
                showData(dataSnapshot);
                // This method is called once with the initial value and again
                // whenever data at this location is updated.




                //String value = dataSnapshot.getValue(String.class);
                //Log.d("FinalTime","Value is: " + value);
                //TextView FinalTimeText= findViewById(R.id.FinalTimeText);
                //FinalTimeText.setText("FInal times"+ value);
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("FinalTime", "Failed to read value.", error.toException());
            }


        });

                myRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        /*Log.d("FinalTime", "Entered OnChildAddedListener");
                        String EstTime = dataSnapshot.getValue(String.class);
                        ShuttleTimes.add(EstTime);
                        arrayAdapter.notifyDataSetChanged();*/
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
//Retrieves the data from firebase and displays it onto a user interface
    private void showData(DataSnapshot dataSnapshot) {
        TimeChecker t;
        ShuttleTimes.clear();
        for(DataSnapshot timesnapshot: dataSnapshot.getChildren()){
            t = timesnapshot.getValue(TimeChecker.class);

            t.setLoc1(timesnapshot.getValue(TimeChecker.class).getLoc1());
            t.setLoc2(timesnapshot.getValue(TimeChecker.class).getLoc2());
            t.setLoc3(timesnapshot.getValue(TimeChecker.class).getLoc3());
            t.setLoc4(timesnapshot.getValue(TimeChecker.class).getLoc4());
            t.setLoc5(timesnapshot.getValue(TimeChecker.class).getLoc5());
            t.setLoc6(timesnapshot.getValue(TimeChecker.class).getLoc6());
            t.setLoc7(timesnapshot.getValue(TimeChecker.class).getLoc7());

            ShuttleTimes.add(t.getLoc1());
            ShuttleTimes.add(t.getLoc2());
            ShuttleTimes.add(t.getLoc3());
            ShuttleTimes.add(t.getLoc4());
            ShuttleTimes.add(t.getLoc5());
            ShuttleTimes.add(t.getLoc6());
            ShuttleTimes.add(t.getLoc7());
            arrayAdapter.notifyDataSetChanged();
        }

    }

}


