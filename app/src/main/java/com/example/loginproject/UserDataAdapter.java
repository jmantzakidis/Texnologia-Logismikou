package com.example.loginproject;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.ViewHolder> {

    private ArrayList<UserData> data;

    public UserDataAdapter(ArrayList<UserData> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View userDataView = inflater.inflate(R.layout.userdata_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(userDataView);
        return viewHolder;
    }
//ttes
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DataWriter dataWriter = new DataWriter();

        UserData userData = data.get(position);
        TextView textViewName = holder.tv_name;
        textViewName.setText(userData.name);
        TextView textViewSurname = holder.tv_surname;
        textViewSurname.setText(userData.surName);
        Button button = holder.bt_fire;
        button.setText("Fire");
        button.setOnClickListener(v -> {
            data.remove(position);
            try {
                dataWriter.writeToJson(data);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(data.size() == 0) {
                Intent intent = new Intent(Util.currentActivity,BossActivity.class);
                Util.currentActivity.startActivity(intent);
            }

            Util.currentActivity.recreate();

        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        public TextView tv_name,tv_surname;
        public Button bt_fire;
        public ViewHolder(View itemView){

            super(itemView);

            bt_fire = itemView.findViewById(R.id.fire);
            tv_name = itemView.findViewById(R.id.userDataName);
            tv_surname = itemView.findViewById(R.id.userDataSurname);
        }
    }


}
