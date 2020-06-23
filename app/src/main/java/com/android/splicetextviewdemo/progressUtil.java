package com.android.splicetextviewdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedList;

public class progressUtil {
    /**
     * 空闲的动画集合
     */
    private static LinkedList<ValueAnimator> sleisureValueAnimators = new LinkedList<>();
    /**
     * 运行中的动画集合
     */
    private static LinkedList<ValueAnimator> sStartValueAnimators = new LinkedList<>();
    /**
     * 回收动画 复用
     */
    private static AnimatorListenerAdapter recycleAnimListener = new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            if (animation instanceof ValueAnimator) {
                sStartValueAnimators.remove(animation);
                sleisureValueAnimators.add((ValueAnimator) animation);
            }
        }

        @Override
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
            if (animation instanceof ValueAnimator) {
                sStartValueAnimators.add((ValueAnimator) animation);
            }
        }
    };

    /**
     * @param tv
     * @param formatStr
     * @param start
     * @param end
     * @param duration
     */
    public static void fromToTarget(final TextView tv, final String formatStr, int start, int end, int duration) {
        ValueAnimator valueAnimator;
        if (sleisureValueAnimators.size() > 0) {
            valueAnimator = sleisureValueAnimators.getLast();
            valueAnimator.setFloatValues(start, end);
        } else {
            valueAnimator = ValueAnimator.ofFloat(start, end);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float target = (float) animation.getAnimatedValue();
                tv.setText(String.format(formatStr, target));
            }
        });
        valueAnimator.setDuration(duration);
        valueAnimator.addListener(recycleAnimListener);
        valueAnimator.start();
    }


    public static void fromToTarget(final TextView tv, int start, int end, int duration) {
        ValueAnimator valueAnimator;
        if (sleisureValueAnimators.size() > 0) {
            valueAnimator = sleisureValueAnimators.getLast();
            valueAnimator.setFloatValues(start, end);
        } else {
            valueAnimator = ValueAnimator.ofFloat(start, end);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float target = (float) animation.getAnimatedValue();
                tv.setText(target + "");
            }
        });
        valueAnimator.setDuration(duration);
        valueAnimator.addListener(recycleAnimListener);
        valueAnimator.start();
    }

    public static void fromToTarget(final ProgressBar progressBar, int start, int end, int duration) {
        ValueAnimator valueAnimator;
        if (sleisureValueAnimators.size() > 0) {
            valueAnimator = sleisureValueAnimators.getLast();
            valueAnimator.setFloatValues(start, end);
        } else {
            valueAnimator = ValueAnimator.ofFloat(start, end);
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float target = (float) animation.getAnimatedValue();
                progressBar.setProgress((int) target);
            }
        });
        valueAnimator.setDuration(duration);
        valueAnimator.addListener(recycleAnimListener);
        valueAnimator.start();
    }

    public static ValueAnimator getProgressAnim(int start, int end, int duration) {
        ValueAnimator valueAnimator;
        if (sleisureValueAnimators.size() > 0) {
            valueAnimator = sleisureValueAnimators.getLast();
            valueAnimator.setFloatValues(start, end);
        } else {
            valueAnimator = ValueAnimator.ofFloat(start, end);
        }
        valueAnimator.setDuration(duration);
        valueAnimator.addListener(recycleAnimListener);
        return valueAnimator;
    }

    public static final int SHOW = 1;
    public static final int HINT = 0;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({progressUtil.SHOW, progressUtil.HINT})
    public @interface AlphaState {
    }

    public static ValueAnimator getAlphaAnim(@AlphaState int state, int duration) {
        int start = 0, end = 0;
        switch (state) {
            case SHOW:
                start = 0;
                end = 1;
                break;
            case HINT:
                start = 1;
                end = 0;
                break;
        }
        ValueAnimator valueAnimator;
        if (sleisureValueAnimators.size() > 0) {
            valueAnimator = sleisureValueAnimators.getLast();
            valueAnimator.setFloatValues(start, end);
        } else {
            valueAnimator = ValueAnimator.ofFloat(start, end);
        }
        valueAnimator.setDuration(duration);
        valueAnimator.addListener(recycleAnimListener);
        return valueAnimator;
    }
}
