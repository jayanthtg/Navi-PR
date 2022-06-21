package com.github.prs.repo

import com.github.prs.repo.model.PullRequest
import com.github.prs.repo.model.PullRequestMapper
import com.github.prs.repo.network.GitNetworkSource
import com.github.prs.repo.network.RemotePullRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class GitRepo(private val networkSource: GitNetworkSource) {

    suspend fun getPublicPullRequestsSync(org: String, repo: String, state: State): List<PullRequest> {
        return convertRemotePrs(networkSource.getPublicPullRequests(org, repo, state.toString().lowercase()))
    }

    fun getPublicPullRequests(org: String, repo: String, state: State): Flow<List<PullRequest>> {
        return flow { emit(networkSource.getPublicPullRequests(org, repo, state.toString().lowercase())) }
            .map { convertRemotePrs(it) }
    }

    private fun convertRemotePrs(items: List<RemotePullRequest>): List<PullRequest> {
        return PullRequestMapper.networkMapper.map(items)
    }

    enum class State {
        ALL, OPEN, CLOSED
    }

}