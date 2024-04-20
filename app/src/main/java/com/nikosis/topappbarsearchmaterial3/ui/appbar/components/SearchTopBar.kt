package com.nikosis.topappbarsearchmaterial3.ui.appbar.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikosis.topappbarsearchmaterial3.R
import com.nikosis.topappbarsearchmaterial3.ui.theme.TopAppBarSearchMaterial3Theme

@Composable
fun SearchTopBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shadowElevation = 5.dp,
        color = MaterialTheme.colorScheme.primary
    ) {
        Image(
            painter = painterResource(R.drawable.ic_top_app_bar_bg_search),
            contentDescription = stringResource(id = R.string.background_image),
            contentScale = ContentScale.FillBounds
        )
        TextField(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            value = text,
            onValueChange = { onTextChanged(it) },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(0.9F),
                    text = stringResource(R.string.search_here),
                    color = MaterialTheme.colorScheme.primary
                )
            },
            singleLine = true,
            leadingIcon = {
                IconButton(modifier = Modifier
                    .alpha(0.9F),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(id = R.string.search_icon),
                        tint = MaterialTheme.colorScheme.surfaceTint
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChanged("")
                        } else {
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(R.string.close_icon)
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { onSearchClicked(text) }
            ),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = Color.DarkGray
            ),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SearchTopBarPreview() {
    TopAppBarSearchMaterial3Theme {
        SearchTopBar(
            text = "Some text",
            onTextChanged = {},
            onSearchClicked = {},
            onCloseClicked = {}
        )
    }
}