package com.example.cinfood.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cinfood.Model.User;
import com.example.cinfood.R;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, List<User> objects){super(context, 0,objects);}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
       User user = getItem(position);
       if (convertView== null){
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_editprofile,parent,false);
       }
       return convertView;
    }


}
