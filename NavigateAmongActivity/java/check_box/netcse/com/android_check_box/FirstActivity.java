package check_box.netcse.com.android_check_box;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FirstActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);

        ImageButton nextIntent = (ImageButton)findViewById(R.id.Button01);
        nextIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), CalendarActivity.class);
                startActivityForResult(myIntent, 1);
            }

        });
    }
}