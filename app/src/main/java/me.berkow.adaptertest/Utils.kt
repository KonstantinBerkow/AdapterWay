package me.berkow.adaptertest

import android.databinding.BindingAdapter
import android.support.v4.util.Pools
import android.support.v7.widget.RecyclerView

/**
 * Created by konstantinberkov on 12/1/16.
 */
@BindingAdapter("app:swap_adapter")
fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    recyclerView.swapAdapter(adapter, false)
}

inline fun <T> Pools.Pool<T>.acquireOrCreate(creator: () -> T): T = acquire() ?: creator()
