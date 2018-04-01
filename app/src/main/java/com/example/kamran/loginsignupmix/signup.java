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

import in.gauriinfotech.commons.Commons;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class signup extends AppCompatActivity implements Constant{
    User user;
    private TextView textView_signUp2, textview_signin1;
    private EditText usrname, pswd, mail, address, mobile, fullName;
    private Button button_create_account;
//    private RequestQueue queue;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mail = (EditText) findViewById(R.id.EditText_email);
        pswd = (EditText) findViewById(R.id.edittext_password1);
        usrname = (EditText) findViewById(R.id.editText_username);
        address = (EditText) findViewById(R.id.edittext_address);
        mobile = (EditText) findViewById(R.id.editText_mobile);
        fullName = (EditText) findViewById(R.id.edittext_fullname);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait registration in proccess...");
        progressDialog.setIndeterminate(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
//        queue = Volley.newRequestQueue(this);
        user = new User();


        textView_signUp2 = (TextView) findViewById(R.id.textView_signUp2);
        textview_signin1 = (TextView) findViewById(R.id.textview_signin1);
        button_create_account = (Button) findViewById(R.id.button_create_account);


        textview_signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(signup.this, login.class);
                startActivity(it);
            }
        });


        button_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailId = mail.getText().toString();
                String password = pswd.getText().toString();
                String userName = usrname.getText().toString();
                String address_ = address.getText().toString();
                String mobileNumber = mobile.getText().toString();
                String fullName_ = fullName.getText().toString();

                user.setAddress(address_);
                user.setEmailId(emailId);
                user.setPassword(password);
                user.setUserName(userName);
                user.setMobileNumber(mobileNumber);
                user.setFullName(fullName_);

                new HttpRequestTeask().execute();
//                performRegistration();
            }
        });
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
                final String URL = WEB_SERVER_DOMAIN_LINK + "users";
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
                Intent it = new Intent(signup.this, login.class);
                startActivity(it);
                finish();
            } else {

                Toast.makeText(getApplicationContext(), "Your application not connected to server", Toast.LENGTH_LONG
                ).show();
            }


        }
    }
//    private void performRegistration() {
//        final Gson gson = new Gson();
//        String body = gson.toJson(user);
//        String url = WEB_SERVER_DOMAIN_LINK+"users";
//        RestUtil.select(url, body, queue, new Response.Listener() {
//            @Override
//            public void onResponse(Object response) {
//                Log.e("Response", "Login Response : " + response);
//                Commons.toast(signup.this, "Registration Successfull : ");
//                Intent it = new Intent(signup.this, login.class);
//                startActivity(it);
//                finish();
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("Exception", "Exception " + Log.getStackTraceString(error));
//                Commons.toast(signup.this, "Exception occured : " + error);
//            }
//        });
//    }
}
