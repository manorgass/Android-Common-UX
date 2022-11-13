package com.manorgass.android.android_common_ux

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.manorgass.android.android_common_ux.data.Sample
import com.manorgass.android.android_common_ux.databinding.ActivitySelectSampleBinding
import com.manorgass.android.android_common_ux.ui.motion.MotionLayoutActivity

class SelectSampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectSampleBinding

    private val sampleItemClickCallback: (Sample) -> Unit = {
        when (it) {
            Sample.MOTION_LAYOUT -> Intent(
                this,
                MotionLayoutActivity::class.java
            ).also { startActivity(it) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectSampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.sampleList.adapter = SampleAdapter(sampleItemClickCallback)
    }
}