package com.kids.ui.bookmark

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.ArrayMap
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import com.kids.BR
import com.kids.R
import com.kids.common.base.BaseFragment
import com.kids.common.base.component.ViewModelComponent
import com.kids.common.data.ViewHolderIdData
import com.kids.databinding.FragmentBookmarkBinding
import com.kids.ui.bookmark.adapter.BookmarkAdapter
import com.kids.ui.bookmark.adapter.BookmarkDiffer
import com.kids.ui.bookmark.viewmodel.BookmarkViewModel
import com.tedpark.tedpermission.rx2.TedRx2Permission
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkFragment : BaseFragment<FragmentBookmarkBinding>(
    R.layout.fragment_bookmark
) , ViewModelComponent {

    private val bookmarkViewModel by viewModels<BookmarkViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setupObserve()
        initAdapter()
        initBookmarkList()
    }

    override fun bindViewModel() {
        binding.bookmarkViewModel = bookmarkViewModel
    }

    override fun setupObserve() {
        binding.bookmarkViewModel?.bookmarkListData?.observe(
            viewLifecycleOwner,
            Observer {
                if (it.isNotEmpty()) {
                    binding.rvList.visibility = View.VISIBLE
                    binding.tvEmptyList.visibility = View.GONE

                } else {
                    binding.rvList.visibility = View.GONE
                    binding.tvEmptyList.visibility = View.VISIBLE
                }
            })

        bookmarkViewModel.onClickedCall.observe(
            viewLifecycleOwner,
            Observer { bookmarModel ->
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
                                                "tel:" + bookmarModel.telno
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

    private fun initAdapter(){
        val adapterViewModels = ArrayMap<Int, ViewModel>().apply {
            this[BR.bookmarkViewModel] = bookmarkViewModel
        }

        val viewHolderIdData =
            ViewHolderIdData(R.layout.item_book_mark, BR.bookmarkModel, BR.itemPosition)

        val bookmarkAdapter = BookmarkAdapter(
            viewHolderIdData = viewHolderIdData,
            viewModels = adapterViewModels,
            diffCallback = BookmarkDiffer()
        )

        binding.rvList.adapter = bookmarkAdapter

        //add dividers
        val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.rvList.addItemDecoration(decoration)

    }

    fun initBookmarkList(){
        binding.bookmarkViewModel?.selectAll(binding.root.context)
    }

}