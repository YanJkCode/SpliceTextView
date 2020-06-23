package com.android.splicetextviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.splicetextview.SpliceTextView;

public class MainActivity extends AppCompatActivity {

    private SpliceTextView mViewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewById = findViewById(R.id.text);
        setStvAlohaProgress(mViewById, progressUtil.getAlphaAnim(progressUtil.SHOW, 2000));
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewById.setStartText("111111111111111111");
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewById.setCenterText("22222222222222");
            }
        });
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewById.setEndText("33333333333333");
            }
        });

        //DragFloatButton dragFloatButton = findViewById(R.id.texas);
        //dragFloatButton.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
        //    }
        //});
    }

    private void setStvAlohaProgress(final SpliceTextView stv, ValueAnimator alphaAnimator) {
        alphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float target = (float) animation.getAnimatedValue();
                stv.setEndTextAlpha(target);
            }
        });
        alphaAnimator.start();
    }
}
