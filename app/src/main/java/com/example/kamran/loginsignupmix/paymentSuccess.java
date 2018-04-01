package com.example.kamran.loginsignupmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class paymentSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_success);
        Button button_done_payment=(Button)findViewById(R.id.button_done_payment);

        button_done_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(paymentSuccess.this,HomePage.class ));
            }
        });
    }
}
