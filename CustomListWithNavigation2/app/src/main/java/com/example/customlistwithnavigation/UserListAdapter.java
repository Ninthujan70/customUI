package com.example.customlistwithnavigation;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customlistwithnavigation.models.Person;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Person> list;

    public UserListAdapter(ArrayList<Person> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new ItemPersonOneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person_list, parent, false));
        } else if (viewType == 1) {
            return new ItemPersonTwoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person_two_list, parent, false));
        } else {
            return new ItemPersonOneViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person_list, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemPersonTwoViewHolder) {
            ((ItemPersonTwoViewHolder) holder).nameTwo.setText(list.get(position).getName());
            ((ItemPersonTwoViewHolder) holder).phoneTwo.setText("Mobile:" + list.get(position).getPhoneList().getMobile());
            ((ItemPersonTwoViewHolder) holder).songTwo.setText(list.get(position).getSongPlaylist().get(0));

            if (Integer.parseInt(list.get(position).getId()) % 4 == 0) {
                ((ItemPersonTwoViewHolder) holder).iconTwo.setImageResource(R.drawable.baseline_data_object_24);
            } else if (Integer.parseInt(list.get(position).getId()) % 4 == 1) {
                ((ItemPersonTwoViewHolder) holder).iconTwo.setImageResource(R.drawable.baseline_image_24);
            } else if (Integer.parseInt(list.get(position).getId()) % 4 == 2) {
                ((ItemPersonTwoViewHolder) holder).iconTwo.setImageResource(R.drawable.baseline_person_24);
            } else if (Integer.parseInt(list.get(position).getId()) % 4 == 3) {
                ((ItemPersonTwoViewHolder) holder).iconTwo.setImageResource(R.drawable.baseline_home_24);
            }
        } else if (holder instanceof ItemPersonOneViewHolder) {
            ((ItemPersonOneViewHolder) holder).nameOne.setText(list.get(position).getName());
            ((ItemPersonOneViewHolder) holder).phoneOne.setText("Home:" + list.get(position).getPhoneList().getHome());
            ((ItemPersonOneViewHolder) holder).songOne.setText(list.get(position).getSongPlaylist().get(0));
            if (Integer.parseInt(list.get(position).getId()) % 4 == 0) {
                ((ItemPersonOneViewHolder) holder).iconOne.setImageResource(R.drawable.baseline_data_object_24);
            } else if (Integer.parseInt(list.get(position).getId()) % 4 == 1) {
                ((ItemPersonOneViewHolder) holder).iconOne.setImageResource(R.drawable.baseline_image_24);
            } else if (Integer.parseInt(list.get(position).getId()) % 4 == 2) {
                ((ItemPersonOneViewHolder) holder).iconOne.setImageResource(R.drawable.baseline_person_24);
            } else if (Integer.parseInt(list.get(position).getId()) % 4 == 3) {
                ((ItemPersonOneViewHolder) holder).iconOne.setImageResource(R.drawable.baseline_home_24);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    class ItemPersonOneViewHolder extends RecyclerView.ViewHolder {
        TextView nameOne, phoneOne, songOne;
        ImageView iconOne;

        public ItemPersonOneViewHolder(@NonNull View itemView) {
            super(itemView);

            nameOne = itemView.findViewById(R.id.tv_nameTwo);
            phoneOne = itemView.findViewById(R.id.tv_phoneTwo);
            songOne = itemView.findViewById(R.id.tv_best_songTwo);
            iconOne = itemView.findViewById(R.id.iv_iconTwo);
        }
    }

    class ItemPersonTwoViewHolder extends RecyclerView.ViewHolder {
        TextView nameTwo, phoneTwo, songTwo;
        ImageView iconTwo;

        public ItemPersonTwoViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTwo = itemView.findViewById(R.id.tv_name);
            phoneTwo = itemView.findViewById(R.id.tv_phone);
            songTwo = itemView.findViewById(R.id.tv_best_song);
            iconTwo = itemView.findViewById(R.id.iv_icon);
        }
    }


}
