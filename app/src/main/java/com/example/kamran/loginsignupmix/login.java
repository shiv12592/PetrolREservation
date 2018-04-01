package com.example.kamran.loginsignupmix;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.kamran.loginsignupmix.entities.User;
import com.example.kamran.loginsignupmix.rest.RestUtil;
import com.google.gson.Gson;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import in.gauriinfotech.commons.Commons;

public class login extends AppCompatActivity implements Constant {
    ProgressDialog progressDialog;
    User user;
    private TextView textView_signin, textView_signup;
    private EditText edittxt_email, edittext_password;
    private Button button_signin, button_dont_have_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView_signup = (TextView) findViewById(R.id.textView_signup);
        textView_signin = (TextView) findViewById(R.id.textView_signin);
        button_signin = (Button) findViewById(R.id.button_signin);
        button_dont_have_account = (Button) findViewById(R.id.button_dont_have_account);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait login in proccess...");
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        edittext_password = findViewById(R.id.edittext_password);
        edittxt_email = findViewById(R.id.edittxt_email);
        user = new User();



        textView_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(login.this, signup.class);
                startActivity(it);
            }
        });
        button_dont_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(login.this, signup.class);
                startActivity(it);
            }
        });
        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edittxt_email.getText().toString().trim();
                String password = edittext_password.getText().toString().trim();
                user.setEmailId(email);
                user.setPassword(password);
//                new HttpRequestTeask().execute();

                Intent it = new Intent(login.this, sideBar.class);
                startActivity(it);

            }
        });
    }



    private void showHome() {

    }

    private class HttpRequestTeask extends AsyncTask<Void, Void, User> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            System.out.println("on preExecute method call");
            progressDialog.show();
        }

        @Override
        protected User doInBackground(Void... voids) {
            try {
                final String URL = WEB_SERVER_DOMAIN_LINK + "login";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                User registerUser = restTemplate.postForObject(URL, user, User.class);

                System.out.println("Register user :: " + registerUser.toString());
                return registerUser;
            } catch (Exception e) {
                e.printStackTrace(System.err);
            }
            return null;
        }

        @Override
        protected void onPostExecute(User result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            if (result != null) {
                Intent it = new Intent(login.this, sideBar.class);
                startActivity(it);
            } else {

                Toast.makeText(getApplicationContext(), "Please check user name and password..", Toast.LENGTH_LONG
                ).show();
            }


        }
    }

}
