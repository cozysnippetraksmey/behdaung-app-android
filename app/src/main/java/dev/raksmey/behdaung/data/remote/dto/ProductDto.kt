package dev.raksmey.behdaung.data.remote.dto

// This matches a single product in the JSON array
data class ProductDto(
    val id: Int,
    val title: String,
    val description: String?,
    val price: Double,
    val thumbnail: String,
    val stock: Int?,
    val brand: String?,
    val category: String?
)

// This matches the top-level JSON response object
data class ProductResponse(
    val products: List<ProductDto>,
    val total: Int,
    val skip: Int,
    val limit: Int
)