package ru.khalil.zimadtest.ui.dog.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.khalil.zimadtest.R
import ru.khalil.zimadtest.data.model.Item
import ru.khalil.zimadtest.ui.base.BaseDetailFragment

class DogDetailFragment: BaseDetailFragment() {

    companion object {
        fun newInstance(item: Item): DogDetailFragment{
            return DogDetailFragment().apply {
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
