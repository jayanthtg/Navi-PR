package com.github.prs

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.R
import com.github.prs.repo.model.PullRequest
import com.google.android.material.button.MaterialButtonToggleGroup

class PullRequestActivity : AppCompatActivity() {

    private lateinit var viewModel: PullRequestViewModel
    private lateinit var companyTextView: TextView
    private lateinit var repoTextView: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var toggleGroup: MaterialButtonToggleGroup
    private val adapter = PrAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pull_request)
        viewModel = ViewModelProvider(this).get(PullRequestViewModel::class.java)
        initUi()
        applyObservers()
    }

    private fun initUi() {
        companyTextView = findViewById(R.id.companyText)
        repoTextView = findViewById(R.id.repositoryText)
        toggleGroup = findViewById(R.id.toggleButton)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        findViewById<Button>(R.id.btnSubmit).setOnClickListener { onSubmit() }
    }

    private fun applyObservers() {
        viewModel.pullRequests.observe(this, this::onItems)
    }

    private fun onSubmit() {
        val org = companyTextView.text.toString()
        val repo = repoTextView.text.toString()
        when (toggleGroup.checkedButtonId) {
            R.id.btnOpen -> viewModel.getOpenPullRequests(org, repo)
            R.id.btnClosed -> viewModel.getClosedPullRequests(org, repo)
            else -> viewModel.getAllPullRequests(org, repo)
        }
        clearAdapter()
    }

    private fun onItems(items: List<PullRequest>) {
        adapter.items(items)
    }

    private fun clearAdapter() {
        adapter.items(listOf())
    }
}