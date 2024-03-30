package com.inlacou.inkbasicmodels

import android.util.TypedValue

enum class DimensionType(val value: Int) {
	PX(TypedValue.COMPLEX_UNIT_PX), DP(TypedValue.COMPLEX_UNIT_DIP), SP(TypedValue.COMPLEX_UNIT_SP)
}