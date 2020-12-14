package com.example.loginproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class EmptyScheduleShiftAdapter extends RecyclerView.Adapter<EmptyScheduleShiftAdapter.ViewHolder> {

    private ArrayList<Shift> shifts;
    private ArrayList<WorkDay> days;
    private int p;
    public EmptyScheduleShiftAdapter(ArrayList<Shift> shifts,ArrayList<WorkDay> days,int p) {
        this.shifts = shifts;
        this.days = days;
        this.p = p;
    }

    @Override
    public EmptyScheduleShiftAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View shiftView = inflater.inflate(R.layout.empty_schedule_shifts_adapter, parent, false);

        EmptyScheduleShiftAdapter.ViewHolder viewHolder = new EmptyScheduleShiftAdapter.ViewHolder(shiftView);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(EmptyScheduleShiftAdapter.ViewHolder holder, int position) {


        Shift shift = shifts.get(position);
        holder.tv_shift.setText(shift.getShift());
        DataWriter dataWriter = new DataWriter(Util.shiftsDirectory,Util.shiftsFileName);
        Util util = new Util();

        holder.shiftRemoval.setOnClickListener(v -> {
            shifts.remove(position);
            days.get(p).shifts = shifts;

            try {
                dataWriter.writeScheduleToJson(days);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Util.currentActivity.recreate();
        });
    }

    @Override
    public int getItemCount() {
        return shifts.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView tv_shift;
        public Button shiftRemoval;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_shift = itemView.findViewById(R.id.tv_day);
            shiftRemoval = itemView.findViewById(R.id.bt_shift_removal);
        }
    }
}
