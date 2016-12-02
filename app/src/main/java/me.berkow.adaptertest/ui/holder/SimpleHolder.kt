package me.berkow.adaptertest.ui.holder

import android.support.v7.widget.RecyclerView
import android.view.View

import me.berkow.adaptertest.Bindable

/**
 * Created by konstantinberkov on 12/1/16.
 */

abstract class SimpleHolder<in T> protected constructor(itemView: View) : RecyclerView.ViewHolder(itemView), Bindable<T> {

    private var item: T? = null

    override fun bind(item: T) {
        this.item = item
        onBind(item)
    }

    protected abstract fun onBind(item: T)

    override fun unbind() {
        item?.let { onUnbind(it) }
        item = null
    }

    protected abstract fun onUnbind(item: T)
}
