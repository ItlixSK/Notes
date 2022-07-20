package com.example.notes.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.notes.APP
import com.example.notes.R
import com.example.notes.data.model.NoteModel
import com.example.notes.databinding.FragmentDetailNoteBinding

class DetailNoteFragment : Fragment() {

    lateinit var binding: FragmentDetailNoteBinding
    lateinit var curentNoteModel: NoteModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailNoteBinding.inflate(layoutInflater,container,false)
        curentNoteModel = arguments?.getSerializable("note") as NoteModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailNoteViewModel::class.java)
        binding.titleNote.text = curentNoteModel.title
        binding.descriptionNote.text = curentNoteModel.description

        binding.deleteButton.setOnClickListener {
            viewModel.delete(curentNoteModel){}
            APP.navController.navigate(R.id.action_detailNoteFragment_to_startNoteFragment)
        }
        binding.backButton.setOnClickListener {
            APP.navController.navigate(R.id.action_detailNoteFragment_to_startNoteFragment)
        }
    }

}