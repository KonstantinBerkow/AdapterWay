package me.berkow.adaptertest.ui.viewmodel

import android.databinding.DataBindingUtil
import android.support.v4.util.Pools
import android.view.View
import me.berkow.adaptertest.R
import me.berkow.adaptertest.Selectable
import me.berkow.adaptertest.SelectableDelegate
import me.berkow.adaptertest.acquireOrCreate
import me.berkow.adaptertest.databinding.MessageLayoutBinding
import me.berkow.adaptertest.model.Message

/**
 * Created by konstantinberkov on 12/2/16.
 */

class MessageViewModel : ViewModel<Message>(), Selectable by SelectableDelegate() {

    private var binding: MessageLayoutBinding? = null

    override fun bindToView(view: View) {
        binding = DataBindingUtil.findBinding<MessageLayoutBinding>(view)
        binding!!.message = this
    }

    override fun unbindFromView(view: View) {
        binding = null
    }

    override val itemType = R.layout.message_layout

    override fun recycle() {
        super.recycle()
        isSelectable = false
        isSelected = false
        POOL.release(this)
    }

    companion object {
        private val POOL = Pools.SimplePool<MessageViewModel>(128)

        fun create(message: Message, selectable: Boolean, selected: Boolean): MessageViewModel {
            val viewModel = POOL.acquireOrCreate { MessageViewModel() }

            viewModel.model = message
            viewModel.isSelectable = selectable
            viewModel.isSelected = selected

            return viewModel
        }
    }
}
