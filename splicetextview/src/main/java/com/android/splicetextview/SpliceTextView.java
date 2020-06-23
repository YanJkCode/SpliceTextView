package com.android.splicetextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

import com.android.splicetextview.state.SpliceGravity;
import com.android.splicetextview.state.SpliceVisibility;
import com.android.splicetextview.utils.ScreenUtil;

import cn.tseeey.justtext.JustTextView;

public class SpliceTextView extends LinearLayout {
    private float textSize;
    private int textColor;
    private int textGravity;

    private CharSequence startText;
    private float startTextSize;
    private int startTextColor;
    private float startLineSpacingExtra;
    private float startLineSpacingMultiplier;
    private int startTextGravity;
    private int startTextVisibility;
    private int startTextStyle;
    private int startMargin;
    private int startMarginLeft;
    private int startMarginRight;
    private int startMarginTop;
    private int startMarginBottom;
    private int startPadding;
    private int startPaddingLeft;
    private int startPaddingRight;
    private int startPaddingTop;
    private int startPaddingBottom;
    private int startBackground;
    private boolean startOpenJustTextView;

    private CharSequence centerText;
    private float centerTextSize;
    private int centerTextColor;
    private float centerLineSpacingExtra;
    private float centerLineSpacingMultiplier;
    private int centerTextGravity;
    private int centerTextVisibility;
    private int centerTextStyle;
    private int centerMargin;
    private int centerMarginLeft;
    private int centerMarginRight;
    private int centerMarginTop;
    private int centerMarginBottom;
    private int centerPadding;
    private int centerPaddingLeft;
    private int centerPaddingRight;
    private int centerPaddingTop;
    private int centerPaddingBottom;
    private int centerBackground;
    private boolean centerOpenJustTextView;

    private CharSequence endText;
    private float endTextSize;
    private int endTextColor;
    private float endLineSpacingExtra;
    private float endLineSpacingMultiplier;
    private int endTextGravity;
    private int endTextVisibility;
    private int endTextStyle;
    private int endMargin;
    private int endMarginLeft;
    private int endMarginRight;
    private int endMarginTop;
    private int endMarginBottom;
    private int endPadding;
    private int endPaddingLeft;
    private int endPaddingRight;
    private int endPaddingTop;
    private int endPaddingBottom;
    private int endBackground;
    private boolean endOpenJustTextView;

    private TextView startTextView;
    private TextView centerTextView;
    private TextView endTextView;

    private boolean isStartTextAdd;
    private boolean isCenterTextAdd;
    private boolean isEndTextAdd;


    public static final int VISIBLE = 1;
    public static final int INVISIBLE = 2;
    public static final int GONE = 3;
    public static final int ALPHA_SHOW = 4;
    public static final int ALPHA_HINT = 5;

    public static final int CENTER = 1;
    public static final int CENTER_VERTICAL = 2;
    public static final int CENTER_HORIZONTAL = 3;
    public static final int RIGHT = 4;

    public static final int BOLD = 1;
    public static final int NORMAL = 2;
    public static final int ITALIC = 3;

    public SpliceTextView(Context context) {
        this(context, null);
    }

    public SpliceTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpliceTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    //初始化
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SpliceTextView);
        if (ta != null) {
            textSize = ScreenUtil.px2dip(context, ta.getDimension(R.styleable.SpliceTextView_textSize, 0));
            textColor = ta.getColor(R.styleable.SpliceTextView_textColor, 0);
            textGravity = ta.getInt(R.styleable.SpliceTextView_textGravity, 0);


            startText = ta.getString(R.styleable.SpliceTextView_startText);
            startTextSize = ScreenUtil.px2dip(context, ta.getDimension(R.styleable.SpliceTextView_startTextSize, 0));
            startLineSpacingExtra = ta.getDimension(R.styleable.SpliceTextView_startLineSpacingExtra, 0);
            startLineSpacingMultiplier = ta.getFloat(R.styleable.SpliceTextView_startLineSpacingMultiplier, 1);
            startTextColor = ta.getColor(R.styleable.SpliceTextView_startTextColor, Color.BLACK);
            startTextGravity = ta.getInt(R.styleable.SpliceTextView_startTextGravity, 0);
            startTextVisibility = ta.getInt(R.styleable.SpliceTextView_startTextVisibility, 0);
            startTextStyle = ta.getInt(R.styleable.SpliceTextView_startTextStyle, 0);
            startOpenJustTextView = ta.getBoolean(R.styleable.SpliceTextView_startOpenJustTextView, true);

            startMargin = (int) ta.getDimension(R.styleable.SpliceTextView_startMargin, 0);
            startMarginLeft = (int) ta.getDimension(R.styleable.SpliceTextView_startMarginLeft, 0);
            startMarginRight = (int) ta.getDimension(R.styleable.SpliceTextView_startMarginRight, 0);
            startMarginTop = (int) ta.getDimension(R.styleable.SpliceTextView_startMarginTop, 0);
            startMarginBottom = (int) ta.getDimension(R.styleable.SpliceTextView_startMarginBottom, 0);

            startPadding = (int) ta.getDimension(R.styleable.SpliceTextView_startPadding, 0);
            startPaddingLeft = (int) ta.getDimension(R.styleable.SpliceTextView_startPaddingLeft, 0);
            startPaddingRight = (int) ta.getDimension(R.styleable.SpliceTextView_startPaddingRight, 0);
            startPaddingTop = (int) ta.getDimension(R.styleable.SpliceTextView_startPaddingTop, 0);
            startPaddingBottom = (int) ta.getDimension(R.styleable.SpliceTextView_startPaddingBottom, 0);

            startBackground = ta.getResourceId(R.styleable.SpliceTextView_startBackground, 0);
            if (startOpenJustTextView) {
                startTextView = new JustTextView(context);
            } else {
                startTextView = new TextView(context);
            }
            initText(startTextView, startLineSpacingExtra, startLineSpacingMultiplier,
                    startTextVisibility, startTextGravity, startTextSize, startTextColor, startBackground, startTextStyle);
            setStartText(startText);


            centerText = ta.getString(R.styleable.SpliceTextView_centerText);
            centerTextSize = ScreenUtil.px2dip(context, ta.getDimension(R.styleable.SpliceTextView_centerTextSize, 0));
            centerLineSpacingExtra = ta.getDimension(R.styleable.SpliceTextView_centerLineSpacingExtra, 0);
            centerLineSpacingMultiplier = ta.getFloat(R.styleable.SpliceTextView_centerLineSpacingMultiplier, 1);
            centerTextColor = ta.getColor(R.styleable.SpliceTextView_centerTextColor, Color.BLACK);
            centerTextGravity = ta.getInt(R.styleable.SpliceTextView_centerTextGravity, 0);
            centerTextVisibility = ta.getInt(R.styleable.SpliceTextView_centerTextVisibility, 0);
            centerTextStyle = ta.getInt(R.styleable.SpliceTextView_centerTextStyle, 0);
            centerOpenJustTextView = ta.getBoolean(R.styleable.SpliceTextView_centerOpenJustTextView, true);


            centerMargin = (int) ta.getDimension(R.styleable.SpliceTextView_centerMargin, 0);
            centerMarginLeft = (int) ta.getDimension(R.styleable.SpliceTextView_centerMarginLeft, 0);
            centerMarginRight = (int) ta.getDimension(R.styleable.SpliceTextView_centerMarginRight, 0);
            centerMarginTop = (int) ta.getDimension(R.styleable.SpliceTextView_centerMarginTop, 0);
            centerMarginBottom = (int) ta.getDimension(R.styleable.SpliceTextView_centerMarginBottom, 0);

            centerPadding = (int) ta.getDimension(R.styleable.SpliceTextView_centerPadding, 0);
            centerPaddingLeft = (int) ta.getDimension(R.styleable.SpliceTextView_centerPaddingLeft, 0);
            centerPaddingRight = (int) ta.getDimension(R.styleable.SpliceTextView_centerPaddingRight, 0);
            centerPaddingTop = (int) ta.getDimension(R.styleable.SpliceTextView_centerPaddingTop, 0);
            centerPaddingBottom = (int) ta.getDimension(R.styleable.SpliceTextView_centerPaddingBottom, 0);

            centerBackground = ta.getResourceId(R.styleable.SpliceTextView_centerBackground, 0);

            if (centerOpenJustTextView) {
                centerTextView = new JustTextView(context);
            } else {
                centerTextView = new TextView(context);
            }
            initText(centerTextView, centerLineSpacingExtra, centerLineSpacingMultiplier,
                    centerTextVisibility, centerTextGravity, centerTextSize, centerTextColor, centerBackground, centerTextStyle);
            setCenterText(centerText);

            endText = ta.getString(R.styleable.SpliceTextView_endText);
            endTextSize = ScreenUtil.px2dip(context, ta.getDimension(R.styleable.SpliceTextView_endTextSize, 0));
            endLineSpacingExtra = ta.getDimension(R.styleable.SpliceTextView_endLineSpacingExtra, 0);
            endLineSpacingMultiplier = ta.getFloat(R.styleable.SpliceTextView_endLineSpacingMultiplier, 1);
            endTextColor = ta.getColor(R.styleable.SpliceTextView_endTextColor, Color.BLACK);
            endTextGravity = ta.getInt(R.styleable.SpliceTextView_endTextGravity, 0);
            endTextVisibility = ta.getInt(R.styleable.SpliceTextView_endTextVisibility, 0);
            endTextStyle = ta.getInt(R.styleable.SpliceTextView_endTextStyle, 0);
            endOpenJustTextView = ta.getBoolean(R.styleable.SpliceTextView_endOpenJustTextView, true);

            endMargin = (int) ta.getDimension(R.styleable.SpliceTextView_endMargin, 0);
            endMarginLeft = (int) ta.getDimension(R.styleable.SpliceTextView_endMarginLeft, 0);
            endMarginRight = (int) ta.getDimension(R.styleable.SpliceTextView_endMarginRight, 0);
            endMarginTop = (int) ta.getDimension(R.styleable.SpliceTextView_endMarginTop, 0);
            endMarginBottom = (int) ta.getDimension(R.styleable.SpliceTextView_endMarginBottom, 0);

            endPadding = (int) ta.getDimension(R.styleable.SpliceTextView_endPadding, 0);
            endPaddingLeft = (int) ta.getDimension(R.styleable.SpliceTextView_endPaddingLeft, 0);
            endPaddingRight = (int) ta.getDimension(R.styleable.SpliceTextView_endPaddingRight, 0);
            endPaddingTop = (int) ta.getDimension(R.styleable.SpliceTextView_endPaddingTop, 0);
            endPaddingBottom = (int) ta.getDimension(R.styleable.SpliceTextView_endPaddingBottom, 0);

            endBackground = ta.getResourceId(R.styleable.SpliceTextView_endBackground, 0);
            if (endOpenJustTextView) {
                endTextView = new JustTextView(context);
            } else {
                endTextView = new TextView(context);
            }
            initText(endTextView, endLineSpacingExtra, endLineSpacingMultiplier,
                    endTextVisibility, endTextGravity, endTextSize, endTextColor, endBackground, endTextStyle);
            setEndText(endText);
        }
        invalidate();
    }

    private void initTextMargin(TextView tv, int margin, int marginLeft, int marginRight, int marginTop, int marginBottom) {
        if (margin != 0 || marginLeft != 0 || marginRight != 0 || marginTop != 0 || marginBottom != 0) {
            LayoutParams layoutParams = (LayoutParams) tv.getLayoutParams();
            layoutParams.setMargins(Math.max(margin, marginLeft), Math.max(margin, marginTop), Math.max(margin, marginRight),
                    Math.max(margin, marginBottom));
            tv.setLayoutParams(layoutParams);
        }
    }

    private void initTextPadding(TextView tv, int padding, int paddingLeft, int paddingRight, int paddingTop, int paddingBottom) {
        if (padding != 0 || paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
            tv.setPadding(Math.max(padding, paddingLeft), Math.max(padding, paddingTop), Math.max(padding, paddingRight),
                    Math.max(padding, paddingBottom));
        }
    }

    private void initText(TextView textView, float lineSpacingExtra, float lineSpacingMultiplier, int textVisibility,
                          int textGravity, float textSize, int textColor, int backgroundRes, int textStyle) {

        //endTextView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 1.0f));
        if (lineSpacingExtra != 0 || lineSpacingMultiplier != 1) {
            textView.setLineSpacing(lineSpacingExtra, lineSpacingMultiplier);
        }
        if (textVisibility != 0) {
            setTextVisibility(textView, textVisibility);
        }
        if (this.textGravity != 0) {
            setTextGravity(textView, this.textGravity);
        } else {
            if (textGravity != 0) {
                setTextGravity(textView, textGravity);
            }
        }
        if (this.textSize != 0) {
            textView.setTextSize(this.textSize);
        } else {
            if (textSize != 0) {
                textView.setTextSize(textSize);
            }
        }
        if (textStyle != 0) {
            setTextStyle(textView, textStyle);
        }

        if (this.textColor != 0) {
            textView.setTextColor(this.textColor);
        } else {
            if (textColor != 0) {
                textView.setTextColor(textColor);
            }
        }

        if (backgroundRes != 0) {
            textView.setBackgroundResource(backgroundRes);
        }
    }

    private void setTextGravity(TextView tv, @SpliceGravity int type) {
        if (tv != null)
            switch (type) {
                case CENTER:
                    tv.setGravity(Gravity.CENTER);
                    break;
                case CENTER_VERTICAL:
                    tv.setGravity(Gravity.CENTER_VERTICAL);
                    break;
                case CENTER_HORIZONTAL:
                    tv.setGravity(Gravity.CENTER_HORIZONTAL);
                    break;
                case RIGHT:
                    tv.setGravity(Gravity.RIGHT);
                    break;
            }
    }

    private void setTextVisibility(TextView tv, @SpliceVisibility int type) {
        if (tv != null)
            switch (type) {
                case VISIBLE:
                    tv.setVisibility(View.VISIBLE);
                    break;
                case INVISIBLE:
                    tv.setVisibility(View.INVISIBLE);
                    break;
                case GONE:
                    tv.setVisibility(View.GONE);
                    break;
                case ALPHA_SHOW:
                    tv.setAlpha(1);
                    break;
                case ALPHA_HINT:
                    tv.setAlpha(0);
                    break;
            }
    }

    private void setTextStyle(TextView tv, int style) {
        if (tv != null)
            switch (style) {
                case BOLD:
                    tv.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
                    break;
                case NORMAL:
                    tv.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//常规
                    break;
                case ITALIC:
                    tv.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));//斜体
                    break;
            }
    }

    public void setTextSize(float textSize) {
        if (textSize >= 0) {
            this.textSize = textSize;
            if (startTextView != null) {
                startTextView.setTextSize(textSize);
            }
            if (centerTextView != null) {
                centerTextView.setTextSize(textSize);
            }
            if (endTextView != null) {
                endTextView.setTextSize(textSize);
            }
        }
    }

    public void setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
        if (startTextView != null) {
            startTextView.setTextColor(textColor);
        }
        if (centerTextView != null) {
            centerTextView.setTextColor(textColor);
        }
        if (endTextView != null) {
            endTextView.setTextColor(textColor);
        }
    }

    public void setStartText(CharSequence startText) {
        if (!TextUtils.isEmpty(startText) && startTextView != null) {
            this.startText = startText;
            startTextView.setText(startText);
            if (!isStartTextAdd) {
                isStartTextAdd = true;
                addView(startTextView, 0);
                initTextMargin(startTextView, startMargin, startMarginLeft, startMarginRight, startMarginTop, startMarginBottom);
                initTextPadding(startTextView, startPadding, startPaddingLeft, startPaddingRight, startPaddingTop, startPaddingBottom);
            }
        }
    }

    public void setStartTextSize(float startTextSize) {
        if (startTextSize >= 0 && startTextView != null) {
            this.startTextSize = startTextSize;
            startTextView.setTextSize(startTextSize);
        }
    }

    public void setStartTextColor(@ColorInt int startTextColor) {
        if (startTextView != null) {
            this.startTextColor = startTextColor;
            startTextView.setTextColor(startTextColor);
        }
    }


    public void setCenterText(CharSequence centerText) {
        if (!TextUtils.isEmpty(centerText) && centerTextView != null) {
            this.centerText = centerText;
            centerTextView.setText(centerText);
            if (!isCenterTextAdd) {
                isCenterTextAdd = true;
                if (isStartTextAdd) {
                    addView(centerTextView, 1);
                } else if (isEndTextAdd) {
                    addView(centerTextView, 0);
                } else {
                    addView(centerTextView);
                }
                initTextMargin(centerTextView, centerMargin, centerMarginLeft, centerMarginRight, centerMarginTop, centerMarginBottom);
                initTextPadding(centerTextView, centerPadding, centerPaddingLeft, centerPaddingRight, centerPaddingTop,
                        centerPaddingBottom);
            }
        }
    }

    public void setCenterTextSize(float centerTextSize) {
        if (centerTextSize >= 0 && centerTextView != null) {
            this.centerTextSize = centerTextSize;
            centerTextView.setTextSize(centerTextSize);
        }
    }

    public void setCenterTextColor(@ColorInt int centerTextColor) {
        if (centerTextView != null) {
            this.centerTextColor = centerTextColor;
            centerTextView.setTextColor(centerTextColor);
        }
    }

    public void setEndText(CharSequence endText) {
        if (!TextUtils.isEmpty(endText) && endTextView != null) {
            this.endText = endText;
            endTextView.setText(endText);
            if (!isEndTextAdd) {
                isEndTextAdd = true;
                if (isStartTextAdd && isCenterTextAdd) {
                    addView(endTextView);
                } else if (!isStartTextAdd && isCenterTextAdd) {
                    addView(endTextView, 1);
                } else {
                    addView(endTextView);
                }
                initTextMargin(endTextView, endMargin, endMarginLeft, endMarginRight, endMarginTop, endMarginBottom);
                initTextPadding(endTextView, endPadding, endPaddingLeft, endPaddingRight, endPaddingTop, endPaddingBottom);
            }
        }
    }

    public void setEndTextSize(float endTextSize) {
        if (endTextSize >= 0 && endTextView != null) {
            this.endTextSize = endTextSize;
            endTextView.setTextSize(endTextSize);
        }
    }

    public void setEndTextColor(@ColorInt int endTextColor) {
        if (endTextView != null) {
            this.endTextColor = endTextColor;
            endTextView.setTextColor(endTextColor);
        }
    }

    public void setStartTextVisibility(@SpliceVisibility int startTextVisibility) {
        this.startTextVisibility = startTextVisibility;
        setTextVisibility(startTextView, startTextVisibility);
    }

    public void setCenterTextVisibility(@SpliceVisibility int centerTextVisibility) {
        this.centerTextVisibility = centerTextVisibility;
        setTextVisibility(centerTextView, centerTextVisibility);
    }


    public void setEndTextVisibility(@SpliceVisibility int endTextVisibility) {
        this.endTextVisibility = endTextVisibility;
        setTextVisibility(endTextView, endTextVisibility);
    }

    public void setStartTextGravity(@SpliceGravity int startTextGravity) {
        this.startTextGravity = startTextGravity;
        setTextGravity(startTextView, startTextGravity);
    }

    public void setCenterTextGravity(@SpliceGravity int centerTextGravity) {
        this.centerTextGravity = centerTextGravity;
        setTextGravity(centerTextView, centerTextGravity);
    }

    public void setEndTextGravity(@SpliceGravity int endTextGravity) {
        this.endTextGravity = endTextGravity;
        setTextGravity(endTextView, endTextGravity);
    }

    public void setTextGravity(@SpliceGravity int textGravity) {
        this.textGravity = textGravity;
        setTextGravity(startTextView, textGravity);
        setTextGravity(centerTextView, textGravity);
        setTextGravity(endTextView, textGravity);
    }

    public void setStartTextAlpha(float alpha) {
        if (startTextView != null && alpha >= 0)
            startTextView.setAlpha(alpha);
    }

    public void setCenterTextAlpha(float alpha) {
        if (centerTextView != null && alpha >= 0)
            centerTextView.setAlpha(alpha);
    }

    public void setEndTextAlpha(float alpha) {
        if (endTextView != null && alpha >= 0)
            endTextView.setAlpha(alpha);
    }

    public void setStartLineSpacingExtra(int startLineSpacingExtra) {
        this.startLineSpacingExtra = startLineSpacingExtra;
        if (startTextView != null && startLineSpacingExtra >= 0)
            startTextView.setTextScaleX(startLineSpacingExtra);
    }

    public void setCenterLineSpacingExtra(int centerLineSpacingExtra) {
        this.centerLineSpacingExtra = centerLineSpacingExtra;
        if (centerTextView != null && centerLineSpacingExtra >= 0)
            centerTextView.setTextScaleX(centerLineSpacingExtra);
    }

    public void setEndLineSpacingExtra(int endLineSpacingExtra) {
        this.endLineSpacingExtra = endLineSpacingExtra;
        if (endTextView != null && endLineSpacingExtra >= 0)
            endTextView.setTextScaleX(endLineSpacingExtra);
    }

    public void setStartTextMargin(int left, int top, int right, int bottom) {
        if (startTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LayoutParams) startTextView.getLayoutParams();
            layoutParams.setMargins(left, top, right, bottom);
            startTextView.setLayoutParams(layoutParams);
        }
    }

    public void setCenterTextMargin(int left, int top, int right, int bottom) {
        if (centerTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LayoutParams) centerTextView.getLayoutParams();
            layoutParams.setMargins(left, top, right, bottom);
            centerTextView.setLayoutParams(layoutParams);
        }
    }

    public void setEndTextMargin(int left, int top, int right, int bottom) {
        if (endTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LayoutParams) endTextView.getLayoutParams();
            layoutParams.setMargins(left, top, right, bottom);
            endTextView.setLayoutParams(layoutParams);
        }
    }

    public void setStartTextPadding(int left, int top, int right, int bottom) {
        if (startTextView != null) {
            startTextView.setPadding(left, top, right, bottom);
        }
    }

    public void setCenterTextPadding(int left, int top, int right, int bottom) {
        if (centerTextView != null) {
            centerTextView.setPadding(left, top, right, bottom);
        }
    }

    public void setEndTextPadding(int left, int top, int right, int bottom) {
        if (endTextView != null) {
            endTextView.setPadding(left, top, right, bottom);
        }
    }


    public void setStartBackground(@DrawableRes int startBackground) {
        this.startBackground = startBackground;
        if (startTextView != null) {
            startTextView.setBackgroundResource(startBackground);
        }
    }

    public void setCenterBackground(@DrawableRes int centerBackground) {
        this.centerBackground = centerBackground;
        if (centerTextView != null) {
            centerTextView.setBackgroundResource(centerBackground);
        }
    }

    public void setEndBackground(@DrawableRes int endBackground) {
        this.endBackground = endBackground;
        if (endTextView != null) {
            endTextView.setBackgroundResource(endBackground);
        }
    }

    public TextView getStartTextView() {
        return startTextView;
    }

    public TextView getCenterTextView() {
        return centerTextView;
    }

    public TextView getEndTextView() {
        return endTextView;
    }
}
