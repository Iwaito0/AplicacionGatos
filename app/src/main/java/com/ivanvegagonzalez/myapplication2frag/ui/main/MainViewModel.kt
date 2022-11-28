package com.ivanvegagonzalez.myapplication2frag.ui.main

import androidx.lifecycle.*
import com.ivanvegagonzalez.myapplication2frag.model.Gatos
import com.ivanvegagonzalez.myapplication2frag.model.server.RemoteConnection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(apiKey: String) : ViewModel() {
    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState> get() = _state

    init {
        viewModelScope.launch(Dispatchers.Main) {
            _state.value = _state.value?.copy(loading = true)
            val result = RemoteConnection.service.gatos()
            val gatos = result.map {
                Gatos(
                    it.breedName,
                    it.imgThumb,
                    it.breedDescription
                )
            }
            _state.value = _state.value?.copy(loading = false, gato = gatos)
        }
    }

    fun navigateTo(gato: Gatos) {
        _state.value = _state.value?.copy(navigateTo = gato)
    }

    fun onNavigateDone(){
        _state.value = _state.value?.copy(navigateTo = null)
    }

    data class UiState(
        val loading: Boolean = false,
        val gato: List<Gatos>? = null,
        val navigateTo: Gatos? = null
    )

}
class MainViewModelFactory(private val apiKey: String): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(apiKey) as T
    }
}