package com.codes.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
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
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val location: String?,
    val login: String?,
    val name: String?,
    val node_id: String,
    val organizations_url: String,
    val owned_private_repos: Int,
    val private_gists: Int,
    val public_gists: Int,
    val public_repos: Int,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val total_private_repos: Int,
    val twitter_username: String?,
    val two_factor_authentication: Boolean,
    val type: String,
    val updated_at: String,
    val url: String
)