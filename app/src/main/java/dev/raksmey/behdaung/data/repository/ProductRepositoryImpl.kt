package dev.raksmey.behdaung.data.repository

import dev.raksmey.behdaung.core.util.Resource
import dev.raksmey.behdaung.data.mapper.toDomain
import dev.raksmey.behdaung.data.remote.ProductApi
import dev.raksmey.behdaung.domain.model.Product
import dev.raksmey.behdaung.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {

    override fun getProducts(): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        try {
            val remoteData = api.getProducts()
            val domainProducts = remoteData.products.map { it.toDomain() }
            emit(Resource.Success(domainProducts))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
        }
    }
}