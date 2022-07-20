package com.example.notes.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.APP
import com.example.notes.R
import com.example.notes.data.model.NoteModel
import com.example.notes.databinding.FragmentAddNoteBinding

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)
        binding.addButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)){}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startNoteFragment)
        }
        binding.backButton.setOnClickListener {
            APP.navController.navigate(R.id.action_addNoteFragment_to_startNoteFragment)
        }
    }
}