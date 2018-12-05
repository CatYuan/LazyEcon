package cs125.lazyecon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Micro_Tab1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button submit;
    private EditText priceChange;
    private EditText QChange;
    private double priceChange_val;
    private double QChange_val;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_micro__tab1);

        //create the submit button
        submit = (Button)findViewById(R.id.button);
        //create the EditText boxes
        priceChange = (EditText)findViewById(R.id.textView9);
        QChange = (EditText)findViewById(R.id.textView8);
        result = (TextView) findViewById(R.id.tvanswer);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priceChange_val = Double.valueOf(priceChange.getText().toString());
                QChange_val = Double.valueOf(QChange.getText().toString());
            }
        });

        // Create the spinner.
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.micro_tab1_spinner_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinneritem = parent.getItemAtPosition(position).toString();
        if (spinneritem.equals("Demand")) {
            double d = elasticityd(QChange_val, priceChange_val);
            result.setText("The Elasticity of Demand is = " + String.valueOf(d));
        }


        //TODO insert code for what happens when a specific spinner_item is selected
        //TODO how do we handle different elasticities within the program
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public double elasticityd(double Q, double P) {
        return -Math.abs(Q/P);
    }

}
