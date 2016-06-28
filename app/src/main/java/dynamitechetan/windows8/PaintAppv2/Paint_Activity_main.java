package dynamitechetan.windows8.PaintAppv2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import dynamitechetan.windows8.R;

public class Paint_Activity_main extends Activity implements OnClickListener {


    Button penButton;
    Button highlighterButton;
    Button paintButton;
    Button erasorButton;
    EditText textView;
    DrawingCanvas canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("1111111");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paint_activity_main);

        canvas = new DrawingCanvas(this);
        System.out.println("2222222222");

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout1);
        System.out.println("3333333333");


        System.out.println("444444444");

        layout.addView(canvas);

        penButton = (Button) findViewById(R.id.penButton);
        highlighterButton = (Button) findViewById(R.id.highlighterButton);
        paintButton = (Button) findViewById(R.id.paintButton);
        erasorButton = (Button) findViewById(R.id.erasorButton);
        textView = (EditText) findViewById(R.id.text);

        penButton.setOnClickListener(this);
        highlighterButton.setOnClickListener(this);
        paintButton.setOnClickListener(this);
        erasorButton.setOnClickListener(this);
        textView.setOnClickListener(this);


        System.out.println("55555555");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void onClick(View v) {
        //System.out.println("YEAA");
        if (v.getId() == R.id.penButton) {
            canvas.changeUtensil("pen");
            System.out.println("pen");
        } else if (v.getId() == R.id.highlighterButton) {
            canvas.changeUtensil("highlighter");
            System.out.println("highlighter");

        } else if (v.getId() == R.id.paintButton) {
            canvas.changeUtensil("paint");
            System.out.println("paint");
        } else if (v.getId() == R.id.erasorButton) {
            canvas.changeUtensil("erasor");
        } else if (v.getId() == R.id.text) {
            System.out.println("TEXT" + textView.getText().toString());
            canvas.changeColor(textView.getText().toString());
        }
    }


}
