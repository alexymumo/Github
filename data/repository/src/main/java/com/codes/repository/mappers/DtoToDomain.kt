package com.codes.repository.mappers

import com.codes.domain.models.User
import com.codes.remote.dto.UserDto


internal fun UserDto.toDomain(): User {
    return User(
        this.avatar_url,
        this.bio,
        this.blog,
        this.collaborators ,
        this.company ,
        this.created_at ,
        this.disk_usage ,
        this.email ,
        this.events_url ,
        this.followers ,
        this.followers_url ,
        this.following ,
        this.following_url ,
        this.gists_url ,
        this.gravatar_id ,
        this.hireable,
        this.html_url ,
        this.id ,
        this.location ,
        this.login ,
        this.name ,
        this.node_id ,
        this.organizations_url ,
        this.owned_private_repos ,
        this.private_gists ,
        this.public_gists ,
        this.public_repos ,
        this.received_events_url ,
        this.repos_url ,
        this.site_admin,
        this.starred_url ,
        this.subscriptions_url ,
        this.total_private_repos ,
        this.twitter_username ,
        this.two_factor_authentication,
        this.type,
        this.updated_at,
        this.url
    )
}