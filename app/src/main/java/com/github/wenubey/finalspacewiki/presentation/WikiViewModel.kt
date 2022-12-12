package com.github.wenubey.finalspacewiki.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wenubey.finalspacewiki.data.repository.WikiRepository
import com.github.wenubey.finalspacewiki.domain.util.Resource
import com.github.wenubey.finalspacewiki.presentation.wikidetail.CharacterDataState
import com.github.wenubey.finalspacewiki.presentation.wikilist.ListDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
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

    init {
        loadCharactersList(true)
    }

    fun loadCharactersList(
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            repository
                .getCharactersData(fetchFromRemote = fetchFromRemote)
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { characters ->
                                listDataState = listDataState.copy(
                                    characters = characters,
                                )
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            listDataState = listDataState.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                }
        }
    }

    fun loadCharacter(
        id: Int,
        fetchFromRemote: Boolean = false,
    ) {
        viewModelScope.launch {
            repository
                .getCharacterData(id = id, fetchFromRemote = fetchFromRemote)
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            characterDataState = characterDataState.copy(
                                data = result.data
                            )
                        }
                        is Resource.Loading -> {
                            characterDataState = characterDataState.copy(
                                isLoading = result.isLoading
                            )
                        }
                        is Resource.Error -> Unit
                    }
                }
        }
    }

}