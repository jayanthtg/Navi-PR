package com.github.prs.repo.network

import com.github.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitService {

    @GET(Constants.Url.REPO + "{org}/{repo}/pulls?")
    suspend fun getPublicPullRequests(
        @Path("org") org: String,
        @Path("repo") repo: String,
        @Query("state") state: String
    ): List<RemotePullRequest>
}