package com.manorgass.android.android_common_ux.data

import androidx.annotation.StringRes
import com.manorgass.android.android_common_ux.R

enum class Sample(
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int
) {
    MOTION_LAYOUT(R.string.sample_motion_layout_title, R.string.sample_motion_layout_description),

    COORDINATOR_LAYOUT(
        R.string.sample_coordinator_layout_title,
        R.string.sample_coordinator_layout_description
    ),

    BOTTOM_SHEET(
        R.string.sample_bottom_sheet_title,
        R.string.sample_bottom_sheet_description
    )
}