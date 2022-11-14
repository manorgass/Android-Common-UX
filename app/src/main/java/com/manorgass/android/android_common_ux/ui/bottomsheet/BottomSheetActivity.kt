package com.manorgass.android.android_common_ux.ui.bottomsheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.manorgass.android.android_common_ux.databinding.ActivityBottomSheetBinding

class BottomSheetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {

    }
}