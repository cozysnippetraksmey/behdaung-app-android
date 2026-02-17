package dev.raksmey.behdaung.domain.repository

import dev.raksmey.behdaung.core.util.Resource
import dev.raksmey.behdaung.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(): Flow<Resource<List<Product>>>
}