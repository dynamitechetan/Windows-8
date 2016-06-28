package dynamitechetan.windows8.Apps;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import dynamitechetan.windows8.R;

public class InternetExplorer extends AppCompatActivity {
    TextView ed1;
    WebView wv1;
    ImageView back;
    ImageView front;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FullScreencall();

        setContentView(R.layout.activity_internet_explorer);


        ImageView b1 = (ImageView) findViewById(R.id.arrow);
        ed1 = (TextView) findViewById(R.id.editText);

        back = (ImageView) findViewById(R.id.back);
        front = (ImageView) findViewById(R.id.front);

        wv1 = (WebView) findViewById(R.id.internet);
        wv1.canGoBack();
        wv1.canGoForward();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv1.goBack();
            }
        });
        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wv1.goForward();
            }
        });
        wv1.setWebViewClient(new WebViewClient());
        wv1.zoomOut();
        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        wv1.loadUrl("https://www.google.co.in/?gws_rd=ssl");
        ed1.setText("INTERNET EXPLORER LITE");

    }


//        wv1.getSettings().setLoadsImagesAutomatically(true);
//        wv1.getSettings().setJavaScriptEnabled(true);
//        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//
//        wv1.loadUrl("https://www.google.co.in/?gws_rd=ssl");


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
