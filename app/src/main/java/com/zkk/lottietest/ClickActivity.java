package com.zkk.lottietest;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;

/**
 */
public class ClickActivity extends AppCompatActivity {

    private Button button1, button2;
    private TextView tv_seek;
    LottieAnimationView animation_view_click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);

        animation_view_click = findViewById(R.id.animation_view_click);
        tv_seek = findViewById(R.id.tv_seek);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startAnima();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopAnima();
            }
        });
        LottieComposition.Factory.fromAssetFileName(this, "data1.json", new OnCompositionLoadedListener() {

            @Override
            public void onCompositionLoaded(LottieComposition composition) {
                animation_view_click.setComposition(composition);
                animation_view_click.setProgress(0.333f);
                animation_view_click.playAnimation();
            }
        });


        animation_view_click.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                tv_seek.setText((" 动画进度" + (int) (animation.getAnimatedFraction() * 100) + "%"));
            }
        });
    }

    /*
     * 开始动画
     */
    private void startAnima() {

        boolean inPlaying = animation_view_click.isAnimating();
        if (!inPlaying) {
            animation_view_click.setProgress(0f);
            animation_view_click.playAnimation();
        }
    }

    /*
     * 停止动画
     */
    private void stopAnima() {
        boolean inPlaying = animation_view_click.isAnimating();
        if (inPlaying) {
            animation_view_click.cancelAnimation();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        animation_view_click.cancelAnimation();
    }

}
