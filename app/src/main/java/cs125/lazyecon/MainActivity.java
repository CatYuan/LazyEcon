package cs125.lazyecon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToMicro(View view) {
        Log.d(LOG_TAG, "micro_button clicked");
        Intent microIntent = new Intent(this, MicroActivity.class);
        startActivity(microIntent);
    }

    public void goToMacro(View view) {
        Log.d(LOG_TAG, "macro_button clicked");
        Intent macroIntent = new Intent(this, MacroActivity.class);
        startActivity(macroIntent);
    }
}
