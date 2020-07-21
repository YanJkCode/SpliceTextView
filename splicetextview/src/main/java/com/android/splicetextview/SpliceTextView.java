package com.android.splicetextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
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
    private int startViewState;
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
    private int centerViewState;
    private int centerTextMaxLength;
    private int centerTextMaxLines;
    private String centerTextTypefaceNmae;

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
    private int endViewState;
    private int endTextMaxLength;
    private int endTextMaxLines;
    private String endTextTypefaceNmae;

    private TextView startTextView;
    private TextView centerTextView;
    private TextView endTextView;

    private ImageView startImageView;
    private ImageView centerImageView;
    private ImageView endImageView;

    private boolean isStartViewAdd;
    private boolean isCenterViewAdd;
    private boolean isEndViewAdd;


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

    public static final int TEXT_VIEW = 0;
    public static final int JUST_TEXT_VIEW = 1;
    public static final int IMAGE_VIEW = 2;

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
            startViewState = ta.getInt(R.styleable.SpliceTextView_startViewState, 0);

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

            startTextMaxLength = ta.getInt(R.styleable.SpliceTextView_startTextMaxLength, 0);
            startTextMaxLines = ta.getInt(R.styleable.SpliceTextView_startTextMaxLines, 0);

            startTextTypefaceNmae = ta.getString(R.styleable.SpliceTextView_startTextTypefaceNmae);

            startBackground = ta.getResourceId(R.styleable.SpliceTextView_startBackground, 0);
            switch (startViewState) {
                case TEXT_VIEW:
                    startTextView = new TextView(context);
                    setStartText(startText);
                    break;
                case JUST_TEXT_VIEW:
                    startTextView = new JustTextView(context);
                    setStartText(startText);
                    break;
                case IMAGE_VIEW:
                    startImageView = new ImageView(context);
                    startImageView.setAdjustViewBounds(true);
                    setStartImageview();
                    break;
            }


            centerText = ta.getString(R.styleable.SpliceTextView_centerText);
            centerTextSize = ScreenUtil.px2dip(context, ta.getDimension(R.styleable.SpliceTextView_centerTextSize, 0));
            centerLineSpacingExtra = ta.getDimension(R.styleable.SpliceTextView_centerLineSpacingExtra, 0);
            centerLineSpacingMultiplier = ta.getFloat(R.styleable.SpliceTextView_centerLineSpacingMultiplier, 1);
            centerTextColor = ta.getColor(R.styleable.SpliceTextView_centerTextColor, Color.BLACK);
            centerTextGravity = ta.getInt(R.styleable.SpliceTextView_centerTextGravity, 0);
            centerTextVisibility = ta.getInt(R.styleable.SpliceTextView_centerTextVisibility, 0);
            centerTextStyle = ta.getInt(R.styleable.SpliceTextView_centerTextStyle, 0);
            centerViewState = ta.getInt(R.styleable.SpliceTextView_centerViewState, 0);


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

            centerTextMaxLength = ta.getInt(R.styleable.SpliceTextView_centerTextMaxLength, 0);
            centerTextMaxLines = ta.getInt(R.styleable.SpliceTextView_centerTextMaxLines, 0);

            centerTextTypefaceNmae = ta.getString(R.styleable.SpliceTextView_centerTextTypefaceNmae);

            centerBackground = ta.getResourceId(R.styleable.SpliceTextView_centerBackground, 0);

            switch (centerViewState) {
                case TEXT_VIEW:
                    centerTextView = new TextView(context);
                    setCenterText(centerText);
                    break;
                case JUST_TEXT_VIEW:
                    centerTextView = new JustTextView(context);
                    setCenterText(centerText);
                    break;
                case IMAGE_VIEW:
                    centerImageView = new ImageView(context);
                    centerImageView.setAdjustViewBounds(true);
                    setCenterImageview();
                    break;
            }

            endText = ta.getString(R.styleable.SpliceTextView_endText);
            endTextSize = ScreenUtil.px2dip(context, ta.getDimension(R.styleable.SpliceTextView_endTextSize, 0));
            endLineSpacingExtra = ta.getDimension(R.styleable.SpliceTextView_endLineSpacingExtra, 0);
            endLineSpacingMultiplier = ta.getFloat(R.styleable.SpliceTextView_endLineSpacingMultiplier, 1);
            endTextColor = ta.getColor(R.styleable.SpliceTextView_endTextColor, Color.BLACK);
            endTextGravity = ta.getInt(R.styleable.SpliceTextView_endTextGravity, 0);
            endTextVisibility = ta.getInt(R.styleable.SpliceTextView_endTextVisibility, 0);
            endTextStyle = ta.getInt(R.styleable.SpliceTextView_endTextStyle, 0);
            endViewState = ta.getInt(R.styleable.SpliceTextView_endViewState, 0);

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

            endTextMaxLength = ta.getInt(R.styleable.SpliceTextView_endTextMaxLength, 0);
            endTextMaxLines = ta.getInt(R.styleable.SpliceTextView_endTextMaxLines, 0);

            endTextTypefaceNmae = ta.getString(R.styleable.SpliceTextView_endTextTypefaceNmae);

            endBackground = ta.getResourceId(R.styleable.SpliceTextView_endBackground, 0);
            switch (endViewState) {
                case TEXT_VIEW:
                    endTextView = new TextView(context);
                    setEndText(endText);
                    break;
                case JUST_TEXT_VIEW:
                    endTextView = new JustTextView(context);
                    setEndText(endText);
                    break;
                case IMAGE_VIEW:
                    endImageView = new ImageView(context);
                    endImageView.setAdjustViewBounds(true);
                    setEndImageview();
                    break;
            }
        }
    }

    private void initTextMargin(View tv, int margin, int marginLeft, int marginRight, int marginTop, int marginBottom) {
        if (margin != 0 || marginLeft != 0 || marginRight != 0 || marginTop != 0 || marginBottom != 0) {
            LayoutParams layoutParams = (LayoutParams) tv.getLayoutParams();
            layoutParams.setMargins(Math.max(margin, marginLeft), Math.max(margin, marginTop), Math.max(margin, marginRight),
                    Math.max(margin, marginBottom));
            tv.setLayoutParams(layoutParams);
        }
    }

    private void initTextPadding(View tv, int padding, int paddingLeft, int paddingRight, int paddingTop, int paddingBottom) {
        if (padding != 0 || paddingLeft != 0 || paddingRight != 0 || paddingTop != 0 || paddingBottom != 0) {
            tv.setPadding(Math.max(padding, paddingLeft), Math.max(padding, paddingTop), Math.max(padding, paddingRight),
                    Math.max(padding, paddingBottom));
        }
    }

    private void initText(TextView textView, float lineSpacingExtra, float lineSpacingMultiplier, int textVisibility,
                          int textGravity, float textSize, int textColor, int backgroundRes, int textStyle,
                          int textMaxLength, int textMaxLines, String typefaceNmae) {
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

    private void initImageView(ImageView imageView, int textVisibility, int textGravity, int backgroundRes) {
        if (imageView == null) {
            return;
        }
        if (textVisibility != 0) {
            setTextVisibility(imageView, textVisibility);
        }
        if (this.textGravity != 0) {
            setImageViewGravity(imageView, this.textGravity);
        } else {
            if (textGravity != 0) {
                setImageViewGravity(imageView, textGravity);
            }
        }
        if (backgroundRes != 0) {
            imageView.setImageResource(backgroundRes);
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

    private void setImageViewGravity(ImageView tv, @SpliceGravity int type) {
        if (tv != null) {
            ViewGroup.LayoutParams params = tv.getLayoutParams();
            if (params != null && params instanceof LinearLayout.LayoutParams) {
                LayoutParams layoutParams = (LayoutParams) params;
                switch (type) {
                    case CENTER:
                        layoutParams.gravity = Gravity.CENTER;
                        break;
                    case CENTER_VERTICAL:
                        layoutParams.gravity = Gravity.CENTER_VERTICAL;
                        break;
                    case CENTER_HORIZONTAL:
                        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case RIGHT:
                        layoutParams.gravity = Gravity.RIGHT;
                        break;
                }
                tv.setLayoutParams(layoutParams);
            }
        }
    }

    private void setTextVisibility(View tv, @SpliceVisibility int type) {
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
            if (!isStartViewAdd) {
                isStartViewAdd = true;
                addView(startTextView, 0);
                initText(startTextView, startLineSpacingExtra, startLineSpacingMultiplier,
                        startTextVisibility, startTextGravity, startTextSize, startTextColor, startBackground, startTextStyle, startTextMaxLength,
                        startTextMaxLines, startTextTypefaceNmae);
                initTextMargin(startTextView, startMargin, startMarginLeft, startMarginRight, startMarginTop, startMarginBottom);
                initTextPadding(startTextView, startPadding, startPaddingLeft, startPaddingRight, startPaddingTop, startPaddingBottom);
            }
        }
    }

    @Override
    public void addView(View child) {
        if (child != null && child.getParent() != null) {
            ViewParent parent = child.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(child);
            }
        }
        super.addView(child, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void addView(View child, int index) {
        if (child != null && child.getParent() != null) {
            ViewParent parent = child.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(child);
            }
        }
        super.addView(child, index, new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    }

    public void setStartImageview() {
        if (startImageView != null) {
            if (!isStartViewAdd) {
                isStartViewAdd = true;
                addView(startImageView, 0);
                initImageView(startImageView, startTextVisibility, startTextGravity, startBackground);
                initTextMargin(startImageView, startMargin, startMarginLeft, startMarginRight, startMarginTop, startMarginBottom);
                initTextPadding(startImageView, startPadding, startPaddingLeft, startPaddingRight, startPaddingTop, startPaddingBottom);
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
            if (!isCenterViewAdd) {
                isCenterViewAdd = true;
                if (isStartViewAdd) {
                    addView(centerTextView, 1);
                } else if (isEndViewAdd) {
                    addView(centerTextView, 0);
                } else {
                    addView(centerTextView);
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

    public void setCenterImageview() {
        if (centerImageView != null) {
            if (!isCenterViewAdd) {
                isCenterViewAdd = true;
                if (isStartViewAdd) {
                    addView(centerImageView, 1);
                } else if (isEndViewAdd) {
                    addView(centerImageView, 0);
                } else {
                    addView(centerImageView);
                }
                initImageView(centerImageView, centerTextVisibility, centerTextGravity, centerBackground);
                initTextMargin(centerImageView, centerMargin, centerMarginLeft, centerMarginRight, centerMarginTop, centerMarginBottom);
                initTextPadding(centerImageView, centerPadding, centerPaddingLeft, centerPaddingRight, centerPaddingTop, centerPaddingBottom);
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
            if (!isEndViewAdd) {
                isEndViewAdd = true;
                if (isStartViewAdd && isCenterViewAdd) {
                    addView(endTextView);
                } else if (!isStartViewAdd && isCenterViewAdd) {
                    addView(endTextView, 1);
                } else {
                    addView(endTextView);
                }
                initText(endTextView, endLineSpacingExtra, endLineSpacingMultiplier,
                        endTextVisibility, endTextGravity, endTextSize, endTextColor, endBackground, endTextStyle,
                        endTextMaxLength, endTextMaxLines, endTextTypefaceNmae);
                initTextMargin(endTextView, endMargin, endMarginLeft, endMarginRight, endMarginTop, endMarginBottom);
                initTextPadding(endTextView, endPadding, endPaddingLeft, endPaddingRight, endPaddingTop, endPaddingBottom);
            }
        }
    }

    public void setEndImageview() {
        if (endImageView != null) {
            if (!isEndViewAdd) {
                isEndViewAdd = true;
                if (isStartViewAdd && isCenterViewAdd) {
                    addView(endImageView);
                } else if (!isStartViewAdd && isCenterViewAdd) {
                    addView(endImageView, 1);
                } else {
                    addView(endImageView);
                }
                initImageView(endImageView, endTextVisibility, endTextGravity, endBackground);
                initTextMargin(endImageView, endMargin, endMarginLeft, endMarginRight, endMarginTop, endMarginBottom);
                initTextPadding(endImageView, endPadding, endPaddingLeft, endPaddingRight, endPaddingTop, endPaddingBottom);
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

    public void setStartViewVisibility(@SpliceVisibility int startTextVisibility) {
        this.startTextVisibility = startTextVisibility;
        if (startTextView != null) {
            setTextVisibility(startTextView, startTextVisibility);
        } else {
            if (startImageView != null) {
                setTextVisibility(startImageView, startTextVisibility);
            }
        }
    }

    public void setCenterViewVisibility(@SpliceVisibility int centerTextVisibility) {
        this.centerTextVisibility = centerTextVisibility;
        if (centerTextView != null) {
            setTextVisibility(centerTextView, centerTextVisibility);
        } else {
            if (centerImageView != null) {
                setTextVisibility(centerImageView, centerTextVisibility);
            }
        }
    }


    public void setEndViewVisibility(@SpliceVisibility int endTextVisibility) {
        this.endTextVisibility = endTextVisibility;
        if (endTextView != null) {
            setTextVisibility(endTextView, endTextVisibility);
        } else {
            if (endImageView != null) {
                setTextVisibility(endImageView, endTextVisibility);
            }
        }
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

    public void setStartViewAlpha(float alpha) {
        if (alpha >= 0) {
            if (startTextView != null) {
                startTextView.setAlpha(alpha);
            } else {
                if (startImageView != null) {
                    startImageView.setAlpha(alpha);
                }
            }
        }
    }

    public void setCenterViewAlpha(float alpha) {
        if (alpha >= 0) {
            if (centerTextView != null) {
                centerTextView.setAlpha(alpha);
            } else {
                if (centerImageView != null) {
                    centerImageView.setAlpha(alpha);
                }
            }
        }
    }

    public void setEndViewAlpha(float alpha) {
        if (alpha >= 0) {
            if (endTextView != null) {
                endTextView.setAlpha(alpha);
            } else {
                if (endImageView != null) {
                    endImageView.setAlpha(alpha);
                }
            }
        }
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
        } else {
            if (startImageView != null) {
                startImageView.setImageResource(startBackground);
            }
        }
    }

    public void setCenterBackground(@DrawableRes int centerBackground) {
        this.centerBackground = centerBackground;
        if (centerTextView != null) {
            centerTextView.setBackgroundResource(centerBackground);
        } else {
            if (centerImageView != null) {
                centerImageView.setImageResource(centerBackground);
            }
        }
    }

    public void setEndBackground(@DrawableRes int endBackground) {
        this.endBackground = endBackground;
        if (endTextView != null) {
            endTextView.setBackgroundResource(endBackground);
        } else {
            if (endImageView != null) {
                endImageView.setImageResource(endBackground);
            }
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

    public void setStartTextTypefaceNmae(String typefaceNmae) {
        this.startTextTypefaceNmae = typefaceNmae;
        setTypface(startTextView, startTextTypefaceNmae);
    }

    public void setCenterTextTypefaceNmae(String typefaceNmae) {
        this.centerTextTypefaceNmae = typefaceNmae;
        setTypface(centerTextView, centerTextTypefaceNmae);
    }

    public void setEndTextTypefaceNmae(String typefaceNmae) {
        this.endTextTypefaceNmae = typefaceNmae;
        setTypface(endTextView, endTextTypefaceNmae);
    }
}
