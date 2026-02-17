package dev.raksmey.behdaung.ui.products

import dev.raksmey.behdaung.domain.model.Product

data class ProductUiState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)