package com.android.splicetextview.state;

import androidx.annotation.IntDef;

import com.android.splicetextview.SpliceTextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@IntDef({SpliceTextView.TEXT_VIEW, SpliceTextView.JUST_TEXT_VIEW, SpliceTextView.IMAGE_VIEW})
public @interface SpliceViewState {
}
