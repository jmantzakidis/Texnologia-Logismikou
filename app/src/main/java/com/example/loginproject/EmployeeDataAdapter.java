package com.example.loginproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.ViewHolder> {
    private ArrayList<UserData> data;
    public EmployeeDataAdapter(ArrayList<UserData> data) {
        this.data = data;
    }
    @Override
    public EmployeeDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View userDataView = inflater.inflate(R.layout.activity_view_employees, parent, false);

        EmployeeDataAdapter.ViewHolder viewHolder = new EmployeeDataAdapter.ViewHolder(userDataView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        UserData userData = data.get(position);
        TextView textViewName1 = holder.tv_name;
        textViewName1.setText(userData.name);
        TextView textViewSurname1 = holder.tv_surname;
        textViewSurname1.setText(userData.surName);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_name,tv_surname;

        public ViewHolder(View itemView) {

            super(itemView);
            tv_name = itemView.findViewById(R.id.EmployeeDataName);
            tv_surname = itemView.findViewById(R.id.EmployeeDataSurName);
        }
    }
}