package com.codes.cache.sample

import com.codes.cache.entity.*


val userEntity = UserEntity(
    avatar_url = "my url",
    bio = "1",
    blog = "my blog",
    collaborators = 1,
    company = "github",
    created_at = "12pm",
    disk_usage = 1,
    email = "git.com",
    events_url = "1",
    followers = 12,
    followers_url = "ale",
    following = 23,
    following_url = "23",
    gists_url = "1",
    gravatar_id = "1",
    hireable = false,
    html_url = "1",
    id = 1,
    location = "1",
    login = "Alex Mumo",
    name = "Alex Mumo",
    node_id = "1",
    organizations_url = "1",
    owned_private_repos = 1,
    private_gists = 12,
    public_gists = 23,
    public_repos = 23,
    received_events_url = "1",
    repos_url = "1",
    site_admin = false,
    starred_url = "1",
    subscriptions_url = "1",
    total_private_repos = 45,
    twitter_username = "1",
    two_factor_authentication = false,
    type = "1",
    updated_at = "1",
    url = "1"
)

val ownerEntity = OwnerEntity(
    avatar_url = "url"
)


val repositoriesEntity = RepositoriesEntity(
    description = null,
    id = 1,
    name = "",
    owner = ownerEntity,
    language = null,
    created_at = "23",
    watchers_count = 2,
    forks_count = 2,
    stargazers_count = 2
)


val followingEntity = FollowingEntity(
     avatar_url="",
     events_url="",
     followers_url="",
     following_url="",
     gists_url="",
     gravatar_id="",
     html_url="",
     id=1,
     login="",
     node_id="",
     organizations_url="",
     received_events_url="",
     repos_url="",
     site_admin=false,
     starred_url="",
     subscriptions_url="",
     type="",
     url=""
)

val followersEntity = FollowersEntity(
     avatar_url="",
     events_url="",
     followers_url="",
     following_url="",
     gists_url="",
     gravatar_id="",
     html_url="",
     id=1,
     login="",
     node_id="",
     organizations_url="",
     received_events_url="",
     repos_url="",
     site_admin=false,
     starred_url="",
     subscriptions_url="",
     type="",
     url=""
)