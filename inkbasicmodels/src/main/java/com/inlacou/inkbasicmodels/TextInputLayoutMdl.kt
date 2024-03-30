package com.inlacou.inkbasicmodels

import com.google.android.material.textfield.TextInputLayout
import com.inlacou.inkbasicmodels.extensions.applyModel

open class TextInputLayoutMdl(
	val prefixMdl: TextMdl? = null,
	val suffixMdl: TextMdl? = null,
	// Not sure if this is applied or ExInput value inside is applied val hintMdl: TextMdl? = null,
	val generalViewMdl: GeneralViewMdl? = null,
)

fun TextInputLayout.applyModel(mdl: TextInputLayoutMdl) {
	prefixTextView.applyModel(mdl.prefixMdl?.textStyleMdl)
	suffixTextView.applyModel(mdl.suffixMdl?.textStyleMdl)
	applyModel(mdl.generalViewMdl)
}