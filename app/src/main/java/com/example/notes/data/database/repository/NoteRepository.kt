package com.example.notes.data.database.repository

import androidx.lifecycle.LiveData
import com.example.notes.data.model.NoteModel

interface NoteRepository {

    val allNoteData:LiveData<List<NoteModel>>

    suspend fun insertNote(noteModel: NoteModel, onSuccess:() -> Unit)

    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)
}