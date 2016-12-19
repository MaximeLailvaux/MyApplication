package com.example.max.myapplication;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class AdapterEvent extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataEvent> data= Collections.emptyList();
    DataEvent current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterEvent(Context context, List<DataEvent> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.container_fish, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        DataEvent current=data.get(position);
        myHolder.textEventName.setText(current.eventName);
        myHolder.textDate.setText( current.eventDate);
        myHolder.textHour.setText( current.eventHour);
        myHolder.textPrice.setText("" + current.price + "€");
        myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));



    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textEventName;
        TextView textDate;
        TextView textHour;
        TextView textPrice;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textEventName= (TextView) itemView.findViewById(R.id.textEventName);
            textDate = (TextView) itemView.findViewById(R.id.textDate);
            textHour = (TextView) itemView.findViewById(R.id.textHour);
            textPrice = (TextView) itemView.findViewById(R.id.textPrice);
        }

    }

}
