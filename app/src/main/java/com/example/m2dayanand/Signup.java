package com.example.m2dayanand;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity {
    String s;
    String sp_gender;
    String[] gender={"--Select--","Male","Female","Other"};
    String[] workat={"--Select--","HP","Lenovo","Dell","Asus"};
    String[] hometown={"--Select--","Delhi","Mumbai","Noida","Faridabad"};
    String[]  livein={"--Select--","Delhi","Mumbai","Noida","Faridabad"};
    String[] location={"--Select--","Delhi","Mumbai","Noida","Faridabad"};
    Spinner usergender,userworkat,userhometown,userlivein,userlocation;
EditText name,username,bio,school,college,designatio,email,website,phoneno;
TextView nameerror,usernamerror,bioerror,schoolerror,collegeerror,desgintaionerror,emailerror,websiteerror,phoneerror,
    gendererror,dateofbirtherror,workaterror,hometownerror,liveinerror,locationeror,dateofbirth;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        usergender=findViewById(R.id.sp_gender);
        userworkat=findViewById(R.id.sp_work);
        userhometown=findViewById(R.id.sp_town);
        userlivein=findViewById(R.id.sp_live);
        userlocation=findViewById(R.id.sp_location);
        name=findViewById(R.id.et_name);
        submit=findViewById(R.id.btnsubmit);
        username=findViewById(R.id.et_username);
        bio=findViewById(R.id.ta_bio);
        school=findViewById(R.id.et_school);
        college=findViewById(R.id.et_college);
        designatio=findViewById(R.id.et_designation);
        email=findViewById(R.id.et_mail);
        website=findViewById(R.id.et_website);
        phoneno=findViewById(R.id.et_number);
        nameerror=findViewById(R.id.nameerror);
        usernamerror=findViewById(R.id.tv1_usernameerror);
        bioerror=findViewById(R.id.tv1_bioerror);
        schoolerror=findViewById(R.id.tv1_schoolerror);
        collegeerror=findViewById(R.id.tv1_collegeerror);
        desgintaionerror=findViewById(R.id.tv1_designationerror);
        emailerror=findViewById(R.id.tv1_mailerror);
        websiteerror=findViewById(R.id.tv1_websiteerror);
        phoneerror=findViewById(R.id.tv1_numbererror);
        gendererror=findViewById(R.id.tv1_gendererror);
        dateofbirtherror=findViewById(R.id.tv1_doberror);
        workaterror=findViewById(R.id.tv1_workerror);
        hometownerror=findViewById(R.id.tv1_townerror);
        liveinerror=findViewById(R.id.tv1_liveerror);
        locationeror=findViewById(R.id.tv1_locationerror);
        dateofbirth=findViewById(R.id.et_dob);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // gendervalidation();
                if (!name_validation()|!user_validation()|!gendervalidation()|!bio_validation()|!school_validation()
                |college_validation()|!workatvalidation()|!designation_validation()|!hometownvalidation()|!liveinvalidation()|!email_validation()
            |!website_validation()|!phone_validation()|!locationvalidation()|!dateofbirth_validation()){

                    return;
                }else {
                    Intent intent=new Intent(Signup.this,Login.class);
                    startActivity(intent);
                }
            }
        });
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,gender);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        usergender.setAdapter(arrayAdapter);
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/
        usergender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(!usergender.getSelectedItem().toString().equals("--select--")){
                    gendererror.setVisibility(View.INVISIBLE);

                }

             /*if (gender[position].matches("--Select--")){
               //  gendererror.setVisibility(View.VISIBLE);
              //   gendererror.setText("*Please select gender");
             }else {
                 Toast.makeText(getApplicationContext(),"Selected value : "+gender[position],Toast.LENGTH_LONG).show();
                 gendererror.setVisibility(View.INVISIBLE);
                 gendererror.setText("");
             }
             */

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter arrayAdapter1=new ArrayAdapter(this,android.R.layout.simple_spinner_item,workat);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userworkat.setAdapter(arrayAdapter1);
        userworkat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(userworkat.getSelectedItem().toString().equals("--select--")){
                    workaterror.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               // workaterror.setVisibility(View.INVISIBLE);
                //workaterror.setText("");
            }
        });
        ArrayAdapter arrayAdapter2=new ArrayAdapter(this,android.R.layout.simple_spinner_item,hometown);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userhometown.setAdapter(arrayAdapter2);
        userhometown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(userhometown.getSelectedItem().toString().equals("--select--")){
                    hometownerror.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter arrayAdapter3=new ArrayAdapter(this,android.R.layout.simple_spinner_item,livein);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userlivein.setAdapter(arrayAdapter3);
        userlivein.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(userlivein.getSelectedItem().toString().equals("--select--")){
                    liveinerror.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter arrayAdapter4=new ArrayAdapter(this,android.R.layout.simple_spinner_item,location);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userlocation.setAdapter(arrayAdapter4);
        userlocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(userlocation.getSelectedItem().toString().equals("--select--")){
                    locationeror.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (name.getText().toString().isEmpty()){
                    nameerror.setVisibility(View.VISIBLE);
                    nameerror.setText("*Please enter name.");
                }else {
                    nameerror.setVisibility(View.INVISIBLE);
                    nameerror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (username.getText().toString().isEmpty()){
                    usernamerror.setVisibility(View.VISIBLE);
                    usernamerror.setText("*Please enter username.");
                }else {
                    usernamerror.setVisibility(View.INVISIBLE);
                    usernamerror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        bio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (bio.getText().toString().isEmpty()){
                    bioerror.setVisibility(View.VISIBLE);
                    bioerror.setText("*Please enter bio.");
                }else {
                    bioerror.setVisibility(View.INVISIBLE);
                    bioerror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        school.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (school.getText().toString().isEmpty()){
                    schoolerror.setVisibility(View.VISIBLE);
                    schoolerror.setText("*Please enter school.");
                }else {
                    schoolerror.setVisibility(View.INVISIBLE);
                    schoolerror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        college.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (college.getText().toString().isEmpty()){
                    collegeerror.setVisibility(View.VISIBLE);
                    collegeerror.setText("*Please enter college.");
                }else {
                    collegeerror.setVisibility(View.INVISIBLE);
                    collegeerror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        designatio.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (designatio.getText().toString().isEmpty()){
                    desgintaionerror.setVisibility(View.VISIBLE);
                    desgintaionerror.setText("*Please enter designation.");
                }else {
                    desgintaionerror.setVisibility(View.INVISIBLE);
                    desgintaionerror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (email.getText().toString().isEmpty()){
                    emailerror.setVisibility(View.VISIBLE);
                    emailerror.setText("*Please enter email.");

                }
                else if (!email.getText().toString().trim().matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")){
                    emailerror.setVisibility(View.VISIBLE);
                    emailerror.setText("*Please enter email.");
                }

                else {
                    emailerror.setVisibility(View.INVISIBLE);
                    emailerror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        website.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String s1=website.getText().toString();

                if (website.getText().toString().isEmpty()){
                    websiteerror.setVisibility(View.VISIBLE);
                    websiteerror.setText("*Please enter website.");
                }
              /*  else if (website.getText().toString().matches("^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$")){
                    websiteerror.setVisibility(View.VISIBLE);
                    websiteerror.setText("*Please enter website.");
                }*/


                else {
                    websiteerror.setVisibility(View.INVISIBLE);
                    websiteerror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        phoneno.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (phoneno.getText().toString().isEmpty()){
                    phoneerror.setVisibility(View.VISIBLE);
                    phoneerror.setText("*Please enter phone_no.");
                }
                else if (!phoneno.getText().toString().trim().matches("^[6789]\\d{9}$")){
                    phoneerror.setVisibility(View.VISIBLE);
                    phoneerror.setText("*Please enter phone no.");
                }
                else {
                    phoneerror.setVisibility(View.INVISIBLE);
                    phoneerror.setText("");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
      dateofbirth.setOnClickListener(new View.OnClickListener() {
          @RequiresApi(api = Build.VERSION_CODES.N)
          @Override
          public void onClick(View v) {

                  datepicker();

          }
      });
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void datepicker(){
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int year=calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog =new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateofbirth.setText(dayOfMonth+"/"+(month+1)+"/"+year);
            }
        },year,month,day);
        calendar.set(2010,1,31);
        datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
        datePickerDialog.show();


    }

    public boolean name_validation(){
        if (name.getText().toString().isEmpty()){
            nameerror.setVisibility(View.VISIBLE);
            nameerror.setText("*Please enter name.");
            name.requestFocus();
            return false;
        }else {
            nameerror.setVisibility(View.INVISIBLE);
            nameerror.setText("");
            return true;
        }

    }
    public boolean user_validation(){
        if (username.getText().toString().isEmpty()){
            usernamerror.setVisibility(View.VISIBLE);
            usernamerror.setText("*Please enter username.");
            username.requestFocus();
            return false;
        }else {
            usernamerror.setVisibility(View.INVISIBLE);
            usernamerror.setText("");
            return true;
        }

    }
    public boolean bio_validation(){
        if (bio.getText().toString().isEmpty()){
            bioerror.setVisibility(View.VISIBLE);
            bioerror.setText("*Please enter bio.");
            bio.requestFocus();
            return false;
        }else {
            bioerror.setVisibility(View.INVISIBLE);
            bioerror.setText("");
            return true;
        }

    }
    public boolean school_validation(){
        if (school.getText().toString().isEmpty()){
            schoolerror.setVisibility(View.VISIBLE);
            schoolerror.setText("*Please enter school.");
            school.requestFocus();
            return false;
        }else {
            schoolerror.setVisibility(View.INVISIBLE);
            schoolerror.setText("");
            return true;
        }

    }
    public boolean college_validation(){
        if (college.getText().toString().isEmpty()){
            collegeerror.setVisibility(View.VISIBLE);
            collegeerror.setText("*Please enter college.");
            college.requestFocus();
            return false;
        }else {
            collegeerror.setVisibility(View.INVISIBLE);
            collegeerror.setText("");
            return true;
        }

    }
    public boolean designation_validation(){
        if (designatio.getText().toString().isEmpty()){
            desgintaionerror.setVisibility(View.VISIBLE);
            desgintaionerror.setText("*Please enter designation.");
            email.requestFocus();
            return false;
        }else {
            desgintaionerror.setVisibility(View.INVISIBLE);
            desgintaionerror.setText("");
            return true;
        }

    }
    public boolean email_validation(){
        if (email.getText().toString().isEmpty()){
            emailerror.setVisibility(View.VISIBLE);
            emailerror.setText("*Please enter email.");
            email.requestFocus();
            return false;
        }else {
            emailerror.setVisibility(View.INVISIBLE);
            emailerror.setText("");
            return true;
        }

    }
    public boolean website_validation(){
        if (website.getText().toString().isEmpty()){
            websiteerror.setVisibility(View.VISIBLE);
            websiteerror.setText("*Please enter website.");
            websiteerror.requestFocus();
            return false;
        }else {
            websiteerror.setVisibility(View.INVISIBLE);
            website.setText("");
            return true;
        }

    }

    public boolean dateofbirth_validation(){
        if (dateofbirth.getText().toString().isEmpty()){
            dateofbirtherror.setVisibility(View.VISIBLE);
            dateofbirtherror.setText("*Please select date of birth.");
            return false;
        }else {
            dateofbirtherror.setVisibility(View.INVISIBLE);
            dateofbirtherror.setText("");
            return true;

        }
    }

    public boolean phone_validation(){
         if (phoneno.getText().toString().isEmpty()){
            phoneerror.setVisibility(View.VISIBLE);
            phoneerror.setText("*Please enter phoneno.");
            phoneno.requestFocus();
            return false;
        }else {
             phoneerror.setVisibility(View.INVISIBLE);
             phoneerror.setText("");
            return true;
        }
    }

    public boolean workatvalidation(){
         if(userworkat.getSelectedItem().toString().equals("--Select--")){
            workaterror.setVisibility(View.VISIBLE);
            workaterror.setText("*Please select workat.");

            return false;
        }else {
             workaterror.setVisibility(View.INVISIBLE);
             return true;
         }
    }
    public boolean gendervalidation(){
        if(usergender.getSelectedItem().toString().equals("--Select--")){
            gendererror.setVisibility(View.VISIBLE);
            gendererror.setText("*Please select gender.");

            return false;
        }else {
            gendererror.setVisibility(View.INVISIBLE);
            return true;
        }
    }
    public boolean hometownvalidation(){
        if(userhometown.getSelectedItem().toString().equals("--Select--")){
            hometownerror.setVisibility(View.VISIBLE);
            hometownerror.setText("*Please select home town.");

            return false;
        }else {
            hometownerror.setVisibility(View.INVISIBLE);
            return true;
        }
    }
    public boolean liveinvalidation(){
        if(userlivein.getSelectedItem().toString().equals("--Select--")){
            liveinerror.setVisibility(View.VISIBLE);
            liveinerror.setText("*Please select gender.");

            return false;
        }else {
            liveinerror.setVisibility(View.INVISIBLE);
            return true;
        }
    }
    public boolean locationvalidation(){
        if(userlocation.getSelectedItem().toString().equals("--Select--")){
            locationeror.setVisibility(View.VISIBLE);
            locationeror.setText("*Please select gender.");

            return false;
        }else {
            locationeror.setVisibility(View.INVISIBLE);
            return true;
        }
    }


}
