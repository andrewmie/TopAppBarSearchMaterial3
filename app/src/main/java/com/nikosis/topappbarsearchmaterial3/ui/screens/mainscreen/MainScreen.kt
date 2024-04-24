package com.nikosis.topappbarsearchmaterial3.ui.screens.mainscreen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nikosis.topappbarsearchmaterial3.ui.appbar.MainTopBar
import com.nikosis.topappbarsearchmaterial3.ui.appbar.MainViewModel
import com.nikosis.topappbarsearchmaterial3.ui.appbar.components.SearchBarState

@Composable
fun MainScreen(mainViewModel: MainViewModel) {
    val searchBarState by mainViewModel.searchBarState
    val searchTextState by mainViewModel.searchTextState

    Scaffold(modifier = Modifier
        .fillMaxSize(),
        topBar = {
            MainTopBar(
                searchBarState = searchBarState,
                searchTextState = searchTextState,
                onTextChange = { newText ->
                    mainViewModel.setSearchTextState(newValue = newText)
                },
                onSearchClicked = { searchedText ->
                    Log.d("MainScreen: Searched Text: ", searchedText)
                },
                onCloseClicked = {
                    mainViewModel.setSearchBarState(newValue = SearchBarState.CLOSED)
                },
                onAppBarSearchClicked = {
                    mainViewModel.setSearchBarState(newValue = SearchBarState.OPENED)
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(100) {
                Text(modifier = Modifier.padding(16.dp), text = "Example Item $it")
            }
        }
    }
}