package com.mani.prayas.Support;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mani.prayas.R;

import java.util.Calendar;

public class AddBooks extends AppCompatActivity {
    Spinner exam_type,rating,subject;
    ArrayAdapter exam,rate,sub;
    ImageView book_photo,img1,img2,img3;
    TextView publish;

    DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mani.prayas.R.layout.activity_add_books);
        init();
        exam=ArrayAdapter.createFromResource(this,R.array.exam_type,android.R.layout.simple_spinner_item);
        exam.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        exam_type.setAdapter(exam);
        rate=ArrayAdapter.createFromResource(this,R.array.rating,android.R.layout.simple_spinner_item);
        rate.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        rating.setAdapter(rate);
        exam_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                { case 0:
                    sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.select,android.R.layout.simple_spinner_item);
                    sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    subject.setAdapter(sub);
                    break;

                    case 1:
                        sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.jee_mains_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 2:
                        sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.jee_advanced_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 3:
                        sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.gate_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 4:
                        sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.neet_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 5:
                        sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.aiims_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 6: sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.icse_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 7:sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.isc_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 8:sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.cbse_10_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 9:sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.cbse_12_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 10:sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.cat_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 11:sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.xat_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 12:sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.upsc_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 13:sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.nda_subjects,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;
                    case 14:sub=ArrayAdapter.createFromResource(AddBooks.this,R.array.empty,android.R.layout.simple_spinner_item);
                        sub.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                        subject.setAdapter(sub);
                        break;


                }
                dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        // Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                        String date = month + "/" + year;
                        publish.setText(date);
                    }
                };
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void init()
    {
        exam_type=findViewById(R.id.exam_type);
        book_photo=findViewById(R.id.book_photo);
        rating=findViewById(R.id.reuse_rating);
        subject=findViewById(R.id.subjectNames);
        publish=findViewById(R.id.publish_date);
        img1=findViewById(R.id.image_one);
        img2=findViewById(R.id.image_two);
        img3=findViewById(R.id.image_three);

    }
    public void date(View view)
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                dateSetListener,
                year,month,day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));
        dialog.show();

    }


    public void capture(View view) {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivityForResult(intent,0);
    }
    public void image1(View view) {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivityForResult(intent,1);
    }
    public void image2(View view) {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivityForResult(intent,2);
    }
    public void image3(View view) {


        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null)
            startActivityForResult(intent,3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap b = (Bitmap) data.getExtras().get("data");
        switch (requestCode){
            case 0: book_photo.setImageBitmap(b);
                break;
            case 1:img1.setImageBitmap(b);
                break;
            case 2:
                img2.setImageBitmap(b);
                break;
            case 3:
                img3.setImageBitmap(b);
                break;
        }

    }
}
