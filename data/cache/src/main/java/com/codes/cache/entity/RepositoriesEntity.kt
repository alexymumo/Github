package com.codes.cache.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repository_table")
data class RepositoriesEntity(
    val description: String?,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    @Embedded
    val owner: OwnerEntity
)
