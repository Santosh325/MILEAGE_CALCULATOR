package com.example.mileagecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText startO, endO, fPrice, tFuel;
    Button result;
    TextView totalPrice, mileage, pricePerKm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startO = findViewById(R.id.startOdometer);
        endO = findViewById(R.id.endOdometer);
        fPrice = findViewById(R.id.price);
        tFuel = findViewById(R.id.fuel);
        result = findViewById(R.id.calculate);
        totalPrice = findViewById(R.id.totalFuelPrice);
        mileage = findViewById(R.id.mileage);
        pricePerKm = findViewById(R.id.pricePerKm);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getStart = startO.getText().toString();
                String getEnd = endO.getText().toString();
                String getPrice = fPrice.getText().toString();
                String getFuel = tFuel.getText().toString();



                if(getStart.equals("") || getEnd.equals("") || getPrice.equals("") || getFuel.equals("")) {
                    Toast.makeText(MainActivity.this,"Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    int conStart = Integer.parseInt(getStart);
                    int conEnd = Integer.parseInt(getEnd);
                    int conPrice = Integer.parseInt(getPrice);
                    int conFuel = Integer.parseInt(getFuel);
                    if(conEnd > conStart) {
                        float totPrice = conPrice * conFuel;
                        float mil = (conEnd - conStart ) / conFuel;
                        float  ppk = (totPrice ) / (conEnd - conStart);
                        String t = String.valueOf(totPrice);
                        String m = String.valueOf(mil);
                        String p = String.valueOf(ppk);
                        totalPrice.setText("Total Price of Fuel is " + t + " rs.");
                        mileage.setText("Your mileage of Car is " + m + " per/km.");
                        pricePerKm.setText("Price per distance is " + p + " km/rs.");

                    } else
                    Toast.makeText(MainActivity.this,"sorry Ending Odometer must be greater than starting odometer", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
