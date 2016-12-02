package me.berkow.adaptertest

import android.support.v4.util.Pools

/**
 * Created by konstantinberkov on 12/1/16.
 */
//@BindingAdapter("app:adapter")
//fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
//    recyclerView.adapter = adapter
//}

inline fun <T> Pools.Pool<T>.acquireOrCreate(creator: () -> T): T {
    return acquire() ?: creator()
}
