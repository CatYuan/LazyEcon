package cs125.lazyecon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Micro_Tab4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private String Spinneritem;

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
    public void equationtoGraph(String intercept, String slope, boolean isPositive) {
        int i = Integer.parseInt(intercept);
        int s = Integer.parseInt(slope);
        double y;
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
        Spinneritem = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
