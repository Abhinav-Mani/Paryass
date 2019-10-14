package com.mani.prayas.NavigationFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mani.prayas.Adapter.RecyclerViewAdapterBooks;
import com.mani.prayas.MainActivity;
import com.mani.prayas.R;

import java.util.ArrayList;
import java.util.Map;

public class BooksAvailable extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerViewAdapterBooks recyclerViewAdapterBooks;

    private FirebaseDatabase database ;
    private DatabaseReference myRef;

    public BooksAvailable() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vh= inflater.inflate(R.layout.fragment_books_available, container, false);
        final ArrayList<Map<String,String>> list=new ArrayList<Map<String,String>>();


        recyclerView=vh.findViewById(R.id.available_book_list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        final RecyclerViewAdapterBooks adapterBooks=new RecyclerViewAdapterBooks(list,getContext());
        recyclerView.setAdapter(adapterBooks);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Jamshedpur");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    list.add((Map<String, String>) dataSnapshot1.getValue());
                    Log.d("ak47", "onDataChange: "+dataSnapshot.getKey()+"->"+dataSnapshot.getValue());
                    dataSnapshot.getKey();
                }
                Log.e("ak47", list.get(0).get("Title")+"onDataChange: "+list.size() );
                adapterBooks.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return vh;
    }





}
