package com.github.prs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.DIYDi
import com.github.prs.repo.GitRepo
import com.github.prs.repo.model.PullRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PullRequestViewModel : ViewModel() {
    private val repo = DIYDi.getGitRepo()
    private val _pullRequests = MutableLiveData<List<PullRequest>>()
    val pullRequests: LiveData<List<PullRequest>> = _pullRequests
    private var prJob: Job? = null

    fun getOpenPullRequests(org: String, repo: String) {
        getPullRequests(org, repo, GitRepo.State.OPEN)
    }

    fun getClosedPullRequests(org: String, repo: String) {
        getPullRequests(org, repo, GitRepo.State.CLOSED)
    }

    fun getAllPullRequests(org: String, repo: String) {
        getPullRequests(org, repo, GitRepo.State.ALL)
    }

    private fun getPullRequests(org: String, repository: String, state: GitRepo.State) {
        prJob = viewModelScope.launch(Dispatchers.IO) {
            _pullRequests.postValue(repo.getPublicPullRequestsSync(org, repository, state))
        }
    }
}