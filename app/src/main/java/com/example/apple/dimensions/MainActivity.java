package com.example.apple.dimensions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spl1, spl2;
    Button btn;
    LinearLayout ll;
    String spinPro, spinPro1;
    List<String> list;
    ArrayAdapter<String> dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spl1 = findViewById(R.id.spl1);
        btn = findViewById(R.id.btn);
        ll = findViewById(R.id.ll);

        list = new ArrayList<>();
        list.add("Choose Specialty");
        list.add("Dentistry");
        list.add("Optometry");
        list.add("Veterinary");
        dataAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spl1.setAdapter(dataAdapter);
        spl1.setOnItemSelectedListener(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LinearLayout newView = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_main_second, null);
                spl2 = newView.findViewById(R.id.spl2);
                ll.addView(newView);
                spl2.setAdapter(dataAdapter);
                ArrayAdapter arrayAdapter = (ArrayAdapter) spl2.getAdapter(); // parent Spinner value is displayed the same on sub Spinner
                int val = arrayAdapter.getPosition(spinPro); // parent Spinner value is displayed the same on sub Spinner
                spl2.setSelection(val); // parent Spinner value is displayed the same on sub Spinner
                spl2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        spinPro1 = spl2.getSelectedItem().toString();
                        Toast.makeText(getApplicationContext(), " selected " + " " + spinPro1, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        Toast.makeText(getApplicationContext(), "Please select", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String province = (String)parent.getItemAtPosition(position);
        spinPro = spl1.getSelectedItem().toString();
        Toast.makeText(this, " selected " + " " + spinPro, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Please select", Toast.LENGTH_LONG).show();
    }
}
