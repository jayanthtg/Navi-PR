package com.github.prs.repo.network

class GitNetworkSource(private val service: GitService) {

    suspend fun getPublicPullRequests(org: String, repo: String, state: String): List<RemotePullRequest> {
        return service.getPublicPullRequests(org, repo, state)
    }
}