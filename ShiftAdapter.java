package com.example.loginproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class ShiftAdapter extends RecyclerView.Adapter<ShiftAdapter.ViewHolder> {

    private ArrayList<Shift> shifts;
    private ArrayList<WorkDay> days;
    private int p;

    public ShiftAdapter(ArrayList<Shift> shifts,ArrayList<WorkDay> days,int p) {
        this.shifts = shifts;
        this.days = days;
        this.p = p;
    }

    @Override
    public ShiftAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View shiftView = inflater.inflate(R.layout.shift_layout, parent, false);

        ShiftAdapter.ViewHolder viewHolder = new ShiftAdapter.ViewHolder(shiftView);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ShiftAdapter.ViewHolder holder, int position) {

        Shift shift = shifts.get(position);
        holder.tv_shift.setText(shift.getShift());
        if(shift.getEmployeeName().equals("")) {
            holder.tv_employee.setText("Open");
        }else
        holder.tv_employee.setText(shift.getEmployeeName());
        holder.bt_apply.setOnClickListener(v -> {
            Restrictions restriction = new Restrictions();
            if(!restriction.checkDays(p,days,days.get(p).shifts.get(position).shift))
            {
                return;
            }
            shifts.get(position).employeeName = Util.currentUser.name + " " +Util.currentUser.surName;
            days.get(p).shifts = shifts;
            DataWriter dataWriter = new DataWriter(Util.shiftsDirectory,Util.shiftsFileName);
            try {
                dataWriter.writeScheduleToJson(days);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            holder.bt_apply.setEnabled(false);
            Util.currentActivity.recreate();

        });
        if(!shift.employeeName.equals("")){
            holder.bt_apply.setEnabled(false);
        }
    }

    @Override
    public int getItemCount() {
        return shifts.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView tv_shift,tv_employee;
        public Button bt_apply;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_shift = itemView.findViewById(R.id.tv_shift);
            tv_employee = itemView.findViewById(R.id.tv_employee);
            bt_apply = itemView.findViewById(R.id.applyShift);

        }
    }
}

