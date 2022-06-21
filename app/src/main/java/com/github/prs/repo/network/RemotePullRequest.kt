package com.github.prs.repo.network

import com.google.gson.annotations.SerializedName

data class RemotePullRequest(
    @SerializedName("id")
    private val id: Int?,
    @SerializedName("url")
    private val url: String?,
    @SerializedName("state")
    private val state: String?,
    @SerializedName("title")
    private val title: String?,
    @SerializedName("user")
    private val user: User?,
    @SerializedName("body")
    private val body: String?,
    @SerializedName("created_at")
    private val createdAt: String?,
    @SerializedName("updated_at")
    private val updatedAt: String?,
    @SerializedName("closed_at")
    private val closedAt: String?,
    @SerializedName("merged_at")
    private val mergedAt: String?
){

    fun id(): Int = id ?: 0
    fun url(): String = url ?: String()
    fun state(): String = state ?: String()
    fun title(): String = title ?: String()
    fun body(): String = body ?: String()
    fun createdAt(): String = createdAt ?: String()
    fun updatedAt(): String = updatedAt ?: String()
    fun closedAt(): String = closedAt ?: String()
    fun mergedAt(): String = mergedAt ?: String()
    fun user(): User = user ?: User(null, null, null, null, null, null)


    data class User(
        @SerializedName("id")
        private val id: Int?,
        @SerializedName("login")
        private val login: String?,
        @SerializedName("node_id")
        private val nodeId: String?,
        @SerializedName("avatar_url")
        private val avatarUrl: String?,
        @SerializedName("gravatar_id")
        private val gravatarUrl: String?,
        @SerializedName("url")
        private val url: String?
    ) {

        fun id(): Int = id ?: 0
        fun login(): String = login ?: String()
        fun nodeId(): String = nodeId ?: String()
        fun avatarUrl(): String = avatarUrl ?: String()
        fun gravatarUrl(): String = gravatarUrl ?: String()
        fun url(): String = url ?: String()
    }
}