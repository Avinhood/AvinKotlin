package com.cts.avind.ui.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cts.avind.data.main.Rows
import com.cts.avind.R
import com.cts.avind.databinding.ItemPostBinding
import com.cts.avind.ui.main.AboutItemViewModel

class AboutListAdapter: RecyclerView.Adapter<AboutListAdapter.ViewHolder>() {
    lateinit var aboutList:List<Rows>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutListAdapter.ViewHolder {
        val binding: ItemPostBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_post, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AboutListAdapter.ViewHolder, position: Int) {
        holder.bind(aboutList[position])
    }

    override fun getItemCount(): Int {
        return if(::aboutList.isInitialized) aboutList.size else 0
    }


    fun updateAboutList(aboutList:List<Rows>){
        this.aboutList = aboutList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemPostBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = AboutItemViewModel()

        fun bind(rows:Rows){
            viewModel.bind(rows)
            binding.viewModel = viewModel

            Glide.with(binding.ivImage.context).load(rows.imageHref).centerInside()
                .placeholder(R.drawable.ic_launcher_background).into(binding.ivImage)
        }
    }
}