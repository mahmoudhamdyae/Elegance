package com.mahmoudhamdyae.elegance.home.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.mahmoudhamdyae.elegance.core.UiState
import com.mahmoudhamdyae.elegance.core.composables.screens.ErrorScreen
import com.mahmoudhamdyae.elegance.core.composables.screens.LoadingScreen
import com.mahmoudhamdyae.elegance.home.domain.models.Category
import com.mahmoudhamdyae.elegance.home.presentation.viewmodels.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = getViewModel<HomeViewModel>()
) {
    val uiState: UiState<List<Category>> = viewModel.uiState.collectAsState ().value.categoriesUiState
    Box(
        modifier = modifier
    ) {
        when(
            uiState
        ) {
            is UiState.Loading -> {
                LoadingScreen()
            }
            is UiState.Success -> {
                HomeScreenContent(uiState.data ?: emptyList())
            }
            is UiState.Error -> {
                ErrorScreen(errorMessage = uiState.message ?: "")
            }
        }
    }
}

@Composable
fun HomeScreenContent(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
    ) {
        items(categories.size) { index ->
            Text(text = categories[index].name)
        }
    }
}