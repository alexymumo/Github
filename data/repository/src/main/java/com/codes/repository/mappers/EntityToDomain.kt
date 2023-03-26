package com.codes.repository.mappers

import com.codes.cache.entity.*
import com.codes.domain.models.*


internal fun UserEntity.toDomain(): User {
    return User(
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
        this.following_url, this.gists_url, this.gravatar_id, this.hireable, this.html_url, this.id, this.location, this.login, this.name, this.node_id, this.organizations_url, this.owned_private_repos, this.private_gists, this.public_gists, this.public_repos, this.received_events_url, this.repos_url, this.site_admin, this.starred_url, this.subscriptions_url, this.total_private_repos, this.twitter_username, this.two_factor_authentication, this.type, this.updated_at, this.url
    )
}

internal fun FollowersEntity.toDomain(): Followers {
    return Followers(
        this.avatar_url, this.events_url, this.followers_url, this.following_url, this.gists_url, this.gravatar_id, this.html_url, this.id, this.login, this.node_id, this.organizations_url, this.received_events_url, this.repos_url, this.site_admin, this.starred_url, this.subscriptions_url, this.type, this.url
    )
}

internal fun FollowingEntity.toDomain(): Following {
    return Following(
        this.avatar_url, this.events_url, this.followers_url, this.following_url, this.gists_url, this.gravatar_id, this.html_url, this.id, this.login, this.node_id, this.organizations_url, this.received_events_url, this.repos_url, this.site_admin, this.starred_url, this.subscriptions_url, this.type, this.url
    )
}

internal fun OwnerEntity.toDomain(): Owner {
    return Owner(
        this.avatar_url
    )
}

internal fun User.toEntity(): BookmarkEntity {
    return BookmarkEntity(
        avatar_url=avatar_url,
        bio = bio,
        blog = bio,
        collaborators = collaborators,
        company = company,
        created_at = created_at,
        disk_usage = disk_usage,
        email = email,
        events_url = events_url,
        followers = followers,
        followers_url = followers_url,
        following = following,
        following_url = following_url,
        gists_url = gists_url,
        gravatar_id = gravatar_id,
        hireable = hireable,
        html_url = html_url,
        id = id,
        location = location,
        login = login,
        name = name,
        node_id = node_id,
        organizations_url = organizations_url,
        owned_private_repos = owned_private_repos,
        private_gists = private_gists,
        public_gists = public_gists,
        public_repos = public_repos,
        received_events_url = received_events_url,
        repos_url = repos_url,
        site_admin = site_admin,
        starred_url = starred_url,
        subscriptions_url = subscriptions_url,
        total_private_repos = total_private_repos,
        twitter_username = twitter_username,
        two_factor_authentication = two_factor_authentication,
        type = type,
        updated_at = updated_at,
        url = url,
        isBookMarked = false
    )
}
internal fun RepositoriesEntity.toDomain(): Repositories {
    return Repositories(
         this.description ,
         this.id,
         this.name,
         this.owner.toDomain(),
         this.language,
         this.created_at,
         this.watchers_count,
         this.forks_count,
         this.stargazers_count
    )
}