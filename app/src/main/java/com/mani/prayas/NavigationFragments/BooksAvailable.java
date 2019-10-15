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
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mani.prayas.Adapter.RecyclerViewAdapterBooks;
import com.mani.prayas.MainActivity;
import com.mani.prayas.R;
import com.mani.prayas.Support.AddBooks;

import java.util.ArrayList;
import java.util.Map;

public class BooksAvailable extends Fragment {
    RecyclerView recyclerView;
    Spinner state_search,city_search,exam_type_search;
    ArrayAdapter stat,cit,exam;

    LinearLayoutManager linearLayoutManager;
    RecyclerViewAdapterBooks recyclerViewAdapterBooks;

    private FirebaseDatabase database ;
    private DatabaseReference myRef;

    public BooksAvailable() {

    }
    public void setCity()
    {
        state_search.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                { case 0:
                    cit=ArrayAdapter.createFromResource(getContext(),R.array.selectCity,android.R.layout.simple_spinner_item);
                    cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    city_search.setAdapter(cit);
                    break;

                    case 1:
                        cit=ArrayAdapter.createFromResource(getContext(),R.array.andhra_pradesh_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;


                    case 2:
                        cit=ArrayAdapter.createFromResource(getContext(),R.array.arunachal_pradesh_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 3:
                        cit=ArrayAdapter.createFromResource(getContext(),R.array.assam_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 4:
                        cit=ArrayAdapter.createFromResource(getContext(),R.array.Bihar,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 5:
                        cit=ArrayAdapter.createFromResource(getContext(),R.array.Chhatisgarh,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 6: cit=ArrayAdapter.createFromResource(getContext(),R.array.goa_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 7: cit=ArrayAdapter.createFromResource(getContext(),R.array.gujarat_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 8: cit=ArrayAdapter.createFromResource(getContext(),R.array.haryana_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 9: cit=ArrayAdapter.createFromResource(getContext(),R.array.himachal_pradesh_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 10: cit=ArrayAdapter.createFromResource(getContext(),R.array.jammu_and_kashmir_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 11: cit=ArrayAdapter.createFromResource(getContext(),R.array.jharkhand_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 12: cit=ArrayAdapter.createFromResource(getContext(),R.array.karnataka_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 13: cit=ArrayAdapter.createFromResource(getContext(),R.array.kerala_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;

                    case 14: cit=ArrayAdapter.createFromResource(getContext(),R.array.madhya_pradesh_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 15: cit=ArrayAdapter.createFromResource(getContext(),R.array.maharashtra_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 16: cit=ArrayAdapter.createFromResource(getContext(),R.array.manipur_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 17: cit=ArrayAdapter.createFromResource(getContext(),R.array.meghalaya_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 18: cit=ArrayAdapter.createFromResource(getContext(),R.array.mizoram_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 19: cit=ArrayAdapter.createFromResource(getContext(),R.array.nagaland_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 20: cit=ArrayAdapter.createFromResource(getContext(),R.array.odisha_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 21: cit=ArrayAdapter.createFromResource(getContext(),R.array.punjab_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 22: cit=ArrayAdapter.createFromResource(getContext(),R.array.rajasthan_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 23: cit=ArrayAdapter.createFromResource(getContext(),R.array.sikkim_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 24: cit=ArrayAdapter.createFromResource(getContext(),R.array.tamil_nadu_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 25:cit=ArrayAdapter.createFromResource(getContext(),R.array.telangana_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 26:cit=ArrayAdapter.createFromResource(getContext(),R.array.tripura_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 27:cit=ArrayAdapter.createFromResource(getContext(),R.array.uttar_pradesh_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 28:cit=ArrayAdapter.createFromResource(getContext(),R.array.uttrakhand_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;
                    case 29:cit=ArrayAdapter.createFromResource(getContext(),R.array.west_bengal_cities,android.R.layout.simple_spinner_item);
                        cit.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        city_search.setAdapter(cit);
                        break;




                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {

                View vh = inflater.inflate(R.layout.fragment_books_available, container, false);
                final ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();

                city_search = vh.findViewById(R.id.citySearch);
                state_search = vh.findViewById(R.id.stateSearch);
                exam_type_search=vh.findViewById(R.id.exam_type_search);
                stat = ArrayAdapter.createFromResource(getContext(), R.array.state_list, android.R.layout.simple_spinner_item);
                stat.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                state_search.setAdapter(stat);
                exam=ArrayAdapter.createFromResource(getContext(),R.array.exam_type,android.R.layout.simple_spinner_item);
                exam.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                exam_type_search.setAdapter(exam);
                setCity();
                recyclerView = vh.findViewById(R.id.available_book_list);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                final RecyclerViewAdapterBooks adapterBooks = new RecyclerViewAdapterBooks(list, getContext());
                recyclerView.setAdapter(adapterBooks);


                database = FirebaseDatabase.getInstance();
                myRef = database.getReference("Jamshedpur");

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        list.clear();
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            list.add((Map<String, String>) dataSnapshot1.getValue());
                            Log.d("ak47", "onDataChange: " + dataSnapshot.getKey() + "->" + dataSnapshot.getValue());
                            dataSnapshot.getKey();
                        }
                        Log.e("ak47", list.get(0).get("Title") + "onDataChange: " + list.size());
                        adapterBooks.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



                return vh;
            }

        }





