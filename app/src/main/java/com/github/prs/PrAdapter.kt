package com.github.prs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.R
import com.github.prs.repo.model.PullRequest

class PrAdapter : RecyclerView.Adapter<PrAdapter.Holder>() {

    private var items: List<PullRequest> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pull_request, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    fun items(items: List<PullRequest>) {
        this.items = items
        notifyDataSetChanged()
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatar = itemView.findViewById<ImageView>(R.id.avatar)
        private val title = itemView.findViewById<TextView>(R.id.titleText)
        private val userName = itemView.findViewById<TextView>(R.id.nameText)
        private val status = itemView.findViewById<TextView>(R.id.statusText)
        private val date = itemView.findViewById<TextView>(R.id.dateText)

        fun bind(item: PullRequest) {
            Glide.with(avatar).load(item.userAvatar).into(avatar)
            title.text = item.title
            userName.text = item.userName
            status.text = item.status
            date.text = "CreatedAt: ${item.createdDate} \nClosedAt: ${item.closedDate}"
        }
    }
}