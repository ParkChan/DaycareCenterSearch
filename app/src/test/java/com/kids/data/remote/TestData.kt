package com.kids.data.remote

import com.kids.data.remote.response.DayCareCenterListResponse
import com.kids.data.remote.response.DaycareCenterResponse

const val reposDelay = 1_000L

val testDaycareCenters = listOf(
    DaycareCenterResponse(
        "0001",
        "가 유치원",
        "주소 가",
        "070-0000-0001",
        "오전8시~오후6시"
    ),
    DaycareCenterResponse(
        "0002",
        "나 유치원",
        "주소 나",
        "070-0000-0002",
        "오전9시~오후6시"
    ),
    DaycareCenterResponse(
        "0002",
        "다 유치원",
        "주소 다",
        "070-0000-0003",
        "오전10시~오후6시"
    )
)

val testRepos = DayCareCenterListResponse(
    1,
    1,
    "11",
    "11140",
    "SUCCESS",
    testDaycareCenters
)
