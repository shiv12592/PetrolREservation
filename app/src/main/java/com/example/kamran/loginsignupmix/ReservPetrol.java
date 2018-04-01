package com.example.kamran.loginsignupmix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ReservPetrol extends AppCompatActivity {

    private RadioGroup radioGroup_fuel_type;
    private RadioButton radioFuelButton;
    private Button Button_Display_Fuel_selcted, button_wallet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv_petrol);
        addListenerOnButton();

    }
    private void addListenerOnButton() {
            radioGroup_fuel_type = (RadioGroup) findViewById(R.id.radioGroup_fuel_type);
            Button_Display_Fuel_selcted = (Button) findViewById(R.id.Button_Display_Fuel_selcted);
            button_wallet = (Button) findViewById(R.id.button_wallet);

            Button_Display_Fuel_selcted.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // get selected radio button from radioGroup
                    int selectedId = radioGroup_fuel_type.getCheckedRadioButtonId();

                    // find the radiobutton by returned id
                    radioFuelButton = (RadioButton) findViewById(selectedId);

                    Toast.makeText(ReservPetrol.this,
                            radioFuelButton.getText(), Toast.LENGTH_SHORT).show();

                }

            });

            Button button_wallet=(Button)findViewById(R.id.button_wallet);
            button_wallet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(ReservPetrol.this, paymentSuccess.class));
                    finish();
                }
            });
        }


}
