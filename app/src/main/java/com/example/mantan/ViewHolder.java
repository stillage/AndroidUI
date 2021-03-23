package com.example.mantan;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {


    View mView;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView= itemView;

    }

    public void  setDetails(Context ctx, String nama , String image){

        TextView Nama = mView.findViewById(R.id.text);
        ImageView mImage = mView.findViewById(R.id.image);

        Nama.setText("Date= "+nama);
        Picasso.get().load(image).into(mImage);

    }

}
