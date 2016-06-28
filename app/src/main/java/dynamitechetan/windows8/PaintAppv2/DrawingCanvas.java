package dynamitechetan.windows8.PaintAppv2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingCanvas extends View {

    String utensil = "pen";
    Paint erasorPaint;
    String color = "black";
    String oldColor;
    boolean up = false;
    ArrayList<Integer> xArray = new ArrayList<Integer>();
    ArrayList<Integer> yArray = new ArrayList<Integer>();
    ArrayList<String> utensilArray = new ArrayList<String>();
    ArrayList<String> colorArray = new ArrayList<String>();
    ArrayList<Integer> thicknessArray = new ArrayList<Integer>();


    Paint paint;
    float startX = 0;
    float startY = 0;
    float stopX;
    float stopY;

    public DrawingCanvas(Context context) {
        super(context);

        Utensil pen = new Pen();
        paint = new Paint();
        erasorPaint = new Paint();
        erasorPaint.setColor(Color.WHITE);
        Utensil paintBrush = new PaintBrush();
        Utensil highlighter = new Highlighter();
        Utensil bucket = new Bucket();


    }

    public void changeUtensil(String utensil) {
        this.utensil = utensil;
    }

    public void changeColor(String color) {
        this.color = color;
        System.out.println("::::::::::::::: " + this.color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();

        canvas.drawColor(Color.WHITE);
        for (int x = 0; x < xArray.size() - 1; x++) {

            if (colorArray.get(x).equals("transparent")) {
                paint.setColor(Color.TRANSPARENT);
            } else if (colorArray.get(x).equals("black")) {
                paint.setColor(Color.BLACK);
            } else if (colorArray.get(x).equals("green")) {
                paint.setColor(Color.GREEN);
            } else if (colorArray.get(x).equals("blue")) {
                paint.setColor(Color.BLUE);
            } else {
                paint.setColor(Color.BLACK);
            }
            if (utensilArray.get(x).equals("pen")) {
                canvas.drawLine(xArray.get(x + 1), yArray.get(x + 1), xArray.get(x), yArray.get(x), paint);
                canvas.drawLine(xArray.get(x + 1) + 1, yArray.get(x + 1) + 1, xArray.get(x) + 1, yArray.get(x) + 1, paint);
            } else if (utensilArray.get(x).equals("highlighter")) {
                paint.setColor(Color.YELLOW);
                canvas.drawLine(xArray.get(x + 1), yArray.get(x + 1), xArray.get(x), yArray.get(x), paint);
                canvas.drawLine(xArray.get(x + 1) + 1, yArray.get(x + 1), xArray.get(x) + 1, yArray.get(x), paint);
                canvas.drawLine(xArray.get(x + 1) + 2, yArray.get(x + 1), xArray.get(x) + 2, yArray.get(x), paint);
                canvas.drawLine(xArray.get(x + 1) + 3, yArray.get(x + 1), xArray.get(x) + 3, yArray.get(x), paint);
                canvas.drawLine(xArray.get(x + 1) - 1, yArray.get(x + 1), xArray.get(x) - 1, yArray.get(x), paint);
                canvas.drawLine(xArray.get(x + 1) - 2, yArray.get(x + 1), xArray.get(x) - 2, yArray.get(x), paint);
            } else if (utensil.equals("paint")) {

            } else if (utensil.equals("erasor")) {
                canvas.drawCircle(xArray.get(x), yArray.get(x), 10, erasorPaint);
            }
        }


        canvas.restore();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if (event.getAction() == MotionEvent.ACTION_UP) {
            System.out.println("UP");
            oldColor = color;
            color = "transparent";
            up = true;
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            System.out.println("DOWN");
            if (color.equals("transparent")) {
                color = oldColor;
            }
            up = false;
        }

        stopX = startX;
        stopY = startY;

        startX = event.getX();
        startY = event.getY();

        //when finger is let go, adds two 0s so onDaw() method knows to make the next line transparent
        if (up == false) { //if finger is down
            System.out.println("THE COLOR ISSSSS " + color);
            //color="black";
        }
        AddCoordinatestoArray();
        AddUtensiltoArray();
        AddColortoArray();
        AddThicknesstoArray();


        System.out.println("x " + startX);
        System.out.println("y " + startY);
        invalidate();
        return true;
    }

    public void AddCoordinatestoArray() {

        xArray.add((int) startX);
        yArray.add((int) startY);
    }

    public void AddUtensiltoArray() {
        if (utensil.equals("pen")) {
            utensilArray.add("pen");
        } else if (utensil.equals("highlighter")) {
            utensilArray.add("highlighter");
        } else if (utensil.equals("paint")) {
            utensilArray.add("paint");
        } else if (utensil.equals("erasor")) {
            utensilArray.add("erasor");
        }
    }

    public void AddColortoArray() {
        if (color.equals("black")) {
            colorArray.add("black");
        } else if (color.equals("transparent")) {
            colorArray.add("transparent");
        } else if (color.equals("white")) {
            colorArray.add("white");
        } else if (color.equals("blue")) {
            colorArray.add("blue");
        } else if (color.equals("green")) {
            System.out.println("'''''''''' ITISGREEN");
            colorArray.add("green");
        } else {
            colorArray.add("black");
        }

    }

    public void AddThicknesstoArray() {

    }
}
