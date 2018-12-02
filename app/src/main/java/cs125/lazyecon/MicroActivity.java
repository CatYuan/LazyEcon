package cs125.lazyecon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MicroActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro);
    }
    private LineGraphSeries<DataPoint> series;
    public void equationtoGraph(String intercept, String slope, boolean isPositive) {
        int i = Integer.parseInt(intercept);
        int s = Integer.parseInt(slope);
        double y;
        GraphView graph = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<>();
        int numDataPoints = 500;
        double x = 0;
        if (isPositive) {
            for (int index = 0; index < numDataPoints; index++) {
                x += 0.1;
                y = i + (s*x);
                series.appendData(new DataPoint(x,y), true, 100);
            }
            graph.addSeries(series);
        } else {
            for (int index = 0; index < numDataPoints; index++) {
                x += 0.1;
                y = i - (s*x);
                series.appendData(new DataPoint(x,y), true, 100);
            }
            graph.addSeries(series);
        }
    }

    public static void main(String[] args) {
        
    }
}
