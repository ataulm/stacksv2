package com.ataulm.stacks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo.IME_ACTION_DONE
import android.view.inputmethod.EditorInfo.IME_NULL
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_stack.*

class StackFragment : Fragment() {

    private val args: StackFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_stack, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stacksAdapter = StacksAdapter()

        // TODO: get this from observing state on the ViewModel
        val dummyStackItems = (1..15).map { StacksAdapter.Item("Item $it") }
        stacksAdapter.submitList(dummyStackItems)
        recyclerView.adapter = stacksAdapter

        inputEditText.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == IME_ACTION_DONE || actionId == IME_NULL) {
                onUserAddedNewStack(v.editableText.toString())
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

    private fun onUserAddedNewStack(stack: CharSequence) {
        Log.d("!!!", "User added stack: $stack")
        // TODO: tell ViewModel (which will save it, simultaneously, emitting new state disabling the edittext while in-flight)
    }

    // TODO: use this when clicking on a Stack item
    private fun openStack() {
        val action = StackFragmentDirections.actionStackFragmentSelf("child stack")
        findNavController().navigate(action)
    }
}
