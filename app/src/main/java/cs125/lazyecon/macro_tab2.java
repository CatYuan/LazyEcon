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

import org.w3c.dom.Text;

public class macro_tab2 extends AppCompatActivity {
    private EditText editTextInterest1;
    private EditText editTextInterest2;
    private EditText editTextInflation1;
    private EditText editTextInflation2;
    private Button submitInflation;
    private Button submitInterest;
    private TextView resultInflation;
    private TextView resultInterest;
    private double text1InflationNum;
    private double text2InflationNum;
    private double text1InterestNum;
    private double text2InterestNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macro_tab2);

        //create all the views in XML
        editTextInflation1 = (EditText)findViewById(R.id.macro_tab2_inflation_editText1);
        editTextInflation2 = (EditText)findViewById(R.id.macro_tab2_inflation_editText2);
        editTextInterest1 = (EditText)findViewById(R.id.macro_tab2_interest_editText1);
        editTextInterest2 = (EditText)findViewById(R.id.macro_tab2_interest_editText2);
        submitInflation = (Button)findViewById(R.id.macro_tab2_inflation_submit_button);
        submitInterest = (Button)findViewById(R.id.macro_tab2_interest_submit_button);
        resultInflation = (TextView)findViewById(R.id.macro_tab2_inflation_results);
        resultInterest = (TextView)findViewById(R.id.macro_tab2_interest_results);

        submitInflation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1InflationNum = Double.parseDouble(editTextInflation1.getText().toString());
                text2InflationNum = Double.parseDouble(editTextInflation2.getText().toString());
                Double output = (text1InflationNum - text2InflationNum) / text2InflationNum;
                resultInflation.setText("The inflation rate is " + output * 100 + "%");
            }
        });

        submitInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1InterestNum = Double.parseDouble(editTextInterest1.getText().toString());
                text2InterestNum = Double.parseDouble(editTextInterest2.getText().toString());
                Double output = (text1InterestNum - text2InterestNum);
                resultInterest.setText("The real interest rate is " + output);
            }
        });
    }
}
