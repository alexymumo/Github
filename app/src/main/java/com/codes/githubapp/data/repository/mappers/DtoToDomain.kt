package com.codes.githubapp.data.repository.mappers

import com.codes.githubapp.data.remote.dto.UserDto
import com.codes.githubapp.domain.models.User

internal fun UserDto.toDomain(): User {
    return User(
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
        this.type, url
    )
}