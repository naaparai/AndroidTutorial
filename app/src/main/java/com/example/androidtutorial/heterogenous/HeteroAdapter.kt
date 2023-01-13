package com.example.androidtutorial.heterogenous

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtutorial.heterogenous.factory.HeteroVHFactory
import com.example.androidtutorial.heterogenous.model.HeteroCard
import com.example.androidtutorial.heterogenous.model.HeteroCardType
import com.example.androidtutorial.heterogenous.viewholder.HeteroBaseVH
import javax.inject.Inject

class HeteroAdapter @Inject constructor(
    private val heteroVHFactory: HeteroVHFactory,
    private val cardList: MutableList<HeteroCard> = mutableListOf()
) : RecyclerView.Adapter<HeteroBaseVH<out HeteroCard, out ViewDataBinding>>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeteroBaseVH<out HeteroCard, out ViewDataBinding> {
        return heteroVHFactory.create(parent, viewType)
    }

    override fun getItemViewType(position: Int) = cardList[position].type.index

    override fun onBindViewHolder(
        holder: HeteroBaseVH<out HeteroCard, out ViewDataBinding>,
        position: Int
    ) {
        holder.bind(cardList[position])
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    fun insertCard(heteroCard: HeteroCard?) {
        heteroCard?.let {
            cardList.add(0, it)
            notifyItemInserted(0)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteItem(cardType: HeteroCardType) {
        cardList.removeAll { it.type == cardType }
        notifyDataSetChanged()
    }
}
