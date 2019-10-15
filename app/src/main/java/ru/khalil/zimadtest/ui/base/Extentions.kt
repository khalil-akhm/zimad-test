package ru.khalil.zimadtest.ui.base

import com.google.android.material.tabs.TabLayout

fun TabLayout.addOnTabSelectedListener(onTabSelected: (TabLayout.Tab?) -> Unit){
    this. addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
        override fun onTabReselected(p0: TabLayout.Tab?) {}

        override fun onTabUnselected(p0: TabLayout.Tab?) {}

        override fun onTabSelected(p0: TabLayout.Tab?) {
            onTabSelected.invoke(p0)
        }
    })
}