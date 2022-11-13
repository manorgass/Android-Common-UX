package com.manorgass.android.android_common_ux

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manorgass.android.android_common_ux.data.Sample
import com.manorgass.android.android_common_ux.databinding.ListItemSampleBinding

class SampleAdapter(
    private val sampleItemClickCallback: (Sample) -> Unit
) :
    RecyclerView.Adapter<SampleAdapter.SampleViewHolder>() {

    private val sampleBank = Sample.values()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        return SampleViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        holder.bind(sampleBank[position], sampleItemClickCallback)
    }

    override fun getItemCount(): Int {
        return sampleBank.size
    }

    class SampleViewHolder(
        private val binding: ListItemSampleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(sample: Sample, itemClickCallback: (Sample) -> Unit) {
            with(binding) {
                tvTitle.setText(sample.titleResId)
                tvDescriptoin.setText(sample.descriptionResId)
                root.setOnClickListener { itemClickCallback.invoke(sample) }
            }
        }

        companion object {
            fun create(parent: ViewGroup): SampleViewHolder {
                val binding = ListItemSampleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return SampleViewHolder(binding)
            }
        }
    }
}