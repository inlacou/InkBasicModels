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