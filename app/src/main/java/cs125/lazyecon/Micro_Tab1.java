package cs125.lazyecon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private EditText demandChange;
    private String priceChange_string;
    private String demandChange_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro__tab1);

        //create the submit button
        submit = (Button)findViewById(R.id.micro_button);
        //create the EditText boxes
        priceChange = (EditText)findViewById(R.id.micro_tab1_price_change_edit_text);
        demandChange = (EditText)findViewById(R.id.micro_tab1_demand_change_edit_text);

        // Create the spinner.
        Spinner spinner = (Spinner) findViewById(R.id.micro_tab1_spinner);
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
        String spinner_item = parent.getItemAtPosition(position).toString();

        //TODO insert code for what happens when a specific spinner_item is selected
        //TODO how do we handle different elasticities within the program
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onSubmit(View view) {
        priceChange_string = priceChange.getText().toString();
        demandChange_string = demandChange.getText().toString();
    }
}
