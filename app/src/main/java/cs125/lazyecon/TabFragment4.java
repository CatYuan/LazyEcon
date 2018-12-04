package cs125.lazyecon;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment4 extends Fragment {


    public TabFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_fragment4, container, false);
    }
    private LineGraphSeries<DataPoint> series;
    public void equationtoGraph(String intercept, String slope, boolean isPositive) {
        int i = Integer.parseInt(intercept);
        int s = Integer.parseInt(slope);
        double y;
        series = new LineGraphSeries<>();
        GraphView graph = (GraphView) getView().findViewById(R.id.graph);
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


}
