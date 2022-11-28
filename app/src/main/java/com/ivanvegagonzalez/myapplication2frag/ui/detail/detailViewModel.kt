package com.ivanvegagonzalez.myapplication2frag.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ivanvegagonzalez.myapplication2frag.model.Gatos

class DetailViewModel(gato: Gatos): ViewModel() {
    private val _gatos = MutableLiveData(gato)
    val gato: LiveData<Gatos> get() = _gatos

}


@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val gatos: Gatos): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(gatos) as T
    }

}