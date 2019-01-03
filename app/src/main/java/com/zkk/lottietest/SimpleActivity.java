package com.zkk.lottietest;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

/**
 */
public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_simple.xml中 lottie_fileName="data.json"
        // 所以只需要在 app/src/main/assets 中添加AE 生成的 json文件，重命名为data.json就可以显示动画
        setContentView(R.layout.activity_simple);
        final LottieAnimationView animation_view = findViewById(R.id.animation_view);
        animation_view.setAnimation("icondonxiao.json");
//        animation_view.setImageAssetsFolder("images");
//        animation_view.setRepeatMode();
        ValueAnimator animator = ValueAnimator.ofFloat(0f,1.0f);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animation_view.setProgress((Float.valueOf(animation.getAnimatedValue().toString())));
            }
        });
        animator.start();
    }
}
