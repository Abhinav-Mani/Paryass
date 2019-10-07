package com.mani.prayas.Support;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.mani.prayas.R;

public class AddBooks extends AppCompatActivity {
    Spinner exam_type;
    ArrayAdapter exam;
    ImageView book_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mani.prayas.R.layout.activity_add_books);
        init();
        exam=ArrayAdapter.createFromResource(this,R.array.exam_type,android.R.layout.simple_spinner_item);
        exam.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        exam_type.setAdapter(exam);
    }
    public void init()
    {
        exam_type=findViewById(R.id.exam_type);
        book_photo=findViewById(R.id.book_photo);


    }
    public void capture(View view) {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap b = (Bitmap) data.getExtras().get("data");
        book_photo.setImageBitmap(b);
    }
}
