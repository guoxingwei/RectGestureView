package text.mycheckdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.AnimatorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import text.mycheckdemo.weight.AnimPointView;

public class ShowAnimationActivity extends AppCompatActivity {

    private ImageView imgview;
    private TextView tv_ShowAnim,tv_ShowValueAnim;

    private AnimPointView pointView;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_animation);

        imgview = findViewById(R.id.img);
        tv_ShowAnim = findViewById(R.id.tv_ShowAnim);
        tv_ShowValueAnim = findViewById(R.id.tv_ShowValueAnim);
        pointView = findViewById(R.id.potintView);

        context = this;


        tv_ShowAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                @SuppressLint("ObjectAnimatorBinding")
                ObjectAnimator animator = ObjectAnimator.ofInt(pointView, "pointRadius", 0, 300, 100);
                animator.setDuration(2000);
                animator.start();

                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Log.e("AnimValue","----->"+animation.getAnimatedValue());
                    }
                });
            }
        });

        tv_ShowValueAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimotor();
            }
        });
    }

    private void doAnimotor(){
        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.setDuration(1000);
        animator.start();


        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                tv_ShowValueAnim.layout(
                        curValue,curValue,curValue+tv_ShowValueAnim.getWidth(),
                        curValue+tv_ShowValueAnim.getHeight());
            }
        });
    }
}
