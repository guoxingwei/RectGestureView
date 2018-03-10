package text.mycheckdemo.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import bean.Point;

/**
 * Created by jh on 2018/3/5.
 */

public class AnimPointView extends View{

    private Point mPoint = new Point(100);
    private Paint paint = new Paint();

    public AnimPointView(Context context) {
        super(context);
    }

    public AnimPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AnimPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    @Override
    protected void onDraw(Canvas canvas) {
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mPoint.getPointRadius(),paint);
        super.onDraw(canvas);
    }


    public int getPointRadius(){
        return 50;
    }

    public void setPointRadius(int radius){
        mPoint.setPointRadius(radius);
        invalidate();
    }
}
