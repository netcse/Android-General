package check_box.netcse.com.android_check_box;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        ImageButton nextIntent = (ImageButton)findViewById(R.id.Button02);

        nextIntent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ThirdActivity.class);
                startActivityForResult(intent, 0);
            }

        });
    }

}
