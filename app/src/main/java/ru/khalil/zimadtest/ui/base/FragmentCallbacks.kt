package ru.khalil.zimadtest.ui.base

import androidx.fragment.app.Fragment
import ru.khalil.zimadtest.data.model.Item

interface FragmentCallback {
    fun onItemSelected(item: Item, fragment: Fragment)
}

interface FragmentWithTab {
    fun showTab()
    fun hideTab()
}