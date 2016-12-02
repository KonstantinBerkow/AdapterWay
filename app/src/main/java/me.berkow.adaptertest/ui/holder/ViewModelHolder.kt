package me.berkow.adaptertest.ui.holder

import android.view.View

import me.berkow.adaptertest.ui.viewmodel.ViewModel

/**
 * Created by konstantinberkov on 12/1/16.
 */

class ViewModelHolder(itemView: View) : SimpleHolder<ViewModel<*>>(itemView) {

    override fun onBind(item: ViewModel<*>) {
        item.attachToView(itemView)
    }

    override fun onUnbind(item: ViewModel<*>) {
        item.detachFromView()
    }
}
