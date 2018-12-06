package cs125.lazyecon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MacroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macro);
    }

    public void macro_goToTab1(View view) {
        Intent intent = new Intent(this, macro_tab1.class);
        startActivity(intent);
    }

    public void macro_goToTab2(View view) {
        Intent intent = new Intent(this, macro_tab2.class);
        startActivity(intent);
    }

    public void macro_goToTab3(View view) {
        Intent intent = new Intent(this, macro_tab3.class);
        startActivity(intent);
    }

    public void macro_goToTab4(View view) {
        Intent intent = new Intent(this, macro_tab4.class);
        startActivity(intent);
    }
}
