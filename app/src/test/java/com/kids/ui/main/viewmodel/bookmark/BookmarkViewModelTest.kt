package com.kids.ui.main.viewmodel.bookmark

import com.kids.ui.InstantExecutorExtension
import com.kids.ui.bookmark.model.BookmarkModel
import com.kids.ui.bookmark.repository.BookmarkRepository
import com.kids.ui.bookmark.viewmodel.BookmarkViewModel
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(InstantExecutorExtension::class)
class BookmarkViewModelTest {

    private val repository: BookmarkRepository = mockk(relaxed = true)
    private lateinit var viewModel: BookmarkViewModel

//    @Mock
//    private lateinit var mockContext: Context

    @BeforeEach
    fun setup() {
        viewModel = BookmarkViewModel(repository)
    }

    @Test
    fun `북마크 리스트를 불러옵니다`() = runBlocking {
        val mockResponse: List<BookmarkModel> = listOf(mockk(relaxed = true))
    }

}