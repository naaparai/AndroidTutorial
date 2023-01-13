package com.example.androidtutorial.heterogenous.factory

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.androidtutorial.R
import com.example.androidtutorial.heterogenous.model.HeteroCard
import com.example.androidtutorial.heterogenous.model.HeteroCardType
import com.example.androidtutorial.heterogenous.viewholder.HeteroBaseVH
import com.example.androidtutorial.heterogenous.viewholder.ImageViewHolder
import com.example.androidtutorial.heterogenous.viewholder.TextViewViewHolder

class HeteroVHFactory : BaseVHFactory() {
    override fun create(
        parent: ViewGroup,
        viewType: Int
    ): HeteroBaseVH<out HeteroCard, out ViewDataBinding> {
        return when (viewType) {
            HeteroCardType.IMAGE.index -> ImageViewHolder(getViewBinder(parent, R.layout.vh_image))
            else -> TextViewViewHolder(getViewBinder(parent, R.layout.vh_text))
        }
    }
}
