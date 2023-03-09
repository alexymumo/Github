package com.codes.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark_table")
data class BookmarkEntity(
    @PrimaryKey
    val id: Int,
    val avatar_url: String,
    val bio: String?,
    val blog: String?,
    val collaborators: Int,
    val company: String?,
    val created_at: String,
    val disk_usage: Int,
    val email: String?,
    val events_url: String,
    val followers: Int,
    val followers_url: String?,
    val following: Int,
    val following_url: String?,
    val gists_url: String,
    val gravatar_id: String,
    val hireable: Boolean,
    val html_url: String,
    val isBookMarked: Boolean = false
)
