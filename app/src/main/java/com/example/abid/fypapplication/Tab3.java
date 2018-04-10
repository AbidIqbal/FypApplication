package com.example.abid.fypapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Tab3 extends Fragment {
    String [] headlines={"Pet Detected","Person Detected","Pet Detected","Person Detected","Pet Detected","Pet Detected","Person Detected",};
    String [] details={"Hello Sir, A pet has been detected","Hello Sir, A person has been detected","Hello Sir, A pet has been detected","Hello Sir, A person has been detected","Hello Sir, A pet has been detected","Hello Sir, A pet has been detected","Hello Sir, A person has been detected"};
    int[] IMAGES={R.drawable.c1,R.drawable.t2,R.drawable.c3,R.drawable.t4,R.drawable.c5,R.drawable.c6,R.drawable.t2};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.tab3,container,false);
        final ListView listView=(ListView) rootview.findViewById(R.id.tab3list);

        Tab3.CustomAdapter customAdapter=new Tab3.CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name=headlines[i];
                String detail=details[i];
                int image=IMAGES[i];

                Toast.makeText(getActivity(),headlines[i],Toast.LENGTH_SHORT).show();


            }
        });


        return rootview;
    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.custom_layout,null);

            ImageView imageView=(ImageView) view.findViewById(R.id.imageView);
            TextView name=(TextView) view.findViewById(R.id.name);
            TextView detail=(TextView) view.findViewById(R.id.detail);
            TextView time=(TextView) view.findViewById(R.id.time);
            TextView date=(TextView) view.findViewById(R.id.date);

            imageView.setImageResource(IMAGES[i]);
            name.setText(headlines[i]);
            detail.setText(details[i]);

            Date datel=new Date();
            int hour=datel.getHours();
            int minute=datel.getMinutes();
            String currentTime=hour+" : "+minute;
            time.setText(currentTime);
            int day=datel.getDay();
            int month=datel.getMonth()+1;
            int year=datel.getYear()%100;
            String currentDate=day+"/"+month+"/"+year;
            date.setText(currentDate);

            return view;
        }
    }
}
