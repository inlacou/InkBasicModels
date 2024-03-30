package com.inlacou.inkbasicmodels.extensions

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.inlacou.inkbasicmodels.*
import com.inlacou.inkbasicmodels.DimensionType.*
import com.inlacou.pripple.RippleButton
import com.inlacou.pripple.RippleLinearLayout
import com.inlacou.pripple.RippleRelativeLayout

//VIEW
fun View.applyModel(mdl: GeneralViewMdl?) {
	if(mdl?.onClick!=null) setOnClickListener { mdl.onClick.invoke(this) }
	setPaddings(left = mdl?.paddingLeft, right = mdl?.paddingRight, top = mdl?.paddingTop, bottom = mdl?.paddingBottom)
	setMargins(left = mdl?.marginLeft, right = mdl?.marginRight, top = mdl?.marginTop, bottom = mdl?.marginBottom)
	layoutParams = layoutParams?.apply {
		mdl?.width?.let { width = it }
		mdl?.height?.let { height = it }
	}
}

fun RelativeLayout.applyViewModel(mdl: RelativeLayoutViewMdl) {
	(this as View).applyModel(mdl.generalViewMdl)
	layoutParams = layoutParams.apply {
		mdl.rules?.let { if(this is RelativeLayout.LayoutParams) it.forEach { addRule(it) } }
	}
}

fun RelativeLayout.applyModelOrClear(mdl: RelativeLayoutViewMdl?) {
	(this as View).applyModelOrClear(mdl?.generalViewMdl)
	layoutParams = layoutParams.apply {
		if(this is RelativeLayout.LayoutParams) mdl?.rules?.forEach { addRule(it) } ?: addRule(if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1) RelativeLayout.ALIGN_START else RelativeLayout.ALIGN_LEFT)
	}
}

fun FrameLayout.applyViewModel(mdl: LinearLayoutViewMdl) {
	(this as View).applyModel(mdl.generalViewMdl)
	layoutParams = layoutParams.apply {
		mdl.gravity?.let {
			if(this is FrameLayout.LayoutParams) gravity = it
		}
	}
}

fun FrameLayout.applyModelOrClear(mdl: LinearLayoutViewMdl?) {
	(this as View).applyModelOrClear(mdl?.generalViewMdl)
	layoutParams = layoutParams.apply {
		if(this is FrameLayout.LayoutParams) gravity = mdl?.gravity ?: Gravity.NO_GRAVITY
	}
}

fun CoordinatorLayout.applyViewModel(mdl: LinearLayoutViewMdl) {
	(this as View).applyModel(mdl.generalViewMdl)
	layoutParams = layoutParams.apply {
		mdl.gravity?.let {
			if(this is CoordinatorLayout.LayoutParams) gravity = it
			try{ if(this is CoordinatorLayout.LayoutParams) gravity = it }catch (ncdfe: NoClassDefFoundError){}
		}
	}
}
fun CoordinatorLayout.applyModelOrClear(mdl: LinearLayoutViewMdl?) {
	(this as View).applyModelOrClear(mdl?.generalViewMdl)
	layoutParams = layoutParams.apply {
		if(this is CoordinatorLayout.LayoutParams) gravity = mdl?.gravity ?: Gravity.NO_GRAVITY
		try{ if(this is CoordinatorLayout.LayoutParams) gravity = mdl?.gravity ?: Gravity.NO_GRAVITY }catch (ncdfe: NoClassDefFoundError){}
	}
}

fun View.applyModelOrClear(mdl: GeneralViewMdl?) {
	if(mdl?.onClick!=null) setOnClickListener { mdl.onClick.invoke(this) }
	else setOnClickListener(null)
	setPaddings(left = mdl?.paddingLeft ?: 0, right = mdl?.paddingRight ?: 0, top = mdl?.paddingTop ?: 0, bottom = mdl?.paddingBottom ?: 0)
	setMargins(left = mdl?.marginLeft ?: 0, right = mdl?.marginRight ?: 0, top = mdl?.marginTop ?: 0, bottom = mdl?.marginBottom ?: 0)
	layoutParams = layoutParams?.apply {
		width = mdl?.width ?: ViewGroup.LayoutParams.WRAP_CONTENT
		height = mdl?.height ?: ViewGroup.LayoutParams.WRAP_CONTENT
	}
}

private fun View.setPaddings(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
	setPadding(left ?: this.paddingLeft, top ?: this.paddingTop, right ?: this.paddingRight, bottom ?: this.paddingBottom)
	requestLayout()
}

private fun View.setMargins(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {
	layoutParams?.apply {
		if(this is LinearLayout.LayoutParams) setMargins(left ?: this.leftMargin, top ?: this.topMargin, right ?: this.rightMargin, bottom ?: this.bottomMargin)
		if(this is FrameLayout.LayoutParams) setMargins(left ?: this.leftMargin, top ?: this.topMargin, right ?: this.rightMargin, bottom ?: this.bottomMargin)
		if(this is RelativeLayout.LayoutParams) setMargins(left ?: this.leftMargin, top ?: this.topMargin, right ?: this.rightMargin, bottom ?: this.bottomMargin)
		try{ if(this is CoordinatorLayout.LayoutParams) setMargins(left ?: this.leftMargin, top ?: this.topMargin, right ?: this.rightMargin, bottom ?: this.bottomMargin) }catch (ncdfe: NoClassDefFoundError){}
	}
	requestLayout()
}
///VIEW

//UTILITIES
private fun Context.getColorCompat(resId: Int): Int {
	return resources.getColorCompat(resId)
}

private fun Resources.getColorCompat(resId: Int): Int {
	return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
		getColor(resId, null)
	}else{
		getColor(resId)
	}
}
///UTILITIES
