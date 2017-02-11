@file:JvmName("ExtensionsUtils")
package com.subhrajyoti.redditnews.commons.extensions

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.subhrajyoti.redditnews.R


fun ViewGroup.inflate(layoutId: Int, attachRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachRoot)
}

fun ImageView.loadImg(imageURL : String) {
    if (TextUtils.isEmpty(imageURL)){
        Picasso.with(context)
                .load(R.mipmap.ic_launcher)
                .into(this)
    } else {
        Picasso.with(context)
                .load(imageURL)
                .into(this)
    }
}
