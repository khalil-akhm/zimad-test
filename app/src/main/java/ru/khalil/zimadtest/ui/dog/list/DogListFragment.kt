package ru.khalil.zimadtest.ui.dog.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

import ru.khalil.zimadtest.R
import ru.khalil.zimadtest.data.model.Item
import ru.khalil.zimadtest.ui.base.FragmentCallback
import ru.khalil.zimadtest.ui.base.ItemAdapter
import ru.khalil.zimadtest.ui.base.OnItemClickListener
import ru.khalil.zimadtest.ui.base.BaseTabFragment

class DogListFragment : BaseTabFragment(), KodeinAware {
    override val kodein by closestKodein()
    private val viewModelFactory by instance<DogListViewModelFactory>()
    companion object {
        fun newInstance() = DogListFragment()
    }

    private lateinit var viewModel: DogListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DogListViewModel::class.java)

        viewModel.apply {
            dogs.observe(viewLifecycleOwner, Observer {
                val cats = it ?: return@Observer
                initRecyclerView(cats)
            })
        }

    }

    private fun initRecyclerView(cats: List<Item>){
        recycler_view.apply {
            val state = arguments?.getParcelable<Parcelable>(STATE_KEY)
            layoutManager = LinearLayoutManager(context).apply { onRestoreInstanceState(state) }
            adapter = ItemAdapter(cats, object : OnItemClickListener {
                override fun onItemClick(item: Item) {
                    (activity as? FragmentCallback)?.onItemSelected(item, this@DogListFragment)
                }
            })
        }
    }

    override fun onPause() {
        super.onPause()
        val state = recycler_view.layoutManager?.onSaveInstanceState()
        arguments = Bundle().apply { putParcelable(STATE_KEY, state) }
    }
}


