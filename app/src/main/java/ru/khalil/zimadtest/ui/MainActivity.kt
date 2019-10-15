package ru.khalil.zimadtest.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import ru.khalil.zimadtest.R
import ru.khalil.zimadtest.data.model.Item
import ru.khalil.zimadtest.ui.base.FragmentCallback
import ru.khalil.zimadtest.ui.base.FragmentWithTab
import ru.khalil.zimadtest.ui.base.addOnTabSelectedListener
import java.lang.RuntimeException

class MainActivity : AppCompatActivity(), FragmentCallback, FragmentWithTab{

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.apply {

            val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

            fragment?:let {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, tabItems.first().fragment)
                    .commit()
            }

            tabItems.forEach {
                tabs.apply {
                    addTab(newTab()
                        .setText(it.title)
                        .setTag(it.tag)
                    )
                }
            }

            tabs.getTabAt(getSelectedTab())?.select()

            tabs.addOnTabSelectedListener{tab ->

                tabItems.find { it.tag == tab?.tag }?.let {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, it.fragment)
                        .commit()
                }
                setSelectedTab(tabs.selectedTabPosition)
            }
        }
    }

    override fun onItemSelected(item: Item, fragment: Fragment) {

        val tabItem = viewModel.tabItems.find { it.fragment::class == fragment::class }

        val detailFragment = tabItem?.detailFragment?.invoke(item)?:throw RuntimeException("Unknown fragment")

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, detailFragment)
            .addToBackStack( null )
            .commit()
    }

    override fun showTab() {
        tabs.visibility = View.VISIBLE
    }

    override fun hideTab() {
        tabs.visibility = View.GONE
    }
}