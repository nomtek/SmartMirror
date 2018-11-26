package com.nomtek.avonil.smartmirror.utils

import android.support.annotation.DrawableRes
import android.widget.ImageView

/**
 * Created by avonil on 9/14/17.
 */
interface ImageLoader {

    fun loadInto(url: String?, imageView: ImageView?)

    fun loadIntoWithCenterCrop(@DrawableRes placeholder: Int, url: String?, imageView: ImageView?)

    fun loadInto(@DrawableRes placeholder: Int, url: String?, imageView: ImageView?)

}