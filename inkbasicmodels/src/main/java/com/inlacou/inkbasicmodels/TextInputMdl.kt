package com.inlacou.inkbasicmodels

open class TextInputMdl(
	val textMdl: TextMdl? = null,
	/**
	 * Hint text size is cannot be modified, value from [textMdl] will be taken.
	 */
	val hintMdl: TextMdl? = null,
	val generalViewMdl: GeneralViewMdl? = null
)