package com.ivanvegagonzalez.myapplication2frag.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ivanvegagonzalez.myapplication2frag.model.Conctato
import com.ivanvegagonzalez.myapplication2frag.model.ConctatosProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(): ViewModel() {
    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState> get() = _state

    init {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = _state.value?.copy(loading = true)
            val conctato =  withContext(Dispatchers.IO){ ConctatosProvider.getConctatos()}
            _state.value = _state.value?.copy(loading = false, conctato = conctato)
        }
    }

    fun navigateTo(conctato: Conctato) {
        _state.value = _state.value?.copy(navigateTo = conctato)
    }

    fun onNavigateDone(){
        _state.value = _state.value?.copy(navigateTo = null)
    }

    data class UiState(
        val loading: Boolean = false,
        val conctato: List<Conctato>? = null,
        val navigateTo: Conctato? = null
    )

}