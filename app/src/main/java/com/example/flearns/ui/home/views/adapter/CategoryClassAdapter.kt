package com.example.flearns.ui.home.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.flearns.databinding.FragmentCatClassItemBinding
import com.example.flearns.domain.model.CategoryModel
import com.example.flearns.domain.model.ConstantGeneral.Companion.CODE
import com.example.flearns.domain.model.ConstantGeneral.Companion.EMPTY

class CategoryClassAdapter(
    private val dataSource: MutableList<CategoryModel>,
    private var onListHitItemClickListener: ((categoryModel: CategoryModel, type:String) -> Unit),
    private val context: Context
) : RecyclerView.Adapter<CategoryClassAdapter.ViewHolder>() {

    inner class ViewHolder(
        private var binding: FragmentCatClassItemBinding,
        private var ctx: Context,
        private var onListHitItemClickListener: ((categoryModel: CategoryModel, type:String) -> Unit)
    ) : RecyclerView.ViewHolder(binding!!.root)
    {
        var root: ConstraintLayout = binding.layoutItemCategory

        fun bind(dataSource: CategoryModel){
            binding?.idCat?.text = dataSource.id.toString()
            binding?.tvNameCat?.text = dataSource.name
            Glide.with(context)
                .load(dataSource.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding!!.imgCat)

            binding.idCat.setOnClickListener {

                onListHitItemClickListener.invoke(dataSource,CODE)
            }

            binding.imgCat.setOnClickListener {
                onListHitItemClickListener.invoke(dataSource, EMPTY)
            }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentCatClassItemBinding.inflate(
            LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ViewHolder(binding, viewGroup.context, onListHitItemClickListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val categoryModel: CategoryModel = dataSource[position]
        viewHolder.bind(categoryModel)
    }

    override fun getItemCount() = dataSource.size

}