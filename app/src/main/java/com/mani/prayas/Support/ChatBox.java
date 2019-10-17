package com.mani.prayas.Support;

import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mani.prayas.Adapter.RecyclerViewChatAdapter;
import com.mani.prayas.Adapter.RecyclerViewChatList;
import com.mani.prayas.DataClass.Messege;
import com.mani.prayas.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class ChatBox extends AppCompatActivity {
    private FirebaseDatabase database ;
    private DatabaseReference myRefCurrent,myRefUser2,databaseReference;
    FirebaseAuth mAuth;

    HashMap<String,String > data;
    String currentUser,user2;

    RecyclerView chatbox;
    EditText messegeComposer;
    Button send;

    ArrayList<Messege> messeges=new ArrayList<Messege>();

    RecyclerViewChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);
        Log.e("ak47","ChatBox");

        init();
        getmesseges();





    }

    private void getmesseges() {
        final ArrayList<Messege> sent=new ArrayList<Messege>();
        final ArrayList<Messege> recive=new ArrayList<Messege>();


        myRefCurrent = database.getReference().child("Communication").child(currentUser).child("Messege").child(user2);
        myRefUser2 = database.getReference().child("Communication").child(user2).child("Messege").child(currentUser);
        myRefCurrent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                sent.clear();
                messeges.clear();

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Log.e("ak47",dataSnapshot1.getValue()+" "+dataSnapshot1.getKey());
                    Messege m=new Messege((String) dataSnapshot1.getValue(),Long.valueOf(dataSnapshot1.getKey()),true);
                    sent.add(m);
                }
                messeges.addAll(sent);
                messeges.addAll(recive);
                Collections.sort(messeges);
                chatAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRefUser2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                recive.clear();
                messeges.clear();

                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Messege m=new Messege((String) dataSnapshot1.getValue(),Long.valueOf(dataSnapshot1.getKey()),false);
                    recive.add(m);
                }
                messeges.addAll(sent);
                messeges.addAll(recive);
                Collections.sort(messeges);
                chatAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void init() {



        RecyclerView recyclerView=findViewById(R.id.chatbox);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(ChatBox.this);
        linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        chatAdapter=new RecyclerViewChatAdapter(messeges);
        recyclerView.setAdapter(chatAdapter);

        Intent intent=getIntent();
        mAuth=FirebaseAuth.getInstance();
        String c=mAuth.getCurrentUser().getEmail().toString();
        currentUser=c.substring(0,c.indexOf('@'));

        chatbox=findViewById(R.id.chatbox);
        messegeComposer=findViewById(R.id.MessgeContent);
        send=findViewById(R.id.sendMessege);

        database = FirebaseDatabase.getInstance();
        databaseReference=database.getReference().child("Communication");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messege=messegeComposer.getText().toString().trim();
                long ts=(long)System.currentTimeMillis();
                databaseReference.child(currentUser).child("Messege").child(user2).child(String.valueOf(ts)).setValue(messege);
                messegeComposer.setText("");
            }
        });





        Log.e("ak47","ChatBoxinit");

        if(intent.hasExtra("Data"))
        {
            Log.e("ak47","ChatBoxi23");
            data=(HashMap<String,String >)intent.getSerializableExtra("Data");
            String owner=data.get("User");
            user2=owner;
            Log.d("ak47", "init: "+user2);
            String title=data.get("Title");
            String coveruri=data.get("Cover");
            Log.e("ak47", "init: "+data );
            if(data.get("Source").equalsIgnoreCase("0"))
            {

                Log.e("ak47","ChatBoxtry"+currentUser+"->"+owner+" "+title+" "+coveruri);
                user2=owner;
                databaseReference.child(currentUser).child("Contacts").child(owner).child(title).setValue(coveruri);
                databaseReference.child(owner).child("Contacts").child(currentUser).child(title).setValue(coveruri);
                Log.e("ak47","ChatBoxsucess");
            }
        }
    }
}
