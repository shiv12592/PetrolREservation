package com.example.kamran.loginsignupmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button button_home_page=(Button)findViewById(R.id.button_home_page);
        Button button_edit_profile=(Button)findViewById(R.id.button_edit_profile);
        Button button_back_to_sidebar=(Button)findViewById(R.id.button_back_to_sidebar);

        button_back_to_sidebar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, sideBar.class));
                finish();
            }
        });

        button_home_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, HomePage.class));
                finish();
            }
        });

        button_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, signup.class));
                finish();
            }
        });
    }
}
