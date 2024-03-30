package com.inlacou.inkbasicmodels

import com.inlacou.exinput.utils.extensions.getColorCompat
import com.inlacou.pripple.RippleLinearLayout
import com.inlacou.pripple.RippleRelativeLayout

open class RippleMdl(
	val normalBackgroundColorResId: Int? = null,
	val rippleBackgroundColorResId: Int? = null,
	val strokeColorResId: Int? = null,
	val strokeWidth: Int? = null,
	val cornerRadius: Float? = null
)

fun RippleRelativeLayout.applyModel(mdl: RippleMdl?){
	if(mdl?.normalBackgroundColorResId!=null) normalBackgroundColor = context.getColorCompat(mdl.normalBackgroundColorResId)
	if(mdl?.rippleBackgroundColorResId!=null) rippleBackgroundColor = context.getColorCompat(mdl.rippleBackgroundColorResId)
	if(mdl?.strokeWidth!=null) strokeWidth = mdl.strokeWidth
	if(mdl?.strokeColorResId!=null) strokeColor = context.getColorCompat(mdl.strokeColorResId)
	if(mdl?.cornerRadius!=null) corners = mdl.cornerRadius
}

fun RippleRelativeLayout.applyModelOrClear(mdl: RippleMdl?){
	normalBackgroundColor = context.getColorCompat(mdl?.normalBackgroundColorResId ?: R.color.inkbasicmodels_default_background_color)
	rippleBackgroundColor = context.getColorCompat(mdl?.rippleBackgroundColorResId ?: R.color.inkbasicmodels_default_background_ripple_color)
	strokeWidth = mdl?.strokeWidth ?: 0
	strokeColor = context.getColorCompat(mdl?.strokeColorResId ?: R.color.inkbasicmodels_default_text_color)
	corners = mdl?.cornerRadius ?: 15F
}

fun RippleLinearLayout.applyModel(mdl: RippleMdl?){
	if(mdl?.normalBackgroundColorResId!=null) normalBackgroundColor = context.getColorCompat(mdl.normalBackgroundColorResId)
	if(mdl?.rippleBackgroundColorResId!=null) rippleBackgroundColor = context.getColorCompat(mdl.rippleBackgroundColorResId)
	if(mdl?.strokeWidth!=null) strokeWidth = mdl.strokeWidth
	if(mdl?.strokeColorResId!=null) strokeColor = context.getColorCompat(mdl.strokeColorResId)
	if(mdl?.cornerRadius!=null) corners = mdl.cornerRadius
}

fun RippleLinearLayout.applyModelOrClear(mdl: RippleMdl?){
	normalBackgroundColor = context.getColorCompat(mdl?.normalBackgroundColorResId ?: R.color.inkbasicmodels_default_background_color)
	rippleBackgroundColor = context.getColorCompat(mdl?.rippleBackgroundColorResId ?: R.color.inkbasicmodels_default_background_ripple_color)
	strokeWidth = mdl?.strokeWidth ?: 0
	strokeColor = context.getColorCompat(mdl?.strokeColorResId ?: R.color.inkbasicmodels_default_text_color)
	corners = mdl?.cornerRadius ?: 15F
}