package com.inlacou.inkbasicmodels

import com.inlacou.inkspannable.InkSpannableBuilder

open class TextStyleMdl(
	val text: InkSpannableBuilder? = null,
	val textColorResId: Int? = null,
	val textSize: Float? = null,
	val textSizeDimensionType: DimensionType = DimensionType.SP
)