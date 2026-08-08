/*
 * Copyright (c) 2026 tutosrive. All rights reserved.
 *
 * Author: tutosrive
 * GitHub: https://github.com/tutosrive
 *
 * This source code is PROPRIETARY and CONFIDENTIAL.
 * Unauthorized copying, modification, or distribution of this file,
 * via any medium, is strictly prohibited.
 *
 * This software is provided "as is", without warranty of any kind.
 * In no event shall the author be liable for any claim or damages.
 */

package com.srm.scrollbar_fastscroll_v1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l4digital.fastscroll.FastScroller

class CustomAdapter(val items: List<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(),
    FastScroller.SectionIndexer {
    override fun getSectionText(position: Int): CharSequence {
        return items[position].subSequence(0, (items.size / 3))
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        type: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.custom_item_view, parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView = v.findViewById<TextView>(R.id.itemTxt)

        fun bind(txt: String): Unit {
            this.textView.text = txt
        }
    }
}