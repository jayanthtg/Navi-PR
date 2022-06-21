package com.github

import com.github.core.cloud.GitRemote
import com.github.prs.repo.GitRepo
import com.github.prs.repo.network.GitNetworkSource
import com.github.prs.repo.network.GitService

object DIYDi {

    fun getGitRepo(): GitRepo {
        return GitRepo(getGitNetworkSource())
    }

    private fun getGitNetworkSource(): GitNetworkSource {
        return GitNetworkSource(getGitService())
    }

    private fun getGitService(): GitService {
        return GitRemote.get().client().create(GitService::class.java)
    }
}