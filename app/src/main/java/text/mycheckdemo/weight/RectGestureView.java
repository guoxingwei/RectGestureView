package text.mycheckdemo.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jh on 2018/3/1.
 */

public class RectGestureView extends View {

    private Paint paint;
    private int StrokeWidth = 5;

    private Rect rect = new Rect(0, 0, 0, 0);

    private int leftSize,rightSize,topSize,bottomSize;


    public RectGestureView(Context context) {
        super(context);
        intMeasure();
    }

    public RectGestureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        intMeasure();
    }

    public RectGestureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intMeasure();
    }

    //测量尺寸
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    //绘制控件
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAntiAlias(true);
        canvas.drawARGB(50, 255, 227, 0);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(StrokeWidth);
        paint.setColor(Color.RED);
        paint.setAlpha(100);
        canvas.drawRect(rect, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                invalidate();
                leftSize = rightSize = x;
                topSize = bottomSize = y;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                rect.set(
                        Math.min(leftSize,rightSize),
                        Math.min(topSize,bottomSize),
                        Math.max(leftSize,rightSize),
                        Math.max(topSize,bottomSize)
                );
                rightSize= x;
                bottomSize = y;
                invalidate(rect);
                break;
        }
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    private void intMeasure() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }
}
