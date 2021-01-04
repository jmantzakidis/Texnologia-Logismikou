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

public class ViewScheduleShiftAdapter extends RecyclerView.Adapter<ViewScheduleShiftAdapter.ViewHolder> {

    private ArrayList<UserData> data;
    private ArrayList<Shift> shifts;
    private ArrayList<WorkDay> days;
    private int p;

    public ViewScheduleShiftAdapter(ArrayList<Shift> shifts,ArrayList<WorkDay> days,int p,ArrayList<UserData> data) {
        this.shifts = shifts;
        this.days = days;
        this.p = p;
        this.data = data;
    }

    @Override
    public ViewScheduleShiftAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View shiftView = inflater.inflate(R.layout.schedule_shift_layout, parent, false);

        ViewScheduleShiftAdapter.ViewHolder viewHolder = new ViewScheduleShiftAdapter.ViewHolder(shiftView);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewScheduleShiftAdapter.ViewHolder holder, int position) {

        UserData userData = data.get(position);
        Shift shift = shifts.get(position);
        holder.tv_shift.setText(shift.getShift());
        if(shift.getEmployeeName().equals("")) {
            holder.tv_employee.setText("Open");
            holder.tv_Specialty.setVisibility(View.INVISIBLE);
        }else
            holder.tv_employee.setText(shift.getEmployeeName());
            holder.tv_Specialty.setText(userData.specialty);

    }

    @Override
    public int getItemCount() {
        return shifts.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView tv_shift,tv_employee,tv_Specialty;
        public Button bt_apply;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_shift = itemView.findViewById(R.id.tv_shift);
            tv_employee = itemView.findViewById(R.id.tv_employee);
            tv_Specialty = itemView.findViewById(R.id.tv_Specialty);
//            bt_apply = itemView.findViewById(R.id.applyShift);

        }
    }
}

