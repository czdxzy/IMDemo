package com.example.aishencustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * Created by Administrator on 2015/9/29.
 */
public class CustomView extends View implements Runnable{
    private Paint paint;
    private Context context;
    private int radiu;
    private int roundColor;
    private int style;
    public CustomView(Context context) {
        super(context);
    }

    private void initPaint() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(roundColor);
        paint.setStrokeWidth(10);
        switch (style){
            case 1:
                paint.setStyle(Paint.Style.FILL);
                break;
            case 0:
                paint.setStyle(Paint.Style.STROKE);
        }
    }

//    public CustomView(Context context, AttributeSet attrs) {
//        this(context,attrs,0);
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DisplayMetrics metric = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metric);
        canvas.drawCircle(metric.widthPixels / 2, metric.heightPixels / 2, radiu, paint);
    }
    public synchronized void setRadiu(int radiu){
        this.radiu = radiu;
        invalidate();
    }

    @Override
    public void run() {
        while (true){
            if (radiu<=200){
                radiu += 10;
                postInvalidate();
            }else {
                radiu = 0;
            }
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        this.context = context;
//        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomView);
//        roundColor = typedArray.getColor(R.styleable.CustomView_roundcolor,Color.RED);
//        style = typedArray.getInt(R.styleable.CustomView_style, 0);
//        typedArray.recycle();
//        initPaint();
//    }
}
