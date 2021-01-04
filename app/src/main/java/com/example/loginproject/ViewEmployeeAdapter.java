package com.example.loginproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;

public class ViewEmployeeAdapter extends RecyclerView.Adapter<ViewEmployeeAdapter.ViewHolder> {

    private ArrayList<UserData> data;

    public ViewEmployeeAdapter(ArrayList<UserData> data) {
        this.data = data;
    }

    @Override
    public ViewEmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View userDataView = inflater.inflate(R.layout.view_employee, parent, false);

        ViewEmployeeAdapter.ViewHolder viewHolder = new ViewEmployeeAdapter.ViewHolder(userDataView);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewEmployeeAdapter.ViewHolder holder, int position) {

        DataWriter dataWriter = new DataWriter();

        UserData userData = data.get(position);
        TextView textViewName = holder.tv_name;
        textViewName.setText(userData.name);
        TextView textViewSurname = holder.tv_surname;
        textViewSurname.setText(userData.surName);
        TextView textViewContract = holder.tv_contract;
        textViewContract.setText(" " +" "+" "+ " " +" " + userData.contract);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView tv_name,tv_surname,tv_contract;

        public ViewHolder(View itemView){

            super(itemView);

            tv_contract = itemView.findViewById(R.id.specialty);
            tv_name = itemView.findViewById(R.id.userDataName);
            tv_surname = itemView.findViewById(R.id.userDataSurname);
        }
    }

}


