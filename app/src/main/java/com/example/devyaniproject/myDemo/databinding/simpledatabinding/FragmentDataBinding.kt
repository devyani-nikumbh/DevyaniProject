package com.example.devyaniproject.myDemo.databinding.simpledatabinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.devyaniproject.R
import com.example.devyaniproject.databinding.FragmentDataBindingBinding


class FragmentDataBinding : Fragment() {
    // Initialize variable
    private var binding: FragmentDataBindingBinding? = null
    private var view: View? = null
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            mParam1 = arguments?.getString(ARG_PARAM1)
            mParam2 = arguments?.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Assign variable
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_binding, container, false)
        view = binding?.root
        binding?.btSubmit?.setOnClickListener(View.OnClickListener { view ->
            // Get text from edit text
            val sText: String = binding?.etInput?.getText().toString().trim()

            // Check condition
            if (sText != "") {
                // When text is not empty
                // Set text on text view
                binding?.tvOutput?.text = sText
            } else {
                // When text is empty
                // Display Toast
                Toast.makeText(
                    view.context,
                    "Please enter text", Toast.LENGTH_SHORT
                ).show()
            }
        })

        // Return view
        return view
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        fun newInstance(param1: String?, param2: String?): FragmentDataBinding {
            val fragment = FragmentDataBinding()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.setArguments(args)
            return fragment
        }
    }
}

