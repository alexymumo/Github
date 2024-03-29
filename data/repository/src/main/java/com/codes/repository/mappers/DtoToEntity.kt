package com.codes.repository.mappers

import com.codes.cache.entity.*
import com.codes.remote.dto.*

internal fun UserDto.toEntity(): UserEntity {
    return UserEntity(
        this.avatar_url,
        this.bio,
        this.blog,
        this.collaborators,
        this.company,
        this.created_at,
        this.disk_usage,
        this.email,
        this.events_url,
        this.followers,
        this.followers_url,
        this.following,
        this.following_url,
        this.gists_url,
        this.gravatar_id,
        this.hireable,
        this.html_url,
        this.id,
        this.location,
        this.login, this.name, this.node_id, this.organizations_url, this.owned_private_repos, this.private_gists, this.public_gists, this.public_repos, this.received_events_url, this.repos_url, this.site_admin, this.starred_url, this.subscriptions_url, this.total_private_repos, this.twitter_username, this.two_factor_authentication, this.type, this.updated_at, this.url)
}

internal fun FollowersDto.toEntity(): FollowersEntity {
    return FollowersEntity(
        this.avatar_url,
        this.events_url,
        this.followers_url,
        this.following_url,
        this.gists_url,
        this.gravatar_id,
        this.html_url,
        this.id,
        this.login,
        this.node_id,
        this.organizations_url,
        this.received_events_url,
        this.repos_url,
        this.site_admin,
        this.starred_url,
        this.subscriptions_url,
        this.type,
        this.url
    )
}

internal fun FollowingDto.toEntity(): FollowingEntity {
    return FollowingEntity(
        this.avatar_url,
        this.events_url,
        this.followers_url,
        this.following_url,
        this.gists_url,
        this.gravatar_id,
        this.html_url,
        this.id,
        this.login,
        this.node_id,
        this.organizations_url,
        this.received_events_url,
        this.repos_url,
        this.site_admin,
        this.starred_url,
        this.subscriptions_url,
        this.type,
        this.url
    )
}

internal fun OwnerDto.toEntity(): OwnerEntity {
    return OwnerEntity(
        this.avatar_url
    )
}

internal fun RepositoriesDto.toEntity(): RepositoriesEntity {
    return RepositoriesEntity(
        this.description ,
        this.id ,
        this.name,
        this.owner.toEntity(),
        this.language,
        this.created_at,
        this.watchers_count,
        this.forks_count,
        this.stargazers_count
    )
}