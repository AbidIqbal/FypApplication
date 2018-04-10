package com.example.abid.fypapplication;


import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.icu.text.DateFormat;
import android.icu.text.DateTimePatternGenerator;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abid.fypapplication.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> values;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Heading;
        public TextView Detail;
        public TextView timeview;
        public TextView date;
        public ImageView imageView;

        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            Heading = (TextView) v.findViewById(R.id.name);
            Detail = (TextView) v.findViewById(R.id.detail);
            imageView=(ImageView) v.findViewById(R.id.imageView);
            timeview=(TextView) v.findViewById(R.id.time);
            date=(TextView) v.findViewById(R.id.date);
        }
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<String> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.custom_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = values.get(position);
        String [] tokens=name.split(",");
        String [] time=tokens[0].split("=");
        String [] object=tokens[1].split("=");
        String objectname=object[1].substring(0,(object[1].length()-1));

        String timevalue=time[1];
        Long TimeStamp=Long.parseLong(timevalue);
        Date date=new Date((long)TimeStamp*1000);

        java.text.SimpleDateFormat dateFormat=new java.text.SimpleDateFormat("dd-MM-yyyy");
        java.text.SimpleDateFormat timeFormat=new java.text.SimpleDateFormat("HH:mm:ss");
        String datevalue=dateFormat.format(date);
        String timeValue=timeFormat.format(date);

        holder.timeview.setText(timeValue);
        holder.date.setText(datevalue);
        holder.Heading.setText(objectname+" Detected");
        holder.Detail.setText("Hello sir, A "+objectname+" has been detected");
        holder.Heading.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(holder.getLayoutPosition());
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}