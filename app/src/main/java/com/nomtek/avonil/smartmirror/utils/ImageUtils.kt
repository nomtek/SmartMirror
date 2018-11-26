package com.nomtek.avonil.smartmirror.utils

import android.content.Context
import android.graphics.drawable.Drawable
import java.io.IOException


/**
 * Created by Damian Kwasniak on 9/20/17.
 */
class ImageUtils {

    companion object {

        fun getDrawableWithCode(context: Context, code: String?): Drawable? {
            try {
                // get input stream
                val ims = context.assets.open(code+".png")
                // load image as Drawable
                val d = Drawable.createFromStream(ims, null)
                return d
            } catch (ex: IOException) {
                return null
            }

        }
    }
}