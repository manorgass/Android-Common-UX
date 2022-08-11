package com.manorgass.android.android_common_ux

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.manorgass.android.android_common_ux.databinding.DialogAdBinding

class AdDialogFragment(
    private val thumbnailUrl: String = DEFAULT_IMAGE_URL
) : BottomSheetDialogFragment() {

    private var _binding: DialogAdBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AdBottomSheetDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogAdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.btnClose.setOnClickListener { dismiss() }

        binding.btnNeverShow.setOnClickListener {
            //TODO: Set Don't Show Again Flog...
            dismiss()
        }

        Glide.with(requireContext())
            .load(thumbnailUrl)
            .centerCrop()
            .transform(CenterCrop(), RoundedCorners(20))
            .into(binding.imgThumbnail)
    }

    companion object {
        const val TAG = "AdDialog"
        private const val DEFAULT_IMAGE_URL =
            "https://images.velog.io/images/haero_kim/post/bcf6a951-2df1-4f21-a4af-e106f086c509/general.png"

        fun show(fm: FragmentManager) {
            AdDialogFragment().show(fm, TAG)
        }
    }
}