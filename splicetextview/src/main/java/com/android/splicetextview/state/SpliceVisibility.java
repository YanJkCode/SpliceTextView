package com.android.splicetextview.state;

import androidx.annotation.IntDef;

import com.android.splicetextview.SpliceTextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({SpliceTextView.VISIBLE, SpliceTextView.INVISIBLE, SpliceTextView.GONE, SpliceTextView.ALPHA_SHOW, SpliceTextView.ALPHA_HINT})
public @interface SpliceVisibility {
}
