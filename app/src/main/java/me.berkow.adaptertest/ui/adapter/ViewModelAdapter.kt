package me.berkow.adaptertest.ui.adapter

import android.databinding.DataBindingUtil.inflate
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.berkow.adaptertest.ui.holder.ViewModelHolder
import me.berkow.adaptertest.ui.viewmodel.ViewModel

/**
 * Created by konstantinberkov on 12/1/16.
 */

class ViewModelAdapter(val data: MutableList<ViewModel<*>>) : RecyclerView.Adapter<ViewModelHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModelHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = inflate<ViewDataBinding>(inflater, viewType, parent, false)
        return ViewModelHolder(dataBinding.root)
    }

    override fun onBindViewHolder(holder: ViewModelHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onViewRecycled(holder: ViewModelHolder?) {
        holder?.unbind()
    }

    override fun getItemViewType(position: Int): Int = data[position].itemType

    override fun getItemCount(): Int = data.size
}
