package com.example.resturants;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

import com.google.android.material.textfield.TextInputEditText;

// This is the second activity where user can enter his own restaurants details
public class addRestaurant extends AppCompatActivity {


    TextInputEditText etName, etLocation, etPhoneNumber, etDescription;
    Button btnAddResturant;

    SharedPreferences spref;

    private final String name = "RESTAURANT_SPREF";

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


        // on clicking the add button, it takes all the information needed
        // and add it to the list that displays

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


                String randomRating = "" + Math.round(new Random().nextDouble() * 500) / 100.0;
                String newRestaurant = name + "," + location + "," + phoneNumber + "," + description + "," + randomRating + "\n";

                String restaurant = spref.getString("restaurant_list", null);
                restaurant += newRestaurant;

                SharedPreferences.Editor editor = spref.edit();
                editor.putString("restaurant_list",restaurant);
                editor.apply();


                Toast.makeText(addRestaurant.this, "Added!", Toast.LENGTH_SHORT).show();


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


        spref = getSharedPreferences(name, MODE_PRIVATE );

    }

    private void clear(){
        etName.setText("");
        etLocation.setText("");
        etPhoneNumber.setText("");
        etDescription.setText("");
    }
}

