package com.github.prs.repo.model

data class PullRequest(
    val id: Int,
    val title: String,
    val userId: Int,
    val userName: String,
    val userAvatar: String,
    val createdDate: String,
    val closedDate: String,
    val status: String
)