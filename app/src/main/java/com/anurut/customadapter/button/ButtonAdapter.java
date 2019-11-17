package com.anurut.customadapter.button;


import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.anurut.customadapter.R;

import java.util.ArrayList;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.MyListViewHolder>{

    private ArrayList<ButtonData> buttonData;
    private Activity activity;

    public ButtonAdapter(ArrayList<ButtonData> buttonData, Activity activity){

        this.buttonData = buttonData;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        View listItem = layoutInflater.inflate(R.layout.mqtt_button_layout,parent,false);
        MyListViewHolder viewHolder = new MyListViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyListViewHolder holder, int position) {

        final ButtonData mybuttonData = buttonData.get(position);
        holder.textView.setText(mybuttonData.getButtonName());
        holder.imageButton.setImageResource(mybuttonData.getButtonImgId());
        holder.imageButton.setTag(mybuttonData.getButtonName());
        holder.textView.setTag(mybuttonData.getButtonName());
        holder.constraintLayout.setTag(mybuttonData.getButtonName());
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("On Click",v.getTag().toString());

            }
        });
    }

    @Override
    public int getItemCount() {
        return buttonData.size();
    }

    class MyListViewHolder extends ViewHolder {

        public ImageButton imageButton;
        public TextView textView;
        public androidx.constraintlayout.widget.ConstraintLayout constraintLayout;

        public MyListViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageButton = itemView.findViewById(R.id.button);
            this.textView = itemView.findViewById(R.id.textView);
            this.constraintLayout = itemView.findViewById(R.id.imageButtonConstraint);
        }
    }
}