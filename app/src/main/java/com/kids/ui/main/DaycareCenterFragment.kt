package com.kids.ui.main

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.ArrayMap
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import com.kids.BR
import com.kids.R
import com.kids.common.base.BaseFragment
import com.kids.common.base.adapter.BasePagingDataAdapter
import com.kids.common.base.component.BaseViewInitComponent
import com.kids.common.data.ViewHolderIdData
import com.kids.constants.areaData
import com.kids.constants.getSggCode
import com.kids.constants.getSidoCode
import com.kids.databinding.FragmentDaycareCenterBinding
import com.kids.ui.main.model.DaycareCenterModel
import com.kids.ui.main.viewmodel.DaycareCenterViewModel
import com.orhanobut.logger.Logger
import com.tedpark.tedpermission.rx2.TedRx2Permission
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.collections.set

@AndroidEntryPoint
class DaycareCenterFragment : BaseFragment<FragmentDaycareCenterBinding>(
    R.layout.fragment_daycare_center
), BaseViewInitComponent {

    private val daycareCenterViewModel by viewModels<DaycareCenterViewModel>()
    lateinit var adapterPaging: BasePagingDataAdapter<DaycareCenterModel>
    private var searchJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setupObserve()
        initAdapter()
        initListener()
    }

    override fun bindViewModel() {
        binding.vm = daycareCenterViewModel
    }

    override fun setupObserve() {
        daycareCenterViewModel.onClickedCall.observe(
            viewLifecycleOwner,
            Observer { daycareCenterModel ->
                context?.let {
                    TedRx2Permission.with(it)
                        .setRationaleTitle(R.string.dialog_title_common_permission)
                        .setRationaleMessage(R.string.dialog_message_request_call_permission)
                        .setPermissions(Manifest.permission.CALL_PHONE)
                        .request()
                        .subscribe { tedPermissionResult, throwable ->
                            tedPermissionResult?.run {
                                if (tedPermissionResult.isGranted) {
                                    val intent =
                                        Intent(
                                            Intent.ACTION_CALL, Uri.parse(
                                                "tel:" + daycareCenterModel.telno
                                            )
                                        )
                                    startActivity(intent)
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Permission Denied\n" + tedPermissionResult.deniedPermissions.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            throwable?.run {
                                Toast.makeText(
                                    context,
                                    throwable.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            })
    }

    private fun initAdapter() {
        val adapterViewModels = ArrayMap<Int, ViewModel>().apply {
            this[BR.daycareCenterViewModel] = daycareCenterViewModel
        }

        val viewHolderIdData =
            ViewHolderIdData(R.layout.item_daycare_center, BR.daycareCenterModel, BR.itemPosition)

        adapterPaging = BasePagingDataAdapter(
            viewHolderIdData = viewHolderIdData,
            viewModels = adapterViewModels,
            diffCallback = DaycareCenterDiffer()
        )

        adapterPaging.addLoadStateListener { loadState ->
            /*
             * loadState.refresh - represents the load state for loading the PagingData for the first time.
             * loadState.prepend - represents the load state for loading data at the start of the list.
             * loadState.append - represents the load state for loading data at the end of the list.
             *
             */
            if (loadState.refresh is LoadState.Loading ||
                loadState.append is LoadState.Loading
            ) {
                showProgressBar(true)
            } else {
                showProgressBar(false)
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
        binding.rvList.adapter = adapterPaging

        //add dividers
        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.rvList.addItemDecoration(decoration)

        binding.spinnerSido.adapter =
            context?.let {
                ArrayAdapter(
                    it, android.R.layout.simple_spinner_dropdown_item, areaData.map { areaData ->
                        areaData.sidoName
                    }.distinct()
                )
            }
    }

    private fun initListener() {

        binding.spinnerSido.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedSido = binding.spinnerSido.getItemAtPosition(position).toString()
                setSpinnerSggAdapter(selectedSido)
            }
        }
        binding.spinnerSgg.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val sidoSelectedStr = binding.spinnerSido.selectedItem.toString()
                val sggSelectedStr = binding.spinnerSgg.selectedItem.toString()

                val sidoCode = getSidoCode(sidoSelectedStr)
                val sggCode = getSggCode(sidoSelectedStr, sggSelectedStr)

                Logger.d("test >>> 시도  $sidoSelectedStr 시군구 $sggSelectedStr")
                Logger.d("test >>> 시도 코드 $sidoCode 시군구 코드 $sggCode")

                search(sidoCode, sggCode)
            }
        }
    }

    private fun setSpinnerSggAdapter(sido: String) {
        binding.spinnerSgg.adapter =
            context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_dropdown_item,
                    areaData.filter { areaData ->
                        areaData.sidoName == sido
                    }.map { areaData ->
                        areaData.sggName
                    }
                )
            }
    }

    private fun search(sidoCode: String, sggCode: String) {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            daycareCenterViewModel.getCenterListStream(sidoCode, sggCode).collect {
                adapterPaging.submitData(it)
            }
        }
    }

    private fun showProgressBar(display: Boolean) {
        binding.progressLoading.run {
            if (!display)
                this.visibility = View.GONE
            else
                this.visibility = View.VISIBLE
        }
    }
}
