package cs125.lazyecon;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MicroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro);
    }

    public void micro_goToTab1(View view) {
        Intent intent = new Intent(this, Micro_Tab1.class);
        startActivity(intent);
    }

    public void micro_goToTab2(View view) {
        Intent intent = new Intent(this, Micro_Tab2.class);
        startActivity(intent);
    }

    public void micro_goToTab3(View view) {
        Intent intent = new Intent(this, Micro_Tab3.class);
        startActivity(intent);
    }

    public void micro_goToTab4(View view) {
        Intent intent = new Intent(this, Micro_Tab4.class);
        startActivity(intent);
    }
}
