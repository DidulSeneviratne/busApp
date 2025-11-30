package com.universl.busapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

	Spinner spinnerServiceClass;
	ArrayAdapter<String> classAdapter;
	BottomNavigationView bottomNavigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spinnerServiceClass = findViewById(R.id.spinnerServiceClass);

		// Data for spinner
		String[] busClasses = {
				"Normal",
				"Semi-Luxury",
				"Luxury",
				"Super Luxury"
		};

		// Adapter to connect data with spinner
		classAdapter = new ArrayAdapter<>(
				this,
				android.R.layout.simple_spinner_item,  // default spinner layout
				busClasses
		);
		classAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// Set adapter to spinner
		spinnerServiceClass.setAdapter(classAdapter);

		// Handle selected item
		spinnerServiceClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				String selectedClass = parent.getItemAtPosition(position).toString();
				Toast.makeText(MainActivity.this, "Selected: " + selectedClass, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// Optional
			}
		});

		bottomNavigationView = findViewById(R.id.bottomNavigation);

		bottomNavigationView.setOnItemSelectedListener(item -> {
			if (item.getItemId() == R.id.menu_routes) {
				Intent intent = new Intent(MainActivity.this, RoutesActivity.class);
				startActivity(intent);
				return true;
			} else if (item.getItemId() == R.id.menu_fares) {
				Intent intent = new Intent(MainActivity.this, FaresActivity.class);
				startActivity(intent);
				return true;
			}
			return false;
		});
	}

}