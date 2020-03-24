package com.laonsports.kids

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.laonsports.kids.network.api.ChildSchoolService
import com.laonsports.kids.network.api.searchList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service: ChildSchoolService = ChildSchoolService.create()
        searchList(service,
            1,
            30,
            11,
            11710,
            { data -> {} }, { error ->
                {}
            }
        )
    }
}
