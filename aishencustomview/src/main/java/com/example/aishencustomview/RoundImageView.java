package com.example.aishencustomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

/**
 * Created by Administrator on 2015/9/29.
 */
public class RoundImageView extends ImageView{
    private int type;
    private static final int TYPE_CIRCLE = 0;
    private static final int BORDER_RADIUS_DEFAULT= 1 ;
    private int mBorderRadius;
    private Paint mBitmapPaint;
    private int mRadius;
    private BitmapShader mBitmapShader;
    private int mWidth;
    private RectF mRoundRect;
    private Matrix mMatrix;
    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mMatrix = new Matrix();
        mBitmapPaint = new Paint();
        mBitmapPaint.setAntiAlias(true);
//        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.RoundImageView);
//        mBorderRadius = typedArray.getDimensionPixelSize(R.styleable.RoundImageView_borderRadius, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,BORDER_RADIUS_DEFAULT,getResources().getDisplayMetrics()));
//        type = typedArray.getInt(R.styleable.RoundImageView_type,TYPE_CIRCLE);
//        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (type == TYPE_CIRCLE){
            mWidth = Math.min(getMeasuredWidth(),getMeasuredHeight());
            mRadius = mWidth / 2;
            setMeasuredDimension(mWidth,mWidth);
        }
    }
    private void setUpShader(){
        Drawable drawable = getDrawable();
        if (drawable == null){
            return;
        }
        Bitmap bitmap = drawableToBitmap(drawable);
        mBitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        float scale = 1.0f;
        if (type == TYPE_CIRCLE){
            int bSize = Math.min(bitmap.getWidth(),bitmap.getHeight());
            scale = mWidth*1.0f/bSize;
        }
        mMatrix.setScale(scale,scale);
        mBitmapShader.setLocalMatrix(mMatrix);
        mBitmapPaint.setShader(mBitmapShader);
    }
    private Bitmap drawableToBitmap(Drawable drawable){
        if (drawable instanceof BitmapDrawable){
            BitmapDrawable bd = (BitmapDrawable) drawable;
            return bd.getBitmap();
        }
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getDrawable() == null){
            return;
        }
        setUpShader();
        if (type == TYPE_CIRCLE){
            canvas.drawCircle(mRadius,mRadius,mRadius,mBitmapPaint);
        }
    }
}
