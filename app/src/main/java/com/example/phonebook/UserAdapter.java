package com.example.phonebook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phonebook.db.entity.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewholder> {

    List<User> users;
    ICallBack iCallBack;

    public UserAdapter(List<User> users,ICallBack iCallBack) {
        this.users = users;
        this.iCallBack = iCallBack;
    }

    @Override
    public UserViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new UserViewholder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewholder userViewholder, final int i) {

        userViewholder.tvName.setText(users.get(i).getName());
        userViewholder.tvPhone.setText(users.get(i).getPhoneNo());


        userViewholder.ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCallBack.call(users.get(i).getPhoneNo());
            }
        });

        userViewholder.ivSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCallBack.sms(users.get(i).getPhoneNo());
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewholder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvPhone;

        ImageView ivCall;
        ImageView ivSms;

        public UserViewholder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            ivCall = itemView.findViewById(R.id.ivCall);
            ivSms = itemView.findViewById(R.id.ivSms);
        }
    }
}
