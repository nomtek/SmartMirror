package com.nomtek.avonil.smartmirror.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * Created by avonil on 9/18/17.
 */
class RotatedFrameLayout @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        rotation = 90f
    }

    override fun onLayout(changed: Boolean,
                          left: Int,
                          top: Int,
                          right: Int,
                          bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        val width = width
        val height = height
        val offset = Math.abs(width - height) / 2
        translationX = (offset).toFloat()
        translationY = offset.toFloat()
    }

    @Synchronized
    override fun onMeasure(widthMeasureSpec: Int,
                           heightMeasureSpec: Int) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec)
        val offset = Math.abs(measuredWidth - measuredHeight) / 2
        val newWidth = measuredHeight
        val newHeight = measuredWidth + 2 * offset
        setMeasuredDimension(newWidth, newHeight)
    }
}