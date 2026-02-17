package dev.raksmey.behdaung.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.raksmey.behdaung.core.util.Resource
import dev.raksmey.behdaung.domain.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProductUiState())
    val state = _state.asStateFlow()

    init { getProducts() }

    fun getProducts() {
        repository.getProducts().onEach { result ->
            when (result) {
                is Resource.Loading -> _state.update { it.copy(isLoading = true) }
                is Resource.Success -> _state.update { it.copy(isLoading = false, products = result.data ?: emptyList()) }
                is Resource.Error -> _state.update { it.copy(isLoading = false, error = result.message) }
            }
        }.launchIn(viewModelScope)
    }
}