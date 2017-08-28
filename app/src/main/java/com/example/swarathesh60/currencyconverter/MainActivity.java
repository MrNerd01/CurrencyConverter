package com.example.swarathesh60.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button button;
    EditText input;
    TextView output;
    Spinner choice;
    ArrayList<String> countries = new ArrayList<>();
    String item=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initiate views
        button = (Button) findViewById(R.id.button);
        input = (EditText) findViewById(R.id.editText);
        output = (TextView) findViewById(R.id.textView2);
        choice = (Spinner) findViewById(R.id.spinner2);
        choice.setOnItemSelectedListener(this);
        PopulateSpinner();

        //initiate array adapter

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choice.setAdapter(adapter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  InputString ;   //inp;ut.getText().toString();
                double resultprint = Double.parseDouble(input.getText().toString());
                switch (item.toLowerCase()){
                    case "usa" : resultprint*=0.016; break;
                    case "germany" : resultprint*=0.15; break;
                    case "canada" : resultprint*=0.12; break;
                    case "russia" : resultprint*=0.18; break;
                    case "africa" : resultprint*=0.0244; break;
                }
                InputString = String.valueOf(resultprint);
                output.setText(InputString +" "+ item);
                Toast.makeText(getApplicationContext(),InputString,Toast.LENGTH_LONG).show();
         }
        });

    }

    private void PopulateSpinner() {
        countries.add("USA");
        countries.add("Germany");
        countries.add("Canada");
        countries.add("Russia");
        countries.add("Africa");
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // On selecting a spinner item
         item = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
