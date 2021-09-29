package com.kids.ui.main.viewmodel.main

import com.kids.coroutine.MainCoroutineRule
import com.kids.data.remote.DaycareCenterRepository
import com.kids.ui.InstantExecutorExtension
import com.kids.ui.bookmark.repository.BookmarkRepository
import com.kids.ui.main.viewmodel.DaycareCenterViewModel
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.RegisterExtension


@ExtendWith(InstantExecutorExtension::class)
@HiltAndroidTest
class DayCareCenterViewModelTest {

    private val daycareCenterRepository: DaycareCenterRepository = mockk(relaxed = true)
    private val bookmarkRepository: BookmarkRepository = mockk(relaxed = true)
    private lateinit var viewModel: DaycareCenterViewModel

    companion object {
        @JvmField
        @RegisterExtension
        val mainCoroutineRule = MainCoroutineRule()
    }

    @BeforeEach
    fun setup() {
        viewModel = DaycareCenterViewModel(daycareCenterRepository, bookmarkRepository)
    }

    @Test
    fun `유치원 목록을 가져옵니다`() = mainCoroutineRule.runBlockingTest {

        //val mockRes: DayCareCenterListResponse = mockk(relaxed = true)
        val sidoCode = "11"
        val sggCode = "11140"

        viewModel.getCenterListStream(sidoCode = sidoCode, sggCode = sggCode).collect {
            println(it)
        }
        //val mockResponse: List<BookmarkModel> = listOf(mockk(relaxed = true))
    }

}