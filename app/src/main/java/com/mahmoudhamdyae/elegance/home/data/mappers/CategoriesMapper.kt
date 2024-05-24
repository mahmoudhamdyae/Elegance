package com.mahmoudhamdyae.elegance.home.data.mappers

import com.mahmoudhamdyae.elegance.home.data.entities.CategoriesEntity
import com.mahmoudhamdyae.elegance.home.data.entities.CategoryEntity
import com.mahmoudhamdyae.elegance.home.domain.models.Categories
import com.mahmoudhamdyae.elegance.home.domain.models.Category

object CategoriesMapper {
    fun transformCategoriesFromEntity(entities: List<CategoryEntity>): Categories {
        val categories = Categories()
        entities.forEach { entity ->
            categories.add(CategoryMapper.transformFromEntity(entity))
        }
        return categories
    }

    fun transformCategoriesToEntity(categories: Categories): List<CategoryEntity> {
        val entities = mutableListOf<CategoryEntity>()
        categories.forEach { category ->
            entities.add(CategoryMapper.transformToEntity(category))
        }
        return entities
    }
}

object CategoryMapper {
    fun transformFromEntity(entity: CategoryEntity): Category {
        return Category(entity.id, entity.image, entity.name)
    }

    fun transformToEntity(category: Category): CategoryEntity {
        return CategoryEntity(category.id, category.image, category.name)
    }
}

fun List<CategoryEntity>.toCategories(): Categories {
    val categories = Categories()
    this.forEach { entity ->
        categories.add(CategoryMapper.transformFromEntity(entity))
    }
    return categories
}

fun Categories.toCategoryEntities(): List<CategoryEntity> {
    val entities = mutableListOf<CategoryEntity>()
    this.forEach { category ->
        entities.add(CategoryMapper.transformToEntity(category))
    }
    return entities
}