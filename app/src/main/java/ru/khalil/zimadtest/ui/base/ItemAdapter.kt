package ru.khalil.zimadtest.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*
import ru.khalil.zimadtest.R
import ru.khalil.zimadtest.data.model.Item

class ItemAdapter(
    private val items: List<Item>,
    private val onItemClickListener: OnItemClickListener
    ): RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val item = inflater.inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(item)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.view.apply {
            item_text.text = item.title
            item_image.run {
                Picasso.get()
                    .load(item.url)
                    .into(this)
            }

            setOnClickListener{
                onItemClickListener.onItemClick(item)
            }
        }
    }
}

class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view)

interface OnItemClickListener {
    fun onItemClick(item: Item)
}