package com.example.resturants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class addRestaurant extends AppCompatActivity {


    TextInputEditText etName, etLocation, etPhoneNumber, etDescription;
    Button btnAddResturant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_resturant);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

        btnAddResturant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etName.getText().toString().trim();
                String location = etLocation.getText().toString().trim();
                String phoneNumber = etPhoneNumber.getText().toString().trim();
                String description = etDescription.getText().toString().trim();

                if(name.isEmpty() || location.isEmpty() || phoneNumber.isEmpty() || description.isEmpty()) {

                    Toast.makeText(addRestaurant.this, "Please fill out the form first!", Toast.LENGTH_SHORT).show();
                    return;
                }


                Toast.makeText(addRestaurant.this, "Added!", Toast.LENGTH_SHORT).show();
                MyApplication.restaurants.add(new Restaurant(name,location,phoneNumber,description));

                clear();
                startActivity(new Intent(addRestaurant.this, MainActivity.class));
                finish();

            }
        });
    }

    private void init() {

        etName = findViewById(R.id.etName);
        etLocation = findViewById(R.id.etLocation);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etDescription = findViewById(R.id.etDescription);

        btnAddResturant = findViewById(R.id.btnAddResturant);

    }

    private void clear(){
        etName.setText("");
        etLocation.setText("");
        etPhoneNumber.setText("");
        etDescription.setText("");
    }
}

