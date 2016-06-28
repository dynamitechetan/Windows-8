package dynamitechetan.windows8;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

import dynamitechetan.windows8.Apps.InternetExplorer;

public class DesktopActivity extends AppCompatActivity {
    private ImageView internetexplorer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FullScreencall();


        setContentView(R.layout.activity_desktop);

        ImageView start = (ImageView) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startActivity = new Intent(DesktopActivity.this, MetroMain.class);
                finish();
                startActivity(startActivity);

            }
        });

        internetexplorer = (ImageView) findViewById(R.id.internetondesktop);
        internetexplorer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startActivity = new Intent(DesktopActivity.this, InternetExplorer.class);
                startActivity(startActivity);

            }
        });

        TextView tv = (TextView) findViewById(R.id.date);
        String ct = DateFormat.getDateInstance().format(new Date());
        tv.setText(ct);

    }

    public void FullScreencall() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

}
