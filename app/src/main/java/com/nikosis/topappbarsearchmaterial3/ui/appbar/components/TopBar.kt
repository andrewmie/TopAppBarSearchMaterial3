package com.nikosis.topappbarsearchmaterial3.ui.appbar.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikosis.topappbarsearchmaterial3.R
import com.nikosis.topappbarsearchmaterial3.ui.theme.TopAppBarSearchMaterial3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onSearchClicked: () -> Unit,
    onShareClicked: () -> Unit,
    onProfileClicked: () -> Unit,
    onSettingsClicked: () -> Unit,
    onAboutClicked: () -> Unit,
) {
    var menuExpanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_top_app_bar_bg),
            contentDescription = stringResource(R.string.background_image),
            contentScale = ContentScale.FillBounds,
        )
        TopAppBar(
            modifier = Modifier
                .fillMaxWidth(),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
            windowInsets = TopAppBarDefaults.windowInsets,
            title = { Text(text = "TopAppBar Home") },
            actions = {
                IconButton(onClick = onSearchClicked) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.search_icon)
                    )
                }
                IconButton(onClick = onShareClicked) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = stringResource(R.string.share)
                    )
                }
                IconButton(onClick = { menuExpanded = !menuExpanded }) {
                    Icon(
                        imageVector = Icons.Filled.ExpandMore,
                        contentDescription = stringResource(R.string.more_options)
                    )
                }
                DropdownMenu(expanded = menuExpanded, onDismissRequest = { menuExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = stringResource(R.string.profile)) },
                        onClick = { onProfileClicked() })
                    DropdownMenuItem(
                        text = { Text(text = stringResource(R.string.settings)) },
                        onClick = { onSettingsClicked() })
                    DropdownMenuItem(
                        text = { Text(text = stringResource(R.string.about)) },
                        onClick = onAboutClicked
                    )
                }
            }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TopBarPreview() {
    TopAppBarSearchMaterial3Theme {
        TopBar(
            onSearchClicked = { /*TODO*/ },
            onShareClicked = { /*TODO*/ },
            onProfileClicked = { /*TODO*/ },
            onSettingsClicked = { /*TODO*/ },
            onAboutClicked = { /*TODO*/ }
        )
    }
}