package cs125.lazyecon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToMicro(View view) {
        Intent microIntent = new Intent(this, MicroActivity.class);
        startActivity(microIntent);
    }

    public void goToMacro(View view) {
        Intent macroIntent = new Intent(this, MacroActivity.class);
        startActivity(macroIntent);
    }
}
