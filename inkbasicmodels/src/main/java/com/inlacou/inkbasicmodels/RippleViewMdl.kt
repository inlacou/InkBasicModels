package com.inlacou.inkbasicmodels

import com.inlacou.inkbasicmodels.extensions.applyModel
import com.inlacou.inkbasicmodels.extensions.applyModelOrClear
import com.inlacou.pripple.RippleLinearLayout
import com.inlacou.pripple.RippleRelativeLayout

open class RippleViewMdl(
		val generalViewMdl: GeneralViewMdl = GeneralViewMdl(),
		val rippleMdl: RippleMdl = RippleMdl()
)