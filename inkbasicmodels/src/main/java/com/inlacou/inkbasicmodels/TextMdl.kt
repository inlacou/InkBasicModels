package com.inlacou.inkbasicmodels

import android.util.TypedValue
import android.widget.TextView
import com.inlacou.exinput.utils.extensions.getColorCompat
import com.inlacou.inkbasicmodels.extensions.applyModel
import com.inlacou.inkbasicmodels.extensions.applyModelOrClear
import com.inlacou.inkspannable.InkSpannableBuilder

open class TextMdl(
	val text: InkSpannableBuilder? = null,
	val textStyleMdl: TextStyleMdl? = null,
)

fun TextView.applyModelOrClear(model: TextViewMdl?) {
	applyModelOrClear(model?.textMdl)
	applyModelOrClear(model?.generalViewMdl)
}

fun TextView.applyModelOrClear(textMdl: TextMdl?) {
	applyModelOrClear(textMdl?.textStyleMdl)
	text = textMdl?.text?.build() ?: ""
}

fun TextView.applyModelOrClear(textStyleMdl: TextStyleMdl?) {
	setLinkTextColor(context.getColorCompat(textStyleMdl?.textColorResId ?: R.color.inkbasicmodels_default_text_color))
	setTextColor(context.getColorCompat(textStyleMdl?.textColorResId ?: R.color.inkbasicmodels_default_text_color))
	when(textStyleMdl?.textSizeDimensionType) {
		DimensionType.PX -> setTextSize(TypedValue.COMPLEX_UNIT_PX, textStyleMdl.textSize ?: 16F)
		DimensionType.DP -> setTextSize(TypedValue.COMPLEX_UNIT_DIP, textStyleMdl.textSize ?: 16F)
		DimensionType.SP -> setTextSize(TypedValue.COMPLEX_UNIT_SP, textStyleMdl.textSize ?: 16F)
		null -> setTextSize(TypedValue.COMPLEX_UNIT_SP, 16F)
	}
}

fun TextView.applyModel(model: TextViewMdl?){
	applyModel(model?.generalViewMdl)
	applyModel(model?.textMdl)
}

fun TextView.applyModel(textMdl: TextMdl?) {
	applyModel(textMdl?.textStyleMdl)
	if(textMdl?.text!=null) text = textMdl.text.build()
}

fun TextView.applyModel(textStyleMdl: TextStyleMdl?) {
	if(textStyleMdl?.textColorResId!=null) setLinkTextColor(context.getColorCompat(textStyleMdl.textColorResId))
	if(textStyleMdl?.textColorResId!=null) setTextColor(context.getColorCompat(textStyleMdl.textColorResId))
	if(textStyleMdl?.textSize!=null) when(textStyleMdl.textSizeDimensionType) {
		DimensionType.PX -> setTextSize(TypedValue.COMPLEX_UNIT_PX, textStyleMdl.textSize)
		DimensionType.DP -> setTextSize(TypedValue.COMPLEX_UNIT_DIP, textStyleMdl.textSize)
		DimensionType.SP -> setTextSize(TypedValue.COMPLEX_UNIT_SP, textStyleMdl.textSize)
	}
}

fun TextView.applyModel(generalViewMdl: GeneralViewMdl?, textMdl: TextMdl?) {
	applyModel(generalViewMdl)
	applyModel(textMdl)
}