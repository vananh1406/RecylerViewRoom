package com.example.recylerviewroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List<User>list;
    public void setData(List<User> list){
        this.list= list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = list.get(position);
        if(user == null){
            return;
        }
        holder.tvName.setText(user.getName());
        holder.tvAge.setText(user.getAge());
        holder.tvPhone.setText(user.getPhone());
        holder.tvMail.setText(user.getMail());
        holder.tvAddress.setText(user.getAddress());

    }

    @Override
    public int getItemCount() {
        if(list !=null){
            return list.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvAge;
        private TextView tvPhone;
        private TextView tvMail;
        private TextView tvAddress;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName= itemView.findViewById(R.id.tvname);
            tvAge= itemView.findViewById(R.id.tvold);
            tvPhone= itemView.findViewById(R.id.tvphone);
            tvMail= itemView.findViewById(R.id.tvmail);
            tvAddress= itemView.findViewById(R.id.tvaddress);
        }
    }
}
