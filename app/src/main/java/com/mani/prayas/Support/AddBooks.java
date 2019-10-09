package com.mani.prayas.Support;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.mani.prayas.MainActivity;
import com.mani.prayas.R;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class AddBooks extends AppCompatActivity {
    Spinner exam_type,rating,subject;
    ArrayAdapter exam,rate,sub;
    ImageView book_photo,img1,img2,img3;
    TextView publish,exam_error,sub_error,reuse_error,radio_error;
    TextInputEditText name,author;
    TextInputLayout name_layout,author_layout;
    RadioButton donate,sell;
    CheckBox privacy;
    private int flag=0;
    FirebaseAuth auth;
    private String verificationCode;



    OnVerificationStateChangedCallbacks mCallbacks;


    private Camera mCamera;
    ExpandableTextView expandableTextView,expandableTextView2,expandableTextView3;
    DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mani.prayas.R.layout.activity_add_books);
       // StartFirebaseLogin();
        init();
        expand();
        spinnerExamAndRating();
        setSubjects();
        dateChange();

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
        expandableTextView=findViewById(R.id.reuse);
        expandableTextView2=findViewById(R.id.pics);
        expandableTextView3=findViewById(R.id.privacy);
        name=findViewById(R.id.book_name);
        author=findViewById(R.id.author_name);
        name_layout=findViewById(R.id.book_name_layout);
        author_layout=findViewById((R.id.author_name_layout));
        exam_error=findViewById(R.id.exam_error);
        sub_error=findViewById(R.id.sub_error);
        reuse_error=findViewById(R.id.reuse_error);
        donate=findViewById(R.id.donate);
        sell=findViewById(R.id.sell);
        radio_error=findViewById(R.id.radio_error);
        privacy=findViewById(R.id.privacy_policy);
    }
    public void spinnerExamAndRating()
    {
        exam=ArrayAdapter.createFromResource(this,R.array.exam_type,android.R.layout.simple_spinner_item);
        exam.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        exam_type.setAdapter(exam);
        rate=ArrayAdapter.createFromResource(this,R.array.rating,android.R.layout.simple_spinner_item);
        rate.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        rating.setAdapter(rate);
    }
    public void setSubjects()
    {
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

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void expand()
    {
        String reusee="Tap to know more:The reusability scale is the measure of state of book.Rate your product on a scale of 1-10 sighting its present condition.It should be filled with honesty.A new book has a rating of 10 while a book more than 10 years old has a scale of 1";
        expandableTextView.setText(reusee);
        String pic="Tap to know more:Please add three photos of different pages of the book.These photos will be accessible by the customers.";
        expandableTextView2.setText(pic);
        String priv="We have access to your email,your location,your search history.This is in order to provide you a better user experience and more features.We do not share these critical informations specifically with any third party without your permissions but we use these data for a better app experience.You allow us to have access to these data.";
        expandableTextView3.setText(priv);
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
    public void dateChange()
    {
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = month + "/" + year;
                publish.setText(date);
            }
        };
    }





    public void validate()
    {
        if(name.getText().toString().isEmpty())
        {
            name_layout.setError("Name of book cannot be left blank");}
        else
            name_layout.setError(null);
        if(author.getText().toString().isEmpty())
            author_layout.setError("Author of book cannot be left blank");
        else
            author_layout.setError(null);
        if(exam_type.getSelectedItem().toString().equals("SELECT EXAM")) {
            // exam_error.setTextColor(Color.RED);
            exam_error.setError("Exam type not selected");
        }
        else
            exam_error.setError(null);
        if(subject.getSelectedItem().toString().equals("SELECT SUBJECT")) {
            // sub_error.setTextColor(Color.RED);
            sub_error.setError("Exam type not selected");
        }
        else
            sub_error.setError(null);
        if(rating.getSelectedItem().toString().equals("REUSABILITY RATING")) {
            // reuse_error.setTextColor(Color.RED);
            reuse_error.setError("Exam type not selected");
        }
        else
            reuse_error.setError(null);
        if(donate.isChecked()==false&&sell.isChecked()==false)
            radio_error.setError("sels");
        else
            radio_error.setError(null);
        LinearLayout add=findViewById(R.id.add_book);


        if(flag==0)
        {
            Snackbar snackbar=Snackbar.make(add, "Add the book cover photo", Snackbar.LENGTH_LONG);
            View snak=snackbar.getView();
            snak.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.blue));
            snackbar.show();
        }

    }
    public void submit(View view)
    {
        validate();






    }


    public void capture(View view) {

        flag=1;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(intent,0);

        }


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
        Bitmap b;
        if(data!=null) {
            b = (Bitmap) data.getExtras().get("data");
            switch (requestCode) {
                case 0:
                    book_photo.setImageBitmap(b);
                    break;
                case 1:
                    img1.setImageBitmap(b);
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
}
