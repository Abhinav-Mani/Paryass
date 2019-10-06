package com.mani.prayas.NavigationFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mani.prayas.MainActivity;
import com.mani.prayas.R;


public class YourBooks extends Fragment {

    public YourBooks() {
        // Required empty public constructor
    }




    FloatingActionButton addBooks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vh= inflater.inflate(R.layout.fragment_your_books, container, false);
        intit(vh);
        return vh;
    }

    private void intit(View vh) {
        addBooks=vh.findViewById(R.id.addbooks);
        addBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),com.mani.prayas.Support.AddBooks.class));

            }
        });
    }


}
