package cs125.lazyecon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
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
    private String typeofSpinner;
    private double elasticity;
    private String Degreeofelasticity;

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

        //when the Submit button is clicked
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //stores the values that the user has input into each EditText
                priceChange_val = Double.parseDouble(priceChange.getText().toString());
                QChange_val = Double.parseDouble(QChange.getText().toString());

                /*TODO this is where you insert what to do in case of each different elasticity.
                  you can directly insert the elasticity equations under each case
                  or you can create separate functions as you did for elasticityd

                  For example the <code> case "Demand": </code> could have been written as
                         result.setText("The elasticity of Demand is " + "-" + Math.abs(QChange_val/priceChange_val));
                  or it can be written as it is below.
                  TODO However you choose to write the remaining elsaticities, please write them within each "case" block
                 */
                switch(typeofSpinner) {
                    case "Demand":
                        elasticity = elasticityd(QChange_val, priceChange_val);
                        if (Math.abs(elasticity) == 1) {
                            Degreeofelasticity = "so it is Unitary Elastic";
                        }
                        if (Math.abs(elasticity) > 1) {
                            Degreeofelasticity = "so it relatively elastic";
                        } else {
                            Degreeofelasticity = "so it is relatively inelastic";
                        }
                        result.setText("The elasticity of Demand is = " + elasticity + Degreeofelasticity);
                        break;
                    case "Supply":
                        elasticity = elasticitys(QChange_val, priceChange_val);
                        if (Math.abs(elasticity) == 1) {
                            Degreeofelasticity = "so it is Unitary Elastic";
                        }
                        if (Math.abs(elasticity) > 1) {
                            Degreeofelasticity = "so it relatively elastic";
                        } else {
                            Degreeofelasticity = "so it is relatively inelastic";
                        }
                        result.setText("The elasticity of Supply is = " + elasticity + Degreeofelasticity);
                        break;
                    case "Cross":
                        elasticity = elasticityCross(QChange_val, priceChange_val);
                        if (elasticity == 0) {
                            Degreeofelasticity = "so the two goods are unrelated.";
                        }
                        if (elasticity > 0) {
                            Degreeofelasticity = "since it is positive, the two goods are substitutes.";
                        } else {
                            Degreeofelasticity = "the two goods are complementary";
                        }
                        result.setText("The cross elasticity is equal to" + elasticity + Degreeofelasticity);
                        break;
                    case "Income":
                        elasticity = elasticityincome(QChange_val, priceChange_val);
                        if (elasticity == 0) {
                            Degreeofelasticity = "so income has no affect on the demand of the good";
                        }
                        if (elasticity > 0) {
                            Degreeofelasticity = ",since it is positive, the good in place is normal.";
                        } else {
                            Degreeofelasticity = "so the good is inferior";
                        }
                        result.setText("The Income elasticity is equal to" + elasticity + Degreeofelasticity);
                        break;
                    default:
                        result.setText("invalid option");
                        break;
                }
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
        //sets typeofSpinner to the spinneritem
        typeofSpinner = spinneritem;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public double elasticityd(double Q, double P) {
        return -Math.abs(Q/P);
    }
    public double elasticitys(double Q, double P) { return Math.abs(Q/P);}
    public double elasticityCross(double Q, double P) {return Q/P;}
    public double elasticityincome(double Q, double P) {return Q/P;}

}
