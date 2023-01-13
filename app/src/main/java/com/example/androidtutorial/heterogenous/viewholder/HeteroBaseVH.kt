package com.example.androidtutorial.heterogenous.viewholder

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtutorial.BR
import com.example.androidtutorial.heterogenous.model.HeteroCard

abstract class HeteroBaseVH<C : HeteroCard, VB : ViewDataBinding>(protected var viewDataBinding: VB) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    val context: Context get() = viewDataBinding.root.context
    private var itemCard: C? = null

    @Suppress("UNCHECKED_CAST")
    fun bind(heteroCard: HeteroCard) {
        itemCard = heteroCard as C
        viewDataBinding.setVariable(getItemBindingId(), itemCard)
        bindData(heteroCard)
        viewDataBinding.executePendingBindings()
    }

    private fun getItemBindingId(): Int {
        return BR.card
    }

    open fun bindData(card: C) {
        // default does nothing
    }
}
