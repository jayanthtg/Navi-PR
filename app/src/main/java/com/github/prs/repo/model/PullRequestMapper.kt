package com.github.prs.repo.model

import com.github.core.mappers.BasicMapper
import com.github.core.mappers.Mapper
import com.github.prs.repo.network.RemotePullRequest

object PullRequestMapper {

    val networkMapper: Mapper<RemotePullRequest, PullRequest> = NetworkMapper()

    private class NetworkMapper : BasicMapper<RemotePullRequest, PullRequest>() {
        override fun map(item: RemotePullRequest): PullRequest {
            return PullRequest(item.id(), item.title(), item.user().id(), item.user().login(), item.user().avatarUrl(), item.createdAt(), item.closedAt(), item.state())
        }
    }
}

