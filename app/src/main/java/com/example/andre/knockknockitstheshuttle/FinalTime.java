package com.example.andre.knockknockitstheshuttle;
/**
 * methods learned from https://www.tutorialspoint.com/firebase/firebase_read_data.htm
 * This class retrieves the data for the times from firebase and displays it
 */



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("FinalTime", "Failed to read value.", error.toException());
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


