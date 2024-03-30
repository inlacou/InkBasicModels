package com.inlacou.inkbasicmodels

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.inlacou.inkbasicmodels.extensions.applyModel
import com.inlacou.inkbasicmodels.extensions.applyModelOrClear

open class LinearLayoutViewMdl(
	val generalViewMdl: GeneralViewMdl,
	/**
	 * Does not work on RelativeLayout
	 */
	val gravity: Int? = null,
)

fun LinearLayout.applyViewModel(mdl: LinearLayoutViewMdl) {
	(this as View).applyModel(mdl.generalViewMdl)
	layoutParams = layoutParams.apply {
		mdl.gravity?.let {
			if(this is LinearLayout.LayoutParams) gravity = it
		}
	}
}

fun LinearLayout.applyModelOrClear(mdl: LinearLayoutViewMdl?) {
	(this as View).applyModelOrClear(mdl?.generalViewMdl)
	layoutParams = layoutParams.apply {
		if(this is LinearLayout.LayoutParams) gravity = mdl?.gravity ?: Gravity.NO_GRAVITY
	}
}