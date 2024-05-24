package com.mahmoudhamdyae.elegance.home.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mahmoudhamdyae.elegance.core.UiState
import com.mahmoudhamdyae.elegance.core.composables.screens.ErrorScreen
import com.mahmoudhamdyae.elegance.core.composables.screens.LoadingScreen
import com.mahmoudhamdyae.elegance.home.domain.models.Category
import com.mahmoudhamdyae.elegance.home.presentation.viewmodels.HomeUiState
import com.mahmoudhamdyae.elegance.home.presentation.viewmodels.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = getViewModel<HomeViewModel>()
) {
    val uiState = viewModel.uiState.collectAsState ().value
    Box(
        modifier = modifier
    ) {
        when(
            uiState.categoriesUiState
        ) {
            is UiState.Loading -> {
                LoadingScreen()
            }
            is UiState.Success -> {
                HomeScreenContent(uiState)
            }
            is UiState.Error -> {
                ErrorScreen(errorMessage = uiState.categoriesUiState.message ?: "")
            }
        }
    }
}

@Composable
fun HomeScreenContent(
    uiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    CategoriesList(uiState.categoriesUiState.data ?: emptyList(), modifier)
}

@Composable
fun CategoriesList(
    categories: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
    ) {
        items(categories.size) { index ->
            CategoryItem(category = categories[index])
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp)
    ) {
        Text(text = category.name)
    }
}