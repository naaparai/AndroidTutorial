package com.example.androidtutorial.heterogenous.viewholder

import com.example.androidtutorial.databinding.VhImageBinding
import com.example.androidtutorial.heterogenous.model.ImageCard

class ImageViewHolder(viewDataBinding: VhImageBinding) :
    HeteroBaseVH<ImageCard, VhImageBinding>(viewDataBinding) {
    override fun bindData(card: ImageCard) {
        super.bindData(card)
    }
}
