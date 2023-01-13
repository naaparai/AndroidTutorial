package com.example.androidtutorial.heterogenous.viewholder

import com.example.androidtutorial.databinding.VhTextBinding
import com.example.androidtutorial.heterogenous.model.TextCard

class TextViewViewHolder(viewDataBinding: VhTextBinding) :
    HeteroBaseVH<TextCard, VhTextBinding>(viewDataBinding) {
    override fun bindData(card: TextCard) {
    }
}
