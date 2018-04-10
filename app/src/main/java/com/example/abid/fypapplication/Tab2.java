//package com.example.abid.fypapplication;
//
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.ListFragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class Tab2 extends Fragment {
//    String [] headlines={"Pet Detected","Pet Detected","Pet Detected","Pet Detected","Pet Detected","Pet Detected","Pet Detected"};
//    String [] details={"Hello Sir, A pet has been detected","Hello Sir, A pet has been detected","Hello Sir, A pet has been detected","Hello Sir, A pet has been detected","Hello Sir, A pet has been detected","Hello Sir, A pet has been detected","Hello Sir, A pet has been detected"};
//    int[] IMAGES={R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c4};
//
//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager layoutManager;
//    FirebaseDatabase database;
//    DatabaseReference myRef;
//    public List<String> list;
//    int updatedlistsize=0;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootview=inflater.inflate(R.layout.tab2,container,false);
//        recyclerView=(RecyclerView) rootview.findViewById(R.id.my_recycler_view);
//
//
//
//
//
//        layoutManager = new LinearLayoutManager(this.getActivity());
////        layoutManager=new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(layoutManager);
//
//
//        Log.i("value","before firebase");
//
//
//        database= FirebaseDatabase.getInstance();
//        myRef= database.getReference("cats");
//
//
//        list=new ArrayList<>();
//        mAdapter = new MyAdapter(list);
//        recyclerView.setAdapter(mAdapter);
//
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//
//                list.removeAll(list);
//                int i=0;
//                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
//                    //getting the data object as a model which is used to send data
//                    // using RegisterServiceData Model class
//                    DataModel dataModel = snapshot.getValue(DataModel.class);
//
//                    String object=snapshot.getValue().toString();
//
//                    list.add(object);
////                    i++;
//                    Log.i("value", "List size is"+(Integer.toString(list.size())));
////                    RegisterServiceData service=snapshot.getValue(RegisterServiceData.class);
//                    //this method will shift the user camera view to the received location position
//
//                }
//                mAdapter.notifyDataSetChanged();
//                updatedlistsize=list.size();
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.i("value", "Failed to read value.", error.toException());
//            }
//        });
//
////        Log.i("value", "Now,,,,,,List size is"+(Integer.toString(list.size())));
////        List<String> input = new ArrayList<>();
////        for (int i = 0; i < 10; i++) {
////            Log.i("list",Integer.toString(input.size()));
////            input.add("Test" + i);
////            Log.i("value",arrayList.get(i));
////            input.add(arrayList.get(i));
////        }// define an adapter
//
////        CustomAdapter customAdapter=new CustomAdapter();
////        listView.setAdapter(customAdapter);
////
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                String name= headlines[i];
////                String detail=details[i];
////                int image=IMAGES[i];
////                Toast.makeText(getActivity(), headlines[i],Toast.LENGTH_SHORT).show();
////
////
////            }
////        });
//
//
//        return rootview;
//    }
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
////        View rootview=inflater.inflate(R.layout.tab2,container,false);
////        final ListView listView=(ListView) rootview.findViewById(R.id.tab2list);
////
////        Tab2.CustomAdapter customAdapter=new Tab2.CustomAdapter();
////        listView.setAdapter(customAdapter);
////
////        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                String name=headlines[i];
////                String detail=details[i];
////                int image=IMAGES[i];
////
////                Toast.makeText(getActivity(),headlines[i],Toast.LENGTH_SHORT).show();
////
////
////            }
////        });
////
////
////        return rootview;
////    }
////    class CustomAdapter extends BaseAdapter {
////
////        @Override
////        public int getCount() {
////            return IMAGES.length;
////        }
////
////        @Override
////        public Object getItem(int i) {
////            return null;
////        }
////
////        @Override
////        public long getItemId(int i) {
////            return 0;
////        }
////
////        @Override
////        public View getView(int i, View view, ViewGroup viewGroup) {
////            view=getLayoutInflater().inflate(R.layout.custom_layout,null);
////
////            ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
////            TextView name=(TextView) view.findViewById(R.id.name);
////            TextView detail=(TextView) view.findViewById(R.id.detail);
////            TextView time=(TextView) view.findViewById(R.id.time);
////            TextView date=(TextView) view.findViewById(R.id.date);
////
////            imageView.setImageResource(IMAGES[i]);
////            name.setText(headlines[i]);
////            detail.setText(details[i]);
////
////            Date datel=new Date();
////            int hour=datel.getHours();
////            int minute=datel.getMinutes();
////            String currentTime=hour+" : "+minute;
////            time.setText(currentTime);
////            int day=datel.getDay();
////            int month=datel.getMonth()+1;
////            int year=datel.getYear()%100;
////            String currentDate=day+"/"+month+"/"+year;
////            date.setText(currentDate);
////
////            return view;
////        }
////    }
//}
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

public class Tab2 extends Fragment {
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
        DatabaseDataReference = database.getReference("cats");

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
//                    DataModel dataModel  = snapshot.getValue(DataModel.class);
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
