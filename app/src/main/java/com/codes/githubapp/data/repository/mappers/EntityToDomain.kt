package com.codes.githubapp.data.repository.mappers

import com.codes.githubapp.data.cache.entity.*
import com.codes.githubapp.domain.models.*

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
internal fun RepositoriesEntity.toDomain(): Repositories {
    return Repositories(
        this.archive_url,
        this.archived,
         this.assignees_url,
         this.blobs_url ,
         this.branches_url ,
         this.clone_url ,
         this.collaborators_url ,
         this.comments_url ,
         this.commits_url ,
         this.compare_url ,
         this.contents_url ,
         this.contributors_url ,
         created_at ,
         default_branch ,
         deployments_url ,
         description ,
         disabled ,
         downloads_url ,
         events_url ,
         fork ,
         forks_count ,
         forks_url ,
         full_name ,
         git_commits_url ,
         git_refs_url ,
         git_tags_url ,
         git_url ,
         has_discussions ,
         has_downloads ,
         has_issues ,
         has_pages ,
         has_projects ,
         has_wiki ,
         homepage ,
         hooks_url ,
         html_url ,
         id ,
         is_template ,
         issue_comment_url ,
         issue_events_url ,
         issues_url ,
         keys_url ,
         labels_url ,
         language ,
         languages_url ,
         merges_url ,
         milestones_url ,
         mirror_url ,
         name ,
         node_id ,
         notifications_url ,
         open_issues_count ,
         owner.toDomain(),
         pulls_url ,
         pushed_at ,
         releases_url ,
         size ,
         ssh_url ,
         stargazers_count ,
         stargazers_url ,
         statuses_url ,
         subscribers_url ,
         subscription_url ,
         svn_url ,
         tags_url ,
         teams_url ,
         trees_url ,
         updated_at ,
         url ,
         visibility ,
         watchers_count
    )
}