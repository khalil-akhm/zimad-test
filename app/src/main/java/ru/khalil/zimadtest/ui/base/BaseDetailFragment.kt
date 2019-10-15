package ru.khalil.zimadtest.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import ru.khalil.zimadtest.R
import ru.khalil.zimadtest.data.model.Item

abstract class BaseDetailFragment: Fragment() {

    protected val ITEM_KEY = "item"

    private var item: Item? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as? FragmentWithTab)?.hideTab()

        val itemText = view?.findViewById(R.id.item_text) as TextView
        val itemImage = view?.findViewById(R.id.item_image) as ImageView

        item = arguments?.getSerializable(ITEM_KEY) as? Item
        item?.run {
            itemText.text = title
            itemImage.run {
                Picasso.get()
                    .load(url)
                    .into(this)
            }
        }

    }
}
