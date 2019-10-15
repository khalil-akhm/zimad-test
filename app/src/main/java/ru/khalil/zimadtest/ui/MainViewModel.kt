package ru.khalil.zimadtest.ui

import androidx.lifecycle.ViewModel
import ru.khalil.zimadtest.ui.cat.detail.CatDetailFragment
import ru.khalil.zimadtest.ui.cat.list.CatListFragment
import ru.khalil.zimadtest.ui.dog.detail.DogDetailFragment
import ru.khalil.zimadtest.ui.dog.list.DogListFragment
import java.text.FieldPosition

class MainViewModel : ViewModel()  {

    private var selectedTab: Int = 0

    val tabItems = listOf(
        TabItem(
            CatListFragment.newInstance(),
            "tab 1",
            "tab1"
        ) { CatDetailFragment.newInstance(it) },
        TabItem(
            DogListFragment.newInstance(),
            "tab 2",
            "tab2"
        ) { DogDetailFragment.newInstance(it) }
    )

    fun setSelectedTab(position: Int?){
        selectedTab = position?:0
    }

    fun getSelectedTab() = selectedTab
}
