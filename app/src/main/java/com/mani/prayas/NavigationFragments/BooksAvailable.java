package com.mani.prayas.NavigationFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mani.prayas.R;

public class BooksAvailable extends Fragment {

    public BooksAvailable() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vh= inflater.inflate(R.layout.fragment_books_available, container, false);

        return vh;
    }





}
