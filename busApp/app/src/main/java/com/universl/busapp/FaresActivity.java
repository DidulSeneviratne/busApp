package com.universl.busapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class FaresActivity extends AppCompatActivity {

    private Spinner spinnerFareClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fares);

        spinnerFareClass = findViewById(R.id.spinnerFareClass);

        // Spinner values
        String[] classes = {"Normal", "Semi-Luxury", "Luxury", "Super Luxury", "Sisu Sariya"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFareClass.setAdapter(adapter);

        spinnerFareClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedClass = classes[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }
}