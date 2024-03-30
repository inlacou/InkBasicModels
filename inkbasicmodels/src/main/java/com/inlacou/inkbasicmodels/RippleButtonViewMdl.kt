package com.inlacou.inkbasicmodels

import com.inlacou.exinput.utils.extensions.getColorCompat
import com.inlacou.pripple.RippleButton

open class RippleButtonViewMdl(
		val generalViewMdl: GeneralViewMdl = GeneralViewMdl(),
		val textMdl: TextMdl = TextMdl(),
		val rippleViewMdl: RippleMdl = RippleMdl()
)

fun RippleButton.applyModel(mdl: RippleButtonViewMdl?) {
	applyModel(mdl?.generalViewMdl, mdl?.textMdl, mdl?.rippleViewMdl)
}

fun RippleButton.applyModel(generalViewMdl: GeneralViewMdl?, textMdl: TextMdl?, rippleMdl: RippleMdl?) {
	if(rippleMdl?.normalBackgroundColorResId!=null) normalBackgroundColor = context.getColorCompat(rippleMdl.normalBackgroundColorResId)
	if(rippleMdl?.rippleBackgroundColorResId!=null) rippleBackgroundColor = context.getColorCompat(rippleMdl.rippleBackgroundColorResId)
	if(rippleMdl?.strokeColorResId!=null) strokeColor = context.getColorCompat(rippleMdl.strokeColorResId)
	if(rippleMdl?.strokeWidth!=null) strokeWidth = rippleMdl.strokeWidth
	if(rippleMdl?.cornerRadius!=null) corners = rippleMdl.cornerRadius
	applyModel(TextViewMdl(textMdl, generalViewMdl))
}