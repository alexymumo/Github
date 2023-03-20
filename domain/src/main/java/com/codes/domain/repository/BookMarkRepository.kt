package com.codes.domain.repository

import com.codes.cache.entity.BookmarkEntity
import kotlinx.coroutines.flow.Flow

interface BookMarkRepository {
    suspend fun saveBookMark(bookmarkEntity: BookmarkEntity)
    suspend fun deleteBookMark()
    fun getBookMarks(): Flow<List<BookmarkEntity>>
}