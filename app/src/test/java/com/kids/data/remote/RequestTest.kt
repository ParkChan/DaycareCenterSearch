package com.kids.data.remote

import com.kids.constants.DayCareConstants
import com.kids.data.remote.source.CenterListDataSourceImpl
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals

@HiltAndroidTest
class RequestTest {

    @Test
    fun `Mockk Response를 이용한 유치원 목록을 가져오는 테스트`() = runBlockingTest {
        val repos = CenterListDataSourceImpl(MockDayCareService).getDayCareCenters(
            key = DayCareConstants.API_KEY,
            currentPage = 1,
            pageCount = 30,
            sidoCode = "11",
            sggCode = "11140"
        )
        assertEquals(repos.body(), testRepos)
    }

    @Test
    fun `실 Response를 이용한 유치원 목록을 가져오는 테스트`() = runBlockingTest {

    }
}