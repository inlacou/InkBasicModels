package com.inlacou.inkbasicmodels

import com.inlacou.exinput.utils.extensions.getColorCompat
import com.inlacou.pripple.RippleLinearLayout
import com.inlacou.pripple.RippleRelativeLayout

open class RippleMdl(
	val normalBackgroundColorResId: Int? = null,
	val rippleBackgroundColorResId: Int? = null,
	val strokeColorResId: Int? = null,
	val strokeWidth: Int? = null,
	val cornerRadius: Float? = null
)