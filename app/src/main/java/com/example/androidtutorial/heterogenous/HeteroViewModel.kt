package com.example.androidtutorial.heterogenous

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtutorial.heterogenous.model.HeteroCard
import com.example.androidtutorial.heterogenous.model.HeteroCardType
import com.example.androidtutorial.heterogenous.provider.base.HeteroDataProvider
import com.example.androidtutorial.heterogenous.provider.base.HeteroSectionUpdateListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeteroViewModel @Inject constructor(
    private val heteroDataProviders: List<@JvmSuppressWildcards HeteroDataProvider<HeteroCard>>
) : ViewModel(), HeteroSectionUpdateListener<HeteroCard> {
    val sectionAdded = MutableSharedFlow<HeteroCard>()
    val sectionDeleted = MutableSharedFlow<HeteroCardType>()

    init {
        heteroDataProviders.forEach {
            it.setCallback(this)
            viewModelScope.launch {
                it.getCard()
            }
        }
    }

    override fun onSectionAdded(card: HeteroCard) {
        viewModelScope.launch {
            sectionAdded.emit(card)
        }
    }

    override fun onSectionUpdated(card: HeteroCard) {
    }

    override fun onSectionDeleted(cardType: HeteroCardType) {
        viewModelScope.launch {
            sectionDeleted.emit(cardType)
        }
    }

    fun removeImage(isChecked: Boolean) {
        heteroDataProviders.forEach {
            if (HeteroCardType.IMAGE == it.getCardType()) {
                it.removeCard(isChecked, HeteroCardType.IMAGE)
            }
        }
    }
}
