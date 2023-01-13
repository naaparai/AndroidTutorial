package com.example.androidtutorial.heterogenous.factory

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseVHFactory {
    private var inflater: LayoutInflater? = null
    abstract fun create(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    fun <VB : ViewDataBinding> getViewBinder(parent: ViewGroup, layoutId: Int): VB {
        return DataBindingUtil.inflate(getInflater(parent.context), layoutId, parent, false)
    }

    private fun getInflater(context: Context): LayoutInflater {
        if (inflater == null) {
            inflater = LayoutInflater.from(context)
        }
        return inflater!!
    }
}
