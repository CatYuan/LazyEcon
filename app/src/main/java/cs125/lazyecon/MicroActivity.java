package cs125.lazyecon;

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

    public static final String EXTRA_MESSAGE =
            "com.example.android.LazyEcon.extra.MESSAGE";
    private EditText mMessageEditText;
    private String change_in_demand;
    private String change_in_price;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro);

        //creates Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //instance of tabLayout from View
        TabLayout tabLayout = (TabLayout) findViewById(R.id.micro_tab_layout);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText(R.string.microTabItem1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.microTabItem2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.microTabItem3));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.microTabItem4));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        // This is another example of the adapter pattern.
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PageAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        // Create an instance of the tab layout from the view.
    }

    public void submitText(View view) {
        mMessageEditText = (EditText) findViewById(R.id.demand_change_edit_text);
        change_in_demand = mMessageEditText.getText().toString();
        mMessageEditText = (EditText) findViewById(R.id.price_change_edit_text);
        change_in_price = mMessageEditText.getText().toString();
    }



    public static void main(String[] args) {
        
    }
}
