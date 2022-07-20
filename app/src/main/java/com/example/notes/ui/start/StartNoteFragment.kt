package com.example.notes.ui.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.APP
import com.example.notes.R
import com.example.notes.data.adapter.NoteAdapter
import com.example.notes.data.model.NoteModel
import com.example.notes.databinding.FragmentStartNoteBinding

class StartNoteFragment : Fragment() {

    lateinit var binding: FragmentStartNoteBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(StartNoteViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.recyclerView
        adapter = NoteAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllNote().observe(viewLifecycleOwner){
            listNote -> adapter.setList(listNote.asReversed())
        }
        binding.addNoteButton.setOnClickListener {
            APP.navController.navigate(R.id.action_startNoteFragment_to_addNoteFragment)
        }
    }
    companion object{
        fun clickNote(noteModel: NoteModel){
            val bundle = Bundle()
            bundle.putSerializable("note",noteModel)
            APP.navController.navigate(R.id.action_startNoteFragment_to_detailNoteFragment,bundle)
        }
    }
}