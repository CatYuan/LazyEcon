package cs125.lazyecon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class macro_tab1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String spinnerItem;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private String macro_log = "cs.125.lazyEcon.macro_tab1";
    private Button submit;
    private TextView result;
    private double text1Num;
    private double text2Num;
    private double text3Num;
    private double text4Num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macro_tab1);
        Log.d(macro_log, "Activity created");

        //create all the views in XML
        editText1 = (EditText)findViewById(R.id.macro_tab1_GDP_editText1);
        editText2 = (EditText)findViewById(R.id.macro_tab1_GDP_editText2);
        editText3 = (EditText)findViewById(R.id.macro_tab1_GDP_editText3);
        editText4 = (EditText)findViewById(R.id.macro_tab1_GDP_editText4);
        submit = (Button)findViewById(R.id.macro_tab1_submit_button);
        result = (TextView)findViewById(R.id.macro_tab1_results);
        Log.d(macro_log, "views created");

        // Create the spinner.
        Spinner spinner = (Spinner) findViewById(R.id.macro_tab1_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        Log.d(macro_log,"creating spinner");
        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.macro_tab1_spinner_array, android.R.layout.simple_spinner_item);
        Log.d(macro_log,"Array adapter created for adding spinnerItems to spinner");
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Log.d(macro_log,"layout for spinnerItems");
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
        Log.d(macro_log,"adapter applied to spinner");


        //what happens when a different spinnerItem is selected
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1Num = Double.parseDouble(editText1.getText().toString());
                text2Num = Double.parseDouble(editText2.getText().toString());
                text3Num = Double.parseDouble(editText3.getText().toString());
                text4Num = Double.parseDouble(editText4.getText().toString());
                Double sum = text1Num + text2Num + text3Num + text4Num;
                result.setText("The GDP is " + sum);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerItem = parent.getItemAtPosition(position).toString();
        if (spinnerItem.equals("Expenditure")) {
            editText1.setHint("Consumption");
            editText2.setHint("Investments");
            editText3.setHint("Government");
            editText4.setHint("Net Exports");
        }
        if (spinnerItem.equals("Income")) {
            editText1.setHint("Wages");
            editText2.setHint("Interest");
            editText3.setHint("Rent");
            editText4.setHint("Profit");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
