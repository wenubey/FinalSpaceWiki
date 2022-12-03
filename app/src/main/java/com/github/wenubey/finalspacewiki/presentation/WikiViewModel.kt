package com.github.wenubey.finalspacewiki.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wenubey.finalspacewiki.data.repository.WikiRepository
import com.github.wenubey.finalspacewiki.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WikiViewModel @Inject constructor(
    private val repository: WikiRepository,
) : ViewModel() {

    var listDataState by mutableStateOf(ListDataState())
        private set

    var characterDataState by mutableStateOf(CharacterDataState())
        private set

    fun loadCharactersList() {
        viewModelScope.launch {
            listDataState = listDataState.copy(
                isLoading = true,
                error = null,
            )
            when(val result = repository.getCharactersData()) {
                is Resource.Success -> {
                    listDataState = listDataState.copy(
                        data = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    listDataState = listDataState.copy(
                        data = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }

    fun loadCharacter(id: Int) {
        viewModelScope.launch {
            characterDataState = characterDataState.copy(
                isLoading = true,
                error = null,
            )
            when(val result = repository.getCharacterData(id = id)){
                is Resource.Success -> {
                    characterDataState = characterDataState.copy(
                        data = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error  -> {
                    characterDataState = characterDataState.copy(
                        data = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}