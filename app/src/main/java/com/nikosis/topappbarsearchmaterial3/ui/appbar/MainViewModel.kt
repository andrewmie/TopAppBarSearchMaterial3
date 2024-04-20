package com.nikosis.topappbarsearchmaterial3.ui.appbar

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nikosis.topappbarsearchmaterial3.ui.appbar.components.SearchBarState

class MainViewModel : ViewModel() {
    private val _searchBarState: MutableState<SearchBarState> =
        mutableStateOf(value = SearchBarState.CLOSED)
    val searchBarState: State<SearchBarState> = _searchBarState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun setSearchBarState(newValue: SearchBarState) {
        _searchBarState.value = newValue
    }

    fun setSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }
}