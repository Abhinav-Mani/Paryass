package com.mani.prayas.Support;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.mani.prayas.MainActivity;
import com.mani.prayas.R;

import java.util.HashMap;

public class BookDetails extends AppCompatActivity {
    HashMap<String,String> info;
    ImageView imageView;
    TextView name,author,pref;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mani.prayas.R.layout.activity_book_details2);
        imageView=findViewById(R.id.bookdetailsimage);
        name=findViewById(R.id.bookdetailsname);
        author=findViewById(R.id.bookdetailsauthor);
        pref=findViewById(R.id.bookdetailspref);
        button=findViewById(R.id.contactperson);

        if(getIntent().hasExtra("bookdetails"))
        {
            info=(HashMap<String,String>)getIntent().getSerializableExtra("bookdetails");
            Log.e("ak47", "onCreate: "+info.get("Title") );

//            Uri uri=Uri.parse(info.get("Cover"));
//            String Title=info.get("Title");
//            String Author=info.get("Author");
//            String pref=info.get("Pref");
            Log.e("ak47",name+" "+author+" "+pref);
            Glide.with(BookDetails.this).asBitmap().load(info.get("Cover")).transform(new RoundedCorners(4)).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(imageView);
            name.setText(info.get("Title"));
            author.setText(info.get("Author"));
            pref.setText(info.get("Pref"));
        }
        else
        {
            Toast.makeText(BookDetails.this,"Wromg",Toast.LENGTH_LONG).show();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookDetails.this,"Contact",Toast.LENGTH_LONG).show();
            }
        });


    }
}
