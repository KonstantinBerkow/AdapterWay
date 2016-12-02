package me.berkow.adaptertest

/**
 * Created by konstantinberkov on 12/1/16.
 */
interface Bindable<in T> {

    fun bind(item: T)

    fun unbind()
}
