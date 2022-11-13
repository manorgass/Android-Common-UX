package com.manorgass.android.android_common_ux.data

import androidx.annotation.StringRes
import com.manorgass.android.android_common_ux.R

enum class Sample(
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int
) {
    MOTION_LAYOUT(R.string.sample_motion_layout_title, R.string.sample_motion_layout_description)
}