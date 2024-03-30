package com.inlacou.inkbasicmodels

import android.view.View

open class GeneralViewMdl(
		val marginTop: Int? = null,
		val marginBottom: Int? = null,
		val marginLeft: Int? = null,
		val marginRight: Int? = null,
		val paddingTop: Int? = null,
		val paddingBottom: Int? = null,
		val paddingLeft: Int? = null,
		val paddingRight: Int? = null,
		val backgroundResId: Int? = null,
		/**
		 * @return true if handled
		 */
		val onClick: ((view: View) -> Boolean)? = null,
		val width: Int? = null,
		val height: Int? = null
)