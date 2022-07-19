package com.example.notes.data.database.repository

import androidx.lifecycle.LiveData
import com.example.notes.data.database.dao.NoteDao
import com.example.notes.data.model.NoteModel

class NoteRealization(private val noteDao: NoteDao):NoteRepository {
    override val allNoteData: LiveData<List<NoteModel>>
        get() = noteDao.getAllNote()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }

}