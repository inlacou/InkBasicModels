package com.inlacou.inkbasicmodels

import android.view.View
import com.inlacou.exinput.free.text.TextInput
import com.inlacou.inkbasicmodels.extensions.applyModel

open class TextInputMdl(
	val textMdl: TextMdl? = null,
	/**
	 * Hint text size is cannot be modified, value from [textMdl] will be taken.
	 */
	val hintMdl: TextMdl? = null,
	val generalViewMdl: GeneralViewMdl? = null
)

fun TextInput.applyModel(mdl: TextInputMdl) {
	(this as View).applyModel(mdl.generalViewMdl)
	mdl.textMdl?.let {
		it.text?.let { text = it.toString() }
		it.textStyleMdl?.let {
			it.textColorResId?.let { setTextColor(it) }
			setTextSize(it.textSizeDimensionType.value, it.textSize ?: textSize)
		}
	}
	mdl.hintMdl?.let {
		it.text?.let { hint = it.toString() }
		it.textStyleMdl?.let {
			it.textColorResId?.let { setHintTextColor(it) }
		}
	}
}