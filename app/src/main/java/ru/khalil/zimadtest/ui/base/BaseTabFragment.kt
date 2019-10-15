package ru.khalil.zimadtest.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseTabFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as? FragmentWithTab)?.showTab()
    }
    protected val STATE_KEY = "state"
}