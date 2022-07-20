package com.example.notes.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.REPOSITORY
import com.example.notes.data.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailNoteViewModel:ViewModel() {

    fun delete(noteModel: NoteModel,onSuccess:()->Unit){
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.deleteNote(noteModel){
                onSuccess()
            }
        }
    }
}