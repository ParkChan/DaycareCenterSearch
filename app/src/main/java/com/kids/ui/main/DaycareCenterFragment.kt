package com.kids.ui.main

import android.os.Bundle
import android.util.ArrayMap
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.kids.BR
import com.kids.R
import com.kids.common.base.BaseFragment
import com.kids.common.base.BaseListAdapter
import com.kids.common.base.BaseViewModel
import com.kids.common.data.ViewHolderIdData
import com.kids.databinding.FragmentDaycareCenterBinding
import com.kids.ui.main.model.DaycareCenterModel
import com.kids.ui.main.viewmodel.DaycareCenterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DaycareCenterFragment : BaseFragment<FragmentDaycareCenterBinding>(
    R.layout.fragment_daycare_center
) {

    private val daycareCenterViewModel by viewModels<DaycareCenterViewModel>()
    lateinit var adapter: BaseListAdapter<DaycareCenterModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        lifecycleScope.launch {
            daycareCenterViewModel.getCenterListStream("11", "11740").collect {
                adapter.submitData(it)
            }
        }
    }

    override fun bindViewModel() {
        binding.vm = daycareCenterViewModel
    }

    private fun initAdapter() {
        val adapterViewModels = ArrayMap<Int, BaseViewModel>().apply {
            this[BR.daycareCenterViewModel] = daycareCenterViewModel
        }

        val viewHolderIdData =
            ViewHolderIdData(R.layout.item_daycare_center, BR.daycareCenterModel, BR.itemPosition)

        adapter = BaseListAdapter(
            viewHolderIdData = viewHolderIdData,
            viewModels = adapterViewModels,
            diffCallback = DaycareCenterDiffer()
        )

        adapter.addLoadStateListener { loadState ->
            /*
             * loadState.refresh - represents the load state for loading the PagingData for the first time.
             * loadState.prepend - represents the load state for loading data at the start of the list.
             * loadState.append - represents the load state for loading data at the end of the list.
             *
             */
            if (loadState.refresh is LoadState.Loading ||
                loadState.append is LoadState.Loading
            ) {
//                showProgressBar(true)
            } else {
//                showProgressBar(false)
                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                    Toast.makeText(context, it.error.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
        binding.rvProduct.adapter = adapter
    }
}
