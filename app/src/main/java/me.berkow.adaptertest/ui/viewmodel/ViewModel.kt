package me.berkow.adaptertest.ui.viewmodel

import android.view.View

import me.berkow.adaptertest.Recyclable

/**
 * Created by konstantinberkov on 12/1/16.
 */

abstract class ViewModel<T> : Recyclable {

    private var view: View? = null

    var model: T? = null

    abstract val itemType: Int

    fun attachToView(view: View) {
        this.view = view
        bindToView(view)
    }

    protected abstract fun bindToView(view: View)

    fun detachFromView() {
        view?.let { unbindFromView(it) }
        view = null
    }

    protected abstract fun unbindFromView(view: View)

    override fun recycle() {
        model = null
        view = null
    }
}
