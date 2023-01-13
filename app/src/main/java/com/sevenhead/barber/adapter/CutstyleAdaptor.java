package com.sevenhead.barber.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.sevenhead.barber.Domain.CutstyleDomain;
import com.sevenhead.barber.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CutstyleAdaptor extends RecyclerView.Adapter<CutstyleAdaptor.Viewholder> {
    ArrayList<CutstyleDomain> cutstyleDomains;

    public CutstyleAdaptor(ArrayList<CutstyleDomain> cutstyleDomains) {
        this.cutstyleDomains = cutstyleDomains;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cat,parent,false);
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.cutName.setText(cutstyleDomains.get(position).getTitle());
        String picUrl="";
        switch (position){
            case 0:{
                picUrl="ic_m1";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.promo_background));
                break;
            }
            case 1:{
                picUrl="ic_m2";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.promo_background));
                break;
            }
            case 2:{
                picUrl="ic_m9";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.promo_background));
                break;
            }
            case 3:{
                picUrl="ic_m10";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.promo_background));
                break;
            }
            case 4:{
                picUrl="ic_m5";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.promo_background));
                break;
            }
            case 5:{
                picUrl="ic_m6";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.promo_background));
                break;
            }
            case 6:{
                picUrl="ic_m7";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.promo_background));
                break;
            }
            case 7:{
                picUrl="ic_m8";
                holder.mainlayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.promo_background));
                break;
            }
        }
        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.cutpic);
    }

    @Override
    public int getItemCount() {
        return cutstyleDomains.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder{
        TextView cutName;
        ImageView cutpic;
        ConstraintLayout mainlayout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cutName=itemView.findViewById(R.id.cutName);
            cutpic=itemView.findViewById(R.id.cutPic);
            mainlayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
