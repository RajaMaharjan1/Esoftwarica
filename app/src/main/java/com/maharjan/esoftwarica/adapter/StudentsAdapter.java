package com.maharjan.esoftwarica.adapter;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.maharjan.esoftwarica.R;
import com.maharjan.esoftwarica.model.DataSet;


import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.Studentview> {
    Context context;
    List<DataSet> dataSetList;
     

    public StudentsAdapter(Context context, List<DataSet> dataSetList) {
        this.context = context;
        this.dataSetList = dataSetList;
    }

    @NonNull
    @Override
    public StudentsAdapter.Studentview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activitycardview,parent,false);
        return new Studentview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapter.Studentview holder, final int position) {
        DataSet dataSet= dataSetList.get(position);
        if(dataSet.getStugender().equalsIgnoreCase("male")){
            holder.imgcard.setImageResource(R.drawable.ic_male_user);
        }else{
            holder.imgcard.setImageResource(R.drawable.ic_woman_avatar);
        }
        holder.txname.setText(dataSet.getStuname());
        holder.txaddress.setText(dataSet.getStuaddress());
        holder.txage.setText(dataSet.getStuage());
        holder.txgender.setText(dataSet.getStugender());

        holder.btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSetList.remove(position);
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataSetList.size();
    }

    public static class Studentview extends RecyclerView.ViewHolder {
        ImageView imgcard;
        TextView txname,txaddress,txage,txgender;
        Button btndel;
        public Studentview(@NonNull View itemView) {
            super(itemView);
            imgcard= itemView.findViewById(R.id.cardview);
            txname= itemView.findViewById(R.id.tvName);
            txaddress= itemView.findViewById(R.id.tvAddress);
            txage= itemView.findViewById(R.id.tvAge);
            btndel= itemView.findViewById(R.id.btndel);
            txgender=itemView.findViewById(R.id.tvGender);
        }


    }
}