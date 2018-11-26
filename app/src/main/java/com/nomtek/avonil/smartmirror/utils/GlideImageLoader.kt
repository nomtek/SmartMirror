package com.nomtek.avonil.smartmirror.utils

import android.content.Context
import android.graphics.Bitmap
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import javax.inject.Inject

/**
 * Created by avonil on 9/14/17.
 */
class GlideImageLoader @Inject constructor(var context: Context) : ImageLoader {


    override fun loadInto(url: String?, imageView: ImageView?) {
        Glide.with(context).load(url).asBitmap()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .centerCrop().into(imageView)
    }

    override fun loadIntoWithCenterCrop(@DrawableRes placeholder: Int, url: String?, imageView: ImageView?) {
        Glide.with(context).load(url).asBitmap()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(placeholder)
                .centerCrop()
                .into(imageView)
    }

    override fun loadInto(@DrawableRes placeholder: Int, url: String?, imageView: ImageView?) {
        Glide.with(context).load(url).asBitmap()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(placeholder)
                .into(imageView)
    }
}