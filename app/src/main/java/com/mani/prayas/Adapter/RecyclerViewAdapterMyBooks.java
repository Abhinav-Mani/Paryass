package com.mani.prayas.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.mani.prayas.R;

import java.util.ArrayList;
import java.util.Map;

public class RecyclerViewAdapterMyBooks extends RecyclerView.Adapter<RecyclerViewAdapterMyBooks.MyViewHolder>{

    @NonNull
    ArrayList<Map<String,String>> list=new ArrayList<Map<String,String>>();
    Context context;
    public RecyclerViewAdapterMyBooks(ArrayList<Map<String,String>> list,Context context)
    {
        this.list=list;
        this.context=context;
    }

    @Override
    public RecyclerViewAdapterMyBooks.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mysingle_book,viewGroup,false);
        RecyclerViewAdapterMyBooks.MyViewHolder vh=new RecyclerViewAdapterMyBooks.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterMyBooks.MyViewHolder viewHolder, int i) {
        Log.d("ak47", "onBindViewHolder: "+list.get(i).get("Title"));
        viewHolder.bookname.setText(list.get(i).get("Title"));
        viewHolder.author.setText(list.get(i).get("Author"));
        Glide.with(context).asBitmap().load(list.get(i).get("Cover")).transform(new RoundedCorners(4)).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(viewHolder.cover);

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView author,bookname;
        ImageView cover;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            author=itemView.findViewById(R.id.mysinglebook_author);
            bookname=itemView.findViewById(R.id.mysinglebook_title);
            cover=itemView.findViewById(R.id.mysinglebook_cover);
        }
    }
}
