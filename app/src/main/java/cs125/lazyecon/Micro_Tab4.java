package cs125.lazyecon;

import android.graphics.Color;
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
    private Double intercept1, slope1, intercept2, slope2, shiftval1, shiftval2;
    private String plusorminus1, plusorminus2;
    private String Spinneritem;
    private EditText interceptinput1, interceptinput2;
    private EditText slopeinput1, slopeinput2;
    private EditText plusorminusinput1, plusorminusinput2;
    private EditText shiftvalinput1, shiftvalinput2;
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
    public void equationtoGraph(Double i, Double s, String sign, boolean colour) {
        double y;
        boolean isPositive = false;
        if (sign.charAt(0) == '+') {
            isPositive = true;
        }
        series = new LineGraphSeries<>();
        GraphView graph = (GraphView)findViewById(R.id.graph);
        int numDataPoints = 200;
        double x = 0;
        if (isPositive) {
            for (int index = 0; index < numDataPoints; index++) {
                x += 0.1;
                y = i + (s * x);
                series.appendData(new DataPoint(x, y), true, 100);
            }
            if (colour) {
                series.setColor(Color.GREEN);
            }
            graph.addSeries(series);
        } else {
            for (int index = 0; index < numDataPoints; index++) {
                x += 0.1;
                y = i - (s * x);
                series.appendData(new DataPoint(x, y), true, 100);
            }
            if (colour) {
                series.setColor(Color.GREEN);
            }
            graph.addSeries(series);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinneritem =  parent.getItemAtPosition(position).toString();
        interceptinput1 = (EditText) findViewById(R.id.interceptfordemandorsupply);
        slopeinput1 = (EditText) findViewById(R.id.slope);
        plusorminusinput1 = (EditText) findViewById(R.id.plusorminus);
        interceptinput2 = (EditText) findViewById(R.id.intercept2);
        slopeinput2 = (EditText) findViewById(R.id.slope2);
        plusorminusinput2 = (EditText) findViewById(R.id.plusorminus2);
        shiftvalinput1 = (EditText) findViewById(R.id.shiftval1);
        shiftvalinput2 = (EditText) findViewById(R.id.shiftval2);
        submit = findViewById(R.id.button2);

        switch(Spinneritem) {
            case "Demand and Supply(Shift both)":
                interceptinput1.setVisibility(View.VISIBLE);
                slopeinput1.setVisibility(View.VISIBLE);
                plusorminusinput1.setVisibility(View.VISIBLE);
                shiftvalinput1.setVisibility(View.VISIBLE);
                interceptinput2.setVisibility(View.VISIBLE);
                slopeinput2.setVisibility(View.VISIBLE);
                plusorminusinput2.setVisibility(View.VISIBLE);
                shiftvalinput1.setVisibility(View.VISIBLE);
                shiftvalinput2.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intercept1 = Double.valueOf(interceptinput1.getText().toString());
                        slope1 = Double.valueOf(slopeinput2.getText().toString());
                        plusorminus1 = plusorminusinput1.getText().toString();
                        intercept2 = Double.valueOf(interceptinput2.getText().toString());
                        slope2 = Double.valueOf(slopeinput2.getText().toString());
                        plusorminus2 = plusorminusinput2.getText().toString();
                        shiftval1 = Double.valueOf(shiftvalinput1.getText().toString());
                        shiftval2 = Double.valueOf(shiftvalinput2.getText().toString());
                        equationtoGraph(intercept1, slope1, plusorminus1, false);
                        equationtoGraph(intercept1 + shiftval1, slope1, plusorminus1, true);
                        equationtoGraph(intercept2, slope2, plusorminus2, false);
                        equationtoGraph(intercept2 + shiftval2, slope2, plusorminus2, true);
                    }
                });
                break;
            case "Demand or Supply (Shift it)":
                interceptinput1.setVisibility(View.VISIBLE);
                slopeinput1.setVisibility(View.VISIBLE);
                plusorminusinput1.setVisibility(View.VISIBLE);
                shiftvalinput1.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intercept1 = Double.valueOf(interceptinput1.getText().toString());
                        slope1 = Double.valueOf(slopeinput1.getText().toString());
                        plusorminus1 = plusorminusinput1.getText().toString();
                        shiftval1 = Double.valueOf(shiftvalinput1.getText().toString());
                        equationtoGraph(intercept1, slope1, plusorminus1,false);
                        equationtoGraph(intercept1 + shiftval1, slope1, plusorminus1, true);
                    }
                });
                break;
            case "Demand and Supply":
                interceptinput1.setVisibility(View.VISIBLE);
                slopeinput1.setVisibility(View.VISIBLE);
                plusorminusinput1.setVisibility(View.VISIBLE);
                interceptinput2.setVisibility(View.VISIBLE);
                slopeinput2.setVisibility(View.VISIBLE);
                plusorminusinput2.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intercept1 = Double.valueOf(interceptinput1.getText().toString());
                        slope1 = Double.valueOf(slopeinput2.getText().toString());
                        plusorminus1 = plusorminusinput1.getText().toString();
                        intercept2 = Double.valueOf(interceptinput2.getText().toString());
                        slope2 = Double.valueOf(slopeinput2.getText().toString());
                        plusorminus2 = plusorminusinput2.getText().toString();
                        equationtoGraph(intercept1, slope1, plusorminus1, false);
                        equationtoGraph(intercept2, slope2, plusorminus2, false);

                    }
                });
                break;


            case "Demand or Supply":
                interceptinput1.setVisibility(View.VISIBLE);
                slopeinput1.setVisibility(View.VISIBLE);
                plusorminusinput1.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intercept1 = Double.valueOf(interceptinput1.getText().toString());
                        slope1 = Double.valueOf(slopeinput1.getText().toString());
                        plusorminus1 = plusorminusinput1.getText().toString();
                        equationtoGraph(intercept1, slope1, plusorminus1, false);
                    }
                });
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
