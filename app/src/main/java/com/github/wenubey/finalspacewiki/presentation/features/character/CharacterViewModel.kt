package com.github.wenubey.finalspacewiki.presentation.features.character

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wenubey.finalspacewiki.data.repository.WikiRepository
import com.github.wenubey.finalspacewiki.domain.util.Resource
import com.github.wenubey.finalspacewiki.presentation.features.character.characterdetail.CharacterDataState
import com.github.wenubey.finalspacewiki.presentation.features.character.characterlist.CharacterListDataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: WikiRepository,
) : ViewModel() {

    var characterListDataState by mutableStateOf(CharacterListDataState())
        private set

    var characterDataState by mutableStateOf(CharacterDataState())
        private set

    var searchQuery = mutableStateOf("")
        private set

    private var searchJob: Job? = null

    init {
        loadCharactersList(true)
    }

    fun onSearch(query: String) {
        searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            repository.getCharactersData(true)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { characters ->
                                characterListDataState = characterListDataState.copy(
                                    characters = characters.filter {
                                        it.name.contains(query, ignoreCase = true)
                                    }
                                )
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            characterListDataState = characterListDataState.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                }
        }
    }

    fun loadCharactersList(
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            repository
                .getCharactersData(fetchFromRemote = fetchFromRemote)
                .collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { characters ->
                                characterListDataState = characterListDataState.copy(
                                    characters = characters,
                                )
                            }
                        }
                        //TODO: ADD ERROR SCREEN
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            characterListDataState = characterListDataState.copy(
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
                    when (result) {
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
                        //TODO: ADD ERROR SCREEN
                        is Resource.Error -> Unit
                    }
                }
        }
    }

}