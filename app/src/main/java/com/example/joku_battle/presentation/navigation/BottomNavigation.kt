package com.example.joku_battle.presentation.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach

@Composable
fun BottomNavigation(
    selectedItem: BottomNavigationItem,
    onItemSelected: (BottomNavigationItem) -> Unit,
    modifier: Modifier = Modifier,
    selectedItemColor: Color = Color(0xFFFAC929),
    unselectedItemColor: Color = Color(0xFFAAAAAA)
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        BottomNavigationItem.entries.fastForEach {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onItemSelected(it) }
                    .padding(vertical = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    tint = if (selectedItem == it) selectedItemColor else unselectedItemColor,
                    imageVector = ImageVector.vectorResource(it.iconRes),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = it.text,
                    color = if (selectedItem == it) selectedItemColor else unselectedItemColor
                )
            }
        }
    }
}