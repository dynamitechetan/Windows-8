package dynamitechetan.windows8;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import dynamitechetan.windows8.PaintAppv2.Paint_Activity_main;

public class MetroMain extends AppCompatActivity {
    private ImageView down_metro_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FullScreencall();
        setContentView(R.layout.activity_metro_main);


        ImageView desktop = (ImageView) findViewById(R.id.test1);
        desktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startActivity = new Intent(MetroMain.this, DesktopActivity.class);
                finish();
                startActivity(startActivity);
            }
        });
        RelativeLayout paint = (RelativeLayout) findViewById(R.id.paint);
        paint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startActivity = new Intent(MetroMain.this, Paint_Activity_main.class);
                startActivity(startActivity);
            }
        });

        down_metro_button = (ImageView) findViewById(R.id.down_metro_icon);
        down_metro_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent Startapplauncher = new Intent(MetroMain.this, applauncher.class);
                startActivity(Startapplauncher);
            }
        });

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
