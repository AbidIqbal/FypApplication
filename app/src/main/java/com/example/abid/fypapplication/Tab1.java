package com.example.abid.fypapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Tab1 extends Fragment {
    String [] headlines ={"Person Detected","Person Detected","Person Detected","Person Detected","Person Detected","Person Detected","Person Detected"};
    String [] details={"Hello Sir, A person has been detected","Hello Sir, A person has been detected","Hello Sir, A person has been detected","Hello Sir, A person has been detected","Hello Sir, A person has been detected","Hello Sir, A person has been detected","Hello Sir, A person has been detected"};
    int[] IMAGES={R.drawable.t1,R.drawable.t2,R.drawable.t3,R.drawable.t4,R.drawable.t5,R.drawable.t6,R.drawable.t4};

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    FirebaseDatabase database;
    DatabaseReference DatabaseDataReference;

    public List<String> list;
    int updatedlistsize=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.tab1,container,false);
        recyclerView=(RecyclerView) rootview.findViewById(R.id.my_recycler_view);


//        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
//                .setSmallIcon(R.drawable.notification_icon)
//                .setContentTitle(textTitle)
//                .setContentText(textContent)
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//


        layoutManager = new LinearLayoutManager(this.getActivity());
//        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);


        Log.i("value","before firebase");


        database= FirebaseDatabase.getInstance();
        DatabaseDataReference = database.getReference("Human");

        list=new ArrayList<>();
        mAdapter = new MyAdapter(list);
        recyclerView.setAdapter(mAdapter);



        DatabaseDataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                list.removeAll(list);
                int i=0;
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    //getting the data object as a model which is used to send data
                    // using RegisterServiceData Model class
//                    DataModel dataModel = snapshot.getValue(DataModel.class);
//
                    String object=snapshot.getValue().toString();

                    list.add(object);
//                    addNotification();
//                    i++;
                    Log.i("value", "List size is"+(Integer.toString(list.size())));
//                    RegisterServiceData service=snapshot.getValue(RegisterServiceData.class);

                }
                mAdapter.notifyDataSetChanged();
                updatedlistsize=list.size();

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.i("value", "Failed to read value.", error.toException());
            }
        });



        return rootview;
    }


}
