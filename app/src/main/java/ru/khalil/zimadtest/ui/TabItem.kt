package ru.khalil.zimadtest.ui

import androidx.fragment.app.Fragment
import ru.khalil.zimadtest.data.model.Item

data class TabItem(
    val fragment: Fragment,
    val title: String,
    val tag: String,
    val detailFragment: (Item) -> Fragment
)