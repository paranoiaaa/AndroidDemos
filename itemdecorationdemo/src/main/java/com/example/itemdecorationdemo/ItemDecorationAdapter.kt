package com.example.itemdecorationdemo

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import pers.victor.ext.inflate

/**
 * Created by Paranoia on 12/21/17.
 */
class ItemDecorationAdapter(var data :List<CityBean>) : RecyclerView.Adapter<ItemDecorationAdapter.Holder>() {
    override fun onBindViewHolder(holder: Holder?, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder =
            Holder(inflate(R.layout.item_decoration, parent))

    override fun getItemCount(): Int = data.size

    class Holder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer
}