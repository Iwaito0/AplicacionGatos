package com.ivanvegagonzalez.myapplication2frag.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ivanvegagonzalez.myapplication2frag.model.Conctato

class DetailViewModel(conctato: Conctato): ViewModel() {
    private val _conctato = MutableLiveData(conctato)
    val movie: LiveData<Conctato> get() = _conctato
}

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(private val conctato: Conctato): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(conctato) as T
    }

}