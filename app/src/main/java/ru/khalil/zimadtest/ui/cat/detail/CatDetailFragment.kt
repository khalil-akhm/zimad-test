package ru.khalil.zimadtest.ui.cat.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.khalil.zimadtest.R
import ru.khalil.zimadtest.data.model.Item
import ru.khalil.zimadtest.ui.base.BaseDetailFragment

class CatDetailFragment: BaseDetailFragment() {

    companion object {
        fun newInstance(item: Item): CatDetailFragment{
            return CatDetailFragment().apply {
                arguments = Bundle().apply { putSerializable(ITEM_KEY, item)}
            }
        }
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_detail, container, false)
//    }
}
