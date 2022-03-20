package com.example.dc_midterm_proj_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dc_midterm_proj_login.api.BaseURL;
import com.example.dc_midterm_proj_login.api.RequestPlaceholder;
import com.example.dc_midterm_proj_login.api.RetrofitBuilder;
import com.example.dc_midterm_proj_login.pojos.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SignupActivity extends AppCompatActivity {


    EditText name, username, password, email;
    Button buttonSignUp;
    ProgressBar progressBar;
    TextView loginText;
    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        progressBar = findViewById(R.id.progressBar);
        buttonSignUp = findViewById(R.id.buttonSignUp);
        loginText = findViewById(R.id.loginText);
        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);


        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (loginText.isClickable()) ;
                openLoginActivity();
            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process();


            }
        });
    }

    private void openLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

   public void process(){

       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl(BaseURL.baseURL())
               .addConverterFactory(GsonConverterFactory.create())
               .build();

       RequestPlaceholder requestPlaceholder = retrofit.create(RequestPlaceholder.class);
      //Calling the Register which is inside RequestPlaceholder
       Call<Register> call = requestPlaceholder.adddata(name.getText().toString(), username.getText().toString(), email.getText().toString(), password.getText().toString());


       call.enqueue(new Callback<Register>() {
           @Override
           public void onResponse(Call<Register> call, Response<Register> response) {

               String reg_name = name.getText().toString();
               String reg_username = username.getText().toString();
               String reg_email = email.getText().toString();
               String reg_password = password.getText().toString();

               //checking if full name is empty
               if (TextUtils.isEmpty(reg_name)){
                   name.setError("Please enter Full Name");
                   username.requestFocus();
                   return;
               }
               //checking if username is empty
               if (TextUtils.isEmpty(reg_username)) {
                   username.setError("Please enter Username");
                   username.requestFocus();
                   return;
               }
               //checking if email is empty
               if (TextUtils.isEmpty(reg_email)) {
                   email.setError("Please enter Email");
                   email.requestFocus();
                   return;
               }

               //checking if password is empty
               if (TextUtils.isEmpty(reg_password)) {
                   password.setError("Please enter Password");
                   password.requestFocus();
                   return;


               }else{
                   //If the response code is OK then it will insert the Text
                   if (response.code()==200){
                       name.setText("");
                       username.setText("");
                       email.setText("");
                       password.setText("");
                       Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                       startActivity(intent);
                       finish();
                   }

               }

           }

           @Override
           public void onFailure(Call<Register> call, Throwable t) {
               Toast.makeText(getApplicationContext(),t.toString(), Toast.LENGTH_LONG).show();

           }
       });

   }
}






