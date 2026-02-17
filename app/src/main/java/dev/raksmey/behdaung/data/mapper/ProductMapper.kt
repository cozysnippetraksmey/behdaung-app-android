package dev.raksmey.behdaung.data.mapper

import dev.raksmey.behdaung.data.remote.dto.ProductDto
import dev.raksmey.behdaung.domain.model.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description ?: "No description available",
        price = price,
        thumbnail = thumbnail
    )
}