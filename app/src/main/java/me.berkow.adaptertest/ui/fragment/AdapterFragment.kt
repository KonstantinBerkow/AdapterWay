package me.berkow.adaptertest.ui.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.berkow.adaptertest.databinding.FragmentAdapterBinding
import me.berkow.adaptertest.model.Message
import me.berkow.adaptertest.ui.adapter.ViewModelAdapter
import me.berkow.adaptertest.ui.viewmodel.MessageViewModel
import me.berkow.adaptertest.ui.viewmodel.ViewModel
import java.util.*

/**
 * Created by konstantinberkov on 12/2/16.
 */

class AdapterFragment : Fragment() {
    private val binding = lazy { DataBindingUtil.findBinding<FragmentAdapterBinding>(view) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val adapterBinding = FragmentAdapterBinding.inflate(inflater, container, false)

        return adapterBinding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val models = ArrayList<ViewModel<*>>()
        this.instantiateModels(models)
        val adapter = ViewModelAdapter(models)

        binding.value.adapter = adapter
    }

    private fun instantiateModels(models: MutableList<ViewModel<*>>) {
        (0..15).mapTo(models) { MessageViewModel.create(Message((it + 1).toLong(), "Message #" + it), false, false) }
    }

    companion object {

        fun newInstance(): AdapterFragment {
            val args = Bundle()
            val fragment = AdapterFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
