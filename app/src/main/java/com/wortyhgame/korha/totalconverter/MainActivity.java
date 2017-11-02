package com.wortyhgame.korha.totalconverter;//package com.example.tmp_sda_1138.lengthconverter;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.wortyhgame.korha.totalconverter.R;

public class MainActivity extends AppCompatActivity {

    public double enteredNumber;
    public double convertedNumber;

    Spinner firstSpinner;
    Spinner secondSpinner;
    ArrayAdapter<CharSequence> firstAdapter;
    ArrayAdapter<CharSequence> secondAdapterDistances;
    ArrayAdapter<CharSequence> secondAdapterWeights;
    ArrayAdapter<CharSequence> secondAdapterVolume;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();

        final String[] distances = res.getStringArray(R.array.distances);
        final String[] weights = res.getStringArray(R.array.weights);
        final String[] volume = res.getStringArray(R.array.volume);



        firstSpinner = (Spinner) findViewById(R.id.firstSpinner);
        secondSpinner = (Spinner) findViewById(R.id.secondSpinner);
        firstAdapter = ArrayAdapter.createFromResource(this,R.array.distances+R.array.weights+R.array.volume,android.R.layout.simple_spinner_item);
        firstAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firstSpinner.setAdapter(firstAdapter);

        secondAdapterDistances = ArrayAdapter.createFromResource(this,R.array.distances,android.R.layout.simple_spinner_item);
        secondAdapterDistances.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        secondAdapterWeights = ArrayAdapter.createFromResource(this,R.array.weights,android.R.layout.simple_spinner_item);
        secondAdapterWeights.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        secondAdapterVolume = ArrayAdapter.createFromResource(this,R.array.volume,android.R.layout.simple_spinner_item);
        secondAdapterVolume.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String measureSelectedOnFirstSpinner = parent.getItemAtPosition(position).toString();
                String test = null;


                for (int i = 0; i < distances.length; i++) {
                    test = distances[i];
                    if (test.equals(measureSelectedOnFirstSpinner)) {
                        secondSpinner.setAdapter(secondAdapterDistances);

                        break;
                    }
                }
                for (int i = 0; i < weights.length; i++) {
                    test = weights[i];
                    if (test.equals(measureSelectedOnFirstSpinner)) {
                        secondSpinner.setAdapter(secondAdapterWeights);

                        break;
                    }
                }
                for (int i = 0; i < volume.length; i++) {
                    test = volume[i];
                    if (test.equals(measureSelectedOnFirstSpinner)) {
                        secondSpinner.setAdapter(secondAdapterVolume);

                        break;
                    }
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String measureSelectedOnFirstSpinner = null;
            }
        });



    }



    public void convert(View p){
        EditText entered = (EditText) findViewById(R.id.numberText);
        double m = 3.28084;

        enteredNumber = Double.parseDouble(entered.getText().toString());
        convertedNumber = enteredNumber*m;

        TextView result = (TextView) findViewById(R.id.targetText);
        result.setText(convertedNumber + "");

    }
}
