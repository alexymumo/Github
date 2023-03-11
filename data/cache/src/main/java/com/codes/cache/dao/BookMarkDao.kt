package com.codes.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codes.cache.entity.BookmarkEntity

/*
* BookMark Dao
* */

@Dao
interface BookMarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveBookMark(bookmarkEntity: BookmarkEntity)

    @Query("SELECT * FROM bookmark_table")
    fun getAllBookMarks(): LiveData<List<BookmarkEntity>>

    @Query("DELETE FROM bookmark_table")
    suspend fun deleteBookMark()
}