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

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Micro_Tab4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Double intercept, slope;
    private String plusorminus;
    private String Spinneritem;
    private EditText interceptinput;
    private EditText slopeinput;
    private EditText plusorminusinput;

    private Button submit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro__tab4);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.Graphstuff, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        if (spinner1 != null) {
            spinner1.setOnItemSelectedListener(this);
        }
    }

    private LineGraphSeries<DataPoint> series;
    public void equationtoGraph(Double i, Double s, String sign) {
        double y;
        boolean isPositive;
        if (sign == "+") {
            isPositive = true;
        } else {
            isPositive = false;
        }
        series = new LineGraphSeries<>();
        GraphView graph = (GraphView)findViewById(R.id.graph);
        int numDataPoints = 500;
        double x = 0;
        if (isPositive) {
            for (int index = 0; index < numDataPoints; index++) {
                x += 0.1;
                y = i + (s * x);
                series.appendData(new DataPoint(x, y), true, 100);
            }
            graph.addSeries(series);
        } else {
            for (int index = 0; index < numDataPoints; index++) {
                x += 0.1;
                y = i - (s * x);
                series.appendData(new DataPoint(x, y), true, 100);
            }
            graph.addSeries(series);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinneritem =  parent.getItemAtPosition(position).toString();
        interceptinput = (EditText) findViewById(R.id.interceptfordemandorsupply);
        slopeinput = (EditText) findViewById(R.id.slope);
        plusorminusinput = (EditText) findViewById(R.id.plusorminus);
        submit = findViewById(R.id.button2);

        switch(Spinneritem) {
            case "Demand or Supply":
                interceptinput.setVisibility(View.VISIBLE);
                slopeinput.setVisibility(View.VISIBLE);
                plusorminusinput.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intercept = Double.valueOf(interceptinput.getText().toString());
                        slope = Double.valueOf(slopeinput.getText().toString());
                        plusorminus = plusorminusinput.getText().toString();

                    }
                });

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
