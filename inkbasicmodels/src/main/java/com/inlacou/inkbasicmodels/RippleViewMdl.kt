package com.inlacou.inkbasicmodels

import com.inlacou.inkbasicmodels.extensions.applyModel
import com.inlacou.inkbasicmodels.extensions.applyModelOrClear
import com.inlacou.pripple.RippleLinearLayout
import com.inlacou.pripple.RippleRelativeLayout

open class RippleViewMdl(
		val generalViewMdl: GeneralViewMdl = GeneralViewMdl(),
		val rippleMdl: RippleMdl = RippleMdl()
)

fun RippleLinearLayout.applyModel(mdl: RippleViewMdl?) {
	applyModel(mdl?.rippleMdl)
	applyModel(mdl?.generalViewMdl)
}

fun RippleRelativeLayout.applyModel(mdl: RippleViewMdl?) {
	applyModel(mdl?.rippleMdl)
	applyModel(mdl?.generalViewMdl)
}

fun RippleLinearLayout.applyModelOrClear(mdl: RippleViewMdl?) {
	applyModelOrClear(mdl?.rippleMdl)
	applyModelOrClear(mdl?.generalViewMdl)
}

fun RippleRelativeLayout.applyModelOrClear(mdl: RippleViewMdl?) {
	applyModelOrClear(mdl?.rippleMdl)
	applyModelOrClear(mdl?.generalViewMdl)
}
