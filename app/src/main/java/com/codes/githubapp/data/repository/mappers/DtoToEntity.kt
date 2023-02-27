package com.codes.githubapp.data.repository.mappers

import com.codes.githubapp.data.cache.entity.UserEntity
import com.codes.githubapp.data.remote.dto.UserDto


internal fun UserDto.toEntity(): UserEntity {
    return UserEntity(avatar_url, bio, blog, collaborators, company, created_at, disk_usage, email, events_url, followers, followers_url, following, following_url, gists_url, gravatar_id, hireable, html_url, id, location, login, name, node_id, organizations_url, owned_private_repos, private_gists, public_gists, public_repos, received_events_url, repos_url, site_admin, starred_url, subscriptions_url, total_private_repos, twitter_username, two_factor_authentication, type, updated_at, url)
}