package com.example.notes.ui.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notes.REPOSITORY
import com.example.notes.data.database.NoteDataBase
import com.example.notes.data.database.repository.NoteRealization
import com.example.notes.data.model.NoteModel

class StartNoteViewModel (application: Application):AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNote(): LiveData<List<NoteModel>>{
        return REPOSITORY.allNoteData
    }
}