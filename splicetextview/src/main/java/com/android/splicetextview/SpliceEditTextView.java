package com.android.splicetextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;

import com.android.splicetextview.state.SpliceGravity;
import com.android.splicetextview.state.SpliceVisibility;
import com.android.splicetextview.utils.ScreenUtil;

public class SpliceEditTextView extends LinearLayout {
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
    private int startTextMaxLength;
    private int startTextMaxLines;
    private String startTextTypefaceNmae;

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
    private CharSequence centerHintText;
    private int centerHintTextColor;
    private int centerTextMaxLength;
    private int centerTextMaxLines;
    private String centerTextTypefaceNmae;

    private TextView startTextView;
    private EditText centerTextView;

    private boolean isStartTextAdd;
    private boolean isCenterTextAdd;


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

    public SpliceEditTextView(Context context) {
        this(context, null);
    }

    public SpliceEditTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpliceEditTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    //初始化
    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SpliceEditTextView);
        if (ta != null) {
            textSize = ScreenUtil.px2dip(context, ta.getDimension(R.styleable.SpliceEditTextView_textSize, 0));
            textColor = ta.getColor(R.styleable.SpliceEditTextView_textColor, 0);
            textGravity = ta.getInt(R.styleable.SpliceEditTextView_textGravity, 0);


            startText = ta.getString(R.styleable.SpliceEditTextView_startText);
            startTextSize = ScreenUtil.px2dip(context, ta.getDimension(R.styleable.SpliceEditTextView_startTextSize, 0));
            startLineSpacingExtra = ta.getDimension(R.styleable.SpliceEditTextView_startLineSpacingExtra, 0);
            startLineSpacingMultiplier = ta.getFloat(R.styleable.SpliceEditTextView_startLineSpacingMultiplier, 1);
            startTextColor = ta.getColor(R.styleable.SpliceEditTextView_startTextColor, Color.BLACK);
            startTextGravity = ta.getInt(R.styleable.SpliceEditTextView_startTextGravity, 0);
            startTextVisibility = ta.getInt(R.styleable.SpliceEditTextView_startTextVisibility, 0);
            startTextStyle = ta.getInt(R.styleable.SpliceEditTextView_startTextStyle, 0);

            startMargin = (int) ta.getDimension(R.styleable.SpliceEditTextView_startMargin, 0);
            startMarginLeft = (int) ta.getDimension(R.styleable.SpliceEditTextView_startMarginLeft, 0);
            startMarginRight = (int) ta.getDimension(R.styleable.SpliceEditTextView_startMarginRight, 0);
            startMarginTop = (int) ta.getDimension(R.styleable.SpliceEditTextView_startMarginTop, 0);
            startMarginBottom = (int) ta.getDimension(R.styleable.SpliceEditTextView_startMarginBottom, 0);

            startPadding = (int) ta.getDimension(R.styleable.SpliceEditTextView_startPadding, 0);
            startPaddingLeft = (int) ta.getDimension(R.styleable.SpliceEditTextView_startPaddingLeft, 0);
            startPaddingRight = (int) ta.getDimension(R.styleable.SpliceEditTextView_startPaddingRight, 0);
            startPaddingTop = (int) ta.getDimension(R.styleable.SpliceEditTextView_startPaddingTop, 0);
            startPaddingBottom = (int) ta.getDimension(R.styleable.SpliceEditTextView_startPaddingBottom, 0);
            startTextMaxLength = ta.getInt(R.styleable.SpliceEditTextView_startTextMaxLength, 0);
            startTextMaxLines = ta.getInt(R.styleable.SpliceEditTextView_startTextMaxLines, 0);

            startTextTypefaceNmae = ta.getString(R.styleable.SpliceEditTextView_startTextTypefaceNmae);

            startBackground = ta.getResourceId(R.styleable.SpliceEditTextView_startBackground, 0);


            startTextView = new TextView(context);
            setStartText(startText);


            centerText = ta.getString(R.styleable.SpliceEditTextView_centerText);
            centerTextSize = ScreenUtil.px2dip(context, ta.getDimension(R.styleable.SpliceEditTextView_centerTextSize, 0));
            centerLineSpacingExtra = ta.getDimension(R.styleable.SpliceEditTextView_centerLineSpacingExtra, 0);
            centerLineSpacingMultiplier = ta.getFloat(R.styleable.SpliceEditTextView_centerLineSpacingMultiplier, 1);
            centerTextColor = ta.getColor(R.styleable.SpliceEditTextView_centerTextColor, Color.BLACK);
            centerTextGravity = ta.getInt(R.styleable.SpliceEditTextView_centerTextGravity, 0);
            centerTextVisibility = ta.getInt(R.styleable.SpliceEditTextView_centerTextVisibility, 0);
            centerTextStyle = ta.getInt(R.styleable.SpliceEditTextView_centerTextStyle, 0);

            centerMargin = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerMargin, 0);
            centerMarginLeft = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerMarginLeft, 0);
            centerMarginRight = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerMarginRight, 0);
            centerMarginTop = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerMarginTop, 0);
            centerMarginBottom = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerMarginBottom, 0);

            centerPadding = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerPadding, 0);
            centerPaddingLeft = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerPaddingLeft, 0);
            centerPaddingRight = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerPaddingRight, 0);
            centerPaddingTop = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerPaddingTop, 0);
            centerPaddingBottom = (int) ta.getDimension(R.styleable.SpliceEditTextView_centerPaddingBottom, 0);

            centerBackground = ta.getResourceId(R.styleable.SpliceEditTextView_centerBackground, 0);

            centerHintText = ta.getString(R.styleable.SpliceEditTextView_centerHintText);
            centerHintTextColor = ta.getColor(R.styleable.SpliceEditTextView_centerHintTextColor, 0);

            centerTextTypefaceNmae = ta.getString(R.styleable.SpliceEditTextView_centerTextTypefaceNmae);

            centerTextMaxLength = ta.getInt(R.styleable.SpliceEditTextView_centerTextMaxLength, 0);
            centerTextMaxLines = ta.getInt(R.styleable.SpliceEditTextView_centerTextMaxLines, 0);


            centerTextView = new EditText(context);
            setCenterText(centerText);
            setCenterHintText(centerHintText);
        }
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
                          int textGravity, float textSize, int textColor, int backgroundRes, int textStyle, int textMaxLength, int textMaxLines,
                          String typefaceNmae) {
        if (textView == null) {
            return;
        }
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
        } else {
            textView.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (textMaxLength != 0) {
            textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(textMaxLength)});
        }
        if (textMaxLines != 0) {
            textView.setMaxLines(textMaxLines);
        }

        setTypface(textView, typefaceNmae);
    }

    private void setTypface(TextView textView, String typefaceNmae) {
        if (textView == null || TextUtils.isEmpty(typefaceNmae)) {
            return;
        }
        Typeface fromAsset = Typeface.createFromAsset(getContext().getAssets(), typefaceNmae);
        if (fromAsset != null) {
            textView.setTypeface(fromAsset);
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
    }

    public void setStartText(CharSequence startText) {
        if (!TextUtils.isEmpty(startText) && startTextView != null) {
            this.startText = startText;
            startTextView.setText(startText);
            if (!isStartTextAdd) {
                isStartTextAdd = true;
                addView(startTextView, 0);
                initText(startTextView, startLineSpacingExtra, startLineSpacingMultiplier,
                        startTextVisibility, startTextGravity, startTextSize, startTextColor, startBackground, startTextStyle, startTextMaxLength,
                        startTextMaxLines, startTextTypefaceNmae);
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
                } else {
                    addView(centerTextView);
                }
                LinearLayout.LayoutParams layoutParams = (LayoutParams) centerTextView.getLayoutParams();
                layoutParams.weight = 1;
                centerTextView.setLayoutParams(layoutParams);
                if (centerHintTextColor != 0) {
                    centerTextView.setHintTextColor(centerHintTextColor);
                }
                initText(centerTextView, centerLineSpacingExtra, centerLineSpacingMultiplier,
                        centerTextVisibility, centerTextGravity, centerTextSize, centerTextColor, centerBackground, centerTextStyle,
                        centerTextMaxLength, centerTextMaxLines, centerTextTypefaceNmae);
                initTextMargin(centerTextView, centerMargin, centerMarginLeft, centerMarginRight, centerMarginTop, centerMarginBottom);
                initTextPadding(centerTextView, centerPadding, centerPaddingLeft, centerPaddingRight, centerPaddingTop,
                        centerPaddingBottom);
            }
        }
    }

    public void setCenterHintText(CharSequence centerHintText) {
        if (!TextUtils.isEmpty(centerHintText) && centerTextView != null) {
            this.centerHintText = centerHintText;
            centerTextView.setHint(centerHintText);
            if (!isCenterTextAdd) {
                isCenterTextAdd = true;
                if (isStartTextAdd) {
                    addView(centerTextView, 1);
                } else {
                    addView(centerTextView);
                }
                LinearLayout.LayoutParams layoutParams = (LayoutParams) centerTextView.getLayoutParams();
                layoutParams.weight = 1;
                centerTextView.setLayoutParams(layoutParams);
                if (centerHintTextColor != 0) {
                    centerTextView.setHintTextColor(centerHintTextColor);
                }
                initText(centerTextView, centerLineSpacingExtra, centerLineSpacingMultiplier,
                        centerTextVisibility, centerTextGravity, centerTextSize, centerTextColor, centerBackground, centerTextStyle,
                        centerTextMaxLength, centerTextMaxLines, centerTextTypefaceNmae);
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

    public void setCenterHintTextColor(@ColorInt int centerHintTextColor) {
        if (centerTextView != null) {
            this.centerHintTextColor = centerHintTextColor;
            centerTextView.setHintTextColor(centerHintTextColor);
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


    public void setStartTextGravity(@SpliceGravity int startTextGravity) {
        this.startTextGravity = startTextGravity;
        setTextGravity(startTextView, startTextGravity);
    }

    public void setCenterTextGravity(@SpliceGravity int centerTextGravity) {
        this.centerTextGravity = centerTextGravity;
        setTextGravity(centerTextView, centerTextGravity);
    }


    public void setTextGravity(@SpliceGravity int textGravity) {
        this.textGravity = textGravity;
        setTextGravity(startTextView, textGravity);
        setTextGravity(centerTextView, textGravity);
    }

    public void setStartTextAlpha(float alpha) {
        if (startTextView != null && alpha >= 0)
            startTextView.setAlpha(alpha);
    }

    public void setCenterTextAlpha(float alpha) {
        if (centerTextView != null && alpha >= 0)
            centerTextView.setAlpha(alpha);
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

    public void setStartTextMargin(int left, int top, int right, int bottom) {
        if (startTextView != null) {
            LayoutParams layoutParams = (LayoutParams) startTextView.getLayoutParams();
            layoutParams.setMargins(left, top, right, bottom);
            startTextView.setLayoutParams(layoutParams);
        }
    }

    public void setCenterTextMargin(int left, int top, int right, int bottom) {
        if (centerTextView != null) {
            LayoutParams layoutParams = (LayoutParams) centerTextView.getLayoutParams();
            layoutParams.setMargins(left, top, right, bottom);
            centerTextView.setLayoutParams(layoutParams);
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

    public CharSequence getCenterText() {
        if (centerTextView != null)
            return centerTextView.getText();
        return "";
    }

    public void setCenterEditTextChangedListener(TextWatcher watcher) {
        if (centerTextView != null && watcher != null) {
            centerTextView.addTextChangedListener(watcher);
        }
    }

    public TextView getStartTextView() {
        return startTextView;
    }

    public EditText getCenterTextView() {
        return centerTextView;
    }

    public void setCenterEditTextView(EditText centerTextView) {
        if (isCenterTextAdd) {
            isCenterTextAdd = false;
            removeView(this.centerTextView);
        }
        this.centerTextView = centerTextView;
        setCenterText(centerText);
        setCenterHintText(centerHintText);
    }

    public void setStartTextTypefaceNmae(String typefaceNmae) {
        this.startTextTypefaceNmae = typefaceNmae;
        setTypface(startTextView, startTextTypefaceNmae);
    }

    public void setCenterTextTypefaceNmae(String typefaceNmae) {
        this.centerTextTypefaceNmae = typefaceNmae;
        setTypface(centerTextView, centerTextTypefaceNmae);
    }
}
