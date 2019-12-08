package com.ataulm.stacks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        helloAndroid.text = args.stackId
        openStackButton.setOnClickListener {
            val action = StackFragmentDirections.actionStackFragmentSelf("child stack")
            findNavController().navigate(action)
        }
    }
}
