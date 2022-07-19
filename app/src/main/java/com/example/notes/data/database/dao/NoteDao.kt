package com.example.notes.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.data.model.NoteModel

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel)
    @Delete
    suspend fun delete(noteModel: NoteModel)
    @Query("SELECT * from noteTable")
    fun getAllNote():LiveData<List<NoteModel>>
}