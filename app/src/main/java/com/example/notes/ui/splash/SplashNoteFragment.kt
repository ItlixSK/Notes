package com.example.notes.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notes.R
import com.example.notes.databinding.FragmentSplashNoteBinding

class SplashNoteFragment : Fragment() {

    private var binding: FragmentSplashNoteBinding? = null
    private val mBinding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashNoteBinding.inflate(layoutInflater,container,false)
        return mBinding.root
    }
}