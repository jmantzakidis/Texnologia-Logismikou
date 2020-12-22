package com.example.loginproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class WeekDayAdapter extends RecyclerView.Adapter<WeekDayAdapter.ViewHolder> {

    private ArrayList<WorkDay> days;

    public WeekDayAdapter(ArrayList<WorkDay> days) {
        this.days = days;
    }

    @Override
    public WeekDayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View dayView = inflater.inflate(R.layout.day_layout, parent, false);

        WeekDayAdapter.ViewHolder viewHolder = new WeekDayAdapter.ViewHolder(dayView);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(WeekDayAdapter.ViewHolder holder, int position) {


        WorkDay day = days.get(position);
        holder.tv_day.setText(day.getDay());
        holder.tv_day.setOnClickListener(v -> {
            DataParser dataParser = new DataParser();
            Util util = new Util();
            try {
                days = dataParser.parseWeekData(util.jsonLoader(Util.shiftsDirectory,Util.shiftsFileName));
                WorkDay d = days.get(position);
                Intent intent = new Intent(Util.currentActivity,ShiftActivity.class);
                intent.putParcelableArrayListExtra("shifts",d.getShifts());
                intent.putParcelableArrayListExtra("days",days);
                intent.putExtra("position",position);
                Util.currentActivity.startActivity(intent);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public int getItemCount() {
        return days.size();
    }
    public class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView tv_day;
        public ViewHolder(View itemView){
            super(itemView);
            tv_day = itemView.findViewById(R.id.day);

        }
    }
}
