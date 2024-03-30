package com.inlacou.inkbasicmodels

import android.view.View

class CheckableMdl(
    val textMdl: TextMdl,
    val checked: Boolean = false,
    val checkedDrawableResId: Int? = null,
    val uncheckedDrawableResId: Int? = null,
    val checkedTintResId: Int? = null,
    val uncheckedTintResId: Int? = null,
    /**
     * @return true if handled
     */
    val onCheckedStateChange: ((view: View, checked: Boolean) -> Boolean)? = null,
)