package com.nikosis.topappbarsearchmaterial3.ui.appbar

import androidx.compose.runtime.Composable
import com.nikosis.topappbarsearchmaterial3.ui.appbar.components.SearchBarState
import com.nikosis.topappbarsearchmaterial3.ui.appbar.components.SearchTopBar
import com.nikosis.topappbarsearchmaterial3.ui.appbar.components.TopBar

@Composable
fun MainTopBar(
    searchBarState: SearchBarState,
    searchTextState: String,
    onAppBarSearchClicked: () -> Unit,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
) {
    when (searchBarState) {
        SearchBarState.CLOSED -> {
            TopBar(
                onSearchClicked = onAppBarSearchClicked,
                onShareClicked = { /*TODO*/ },
                onProfileClicked = { /*TODO*/ },
                onSettingsClicked = { /*TODO*/ },
                onAboutClicked = { /*TODO*/ },
            )
        }

        SearchBarState.OPENED -> {
            SearchTopBar(
                text = searchTextState,
                onTextChanged = onTextChange,
                onSearchClicked = onSearchClicked,
                onCloseClicked = onCloseClicked,
            )
        }
    }
}