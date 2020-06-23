package com.android.splicetextview.state;

import androidx.annotation.IntDef;

import com.android.splicetextview.SpliceTextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({SpliceTextView.CENTER, SpliceTextView.CENTER_VERTICAL, SpliceTextView.CENTER_HORIZONTAL, SpliceTextView.RIGHT})
public @interface SpliceGravity {
}
