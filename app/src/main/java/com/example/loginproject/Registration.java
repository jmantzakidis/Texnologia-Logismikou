package com.example.loginproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


public class Registration extends AppCompatActivity {

    EditText etName,etSurname,etMobile,etEmail,etUsername,etPassword,etConfirmPassword;
    Button btSubmit;
    AwesomeValidation awesomeValidation;
    TextView tv_Specialities;

    @SuppressLint("SetTextI18n")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Registration Form");
        setContentView(R.layout.activity_registration);

        Spinner mySpinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Registration.this, R.layout.spinner_test, getResources().getStringArray(R.array.Specialities));
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        tv_Specialities = findViewById(R.id.tv_Speciatlities);
        etName = findViewById(R.id.et_name);
        etSurname = findViewById(R.id.et_surname);
        etMobile = findViewById(R.id.et_mobile);
        etEmail = findViewById(R.id.et_email);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        btSubmit = findViewById(R.id.bt_submit);

        tv_Specialities.setText("Speciality: ");

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.et_name,
                RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.et_surname,
                RegexTemplate.NOT_EMPTY,R.string.invalid_surname);
        awesomeValidation.addValidation(this,R.id.et_username,
                RegexTemplate.NOT_EMPTY,R.string.invalid_username);
        awesomeValidation.addValidation(this,R.id.et_mobile
                ,"[5-9]{1}[0-9]{9}$",R.string.invalid_mobile);
        awesomeValidation.addValidation(this,R.id.et_email
                , Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        awesomeValidation.addValidation(this,R.id.et_password
                , ".{6,}",R.string.invalid_password);
        awesomeValidation.addValidation(this,R.id.et_confirm_password
                ,R.id.et_password,R.string.invalid_confirm_password);

        btSubmit.setOnClickListener(v -> {
            if(awesomeValidation.validate()){
                Toast.makeText(getApplicationContext(),"Form Registration Succefully...",Toast.LENGTH_SHORT).show();
                etName.setText("");
                etSurname.setText("");
                etMobile.setText("");
                etEmail.setText("");
                etUsername.setText("");
                etPassword.setText("");
                etConfirmPassword.setText("");
                Intent intent = new Intent(Registration.this,BossActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"Registration Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
