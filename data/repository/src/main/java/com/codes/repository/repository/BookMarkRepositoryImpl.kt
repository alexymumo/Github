package com.codes.repository.repository

import com.codes.cache.dao.BookMarkDao
import com.codes.cache.entity.BookmarkEntity
import com.codes.domain.repository.BookMarkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookMarkRepositoryImpl @Inject constructor(private val bookMarkDao: BookMarkDao): BookMarkRepository {
    override suspend fun saveBookMark(bookmarkEntity: BookmarkEntity) {
        return bookMarkDao.saveBookMark(bookmarkEntity)
    }

    override suspend fun deleteBookMark() {
        return bookMarkDao.deleteBookMark()
    }

    override fun getBookMarks(): Flow<List<BookmarkEntity>> {
        return bookMarkDao.getAllBookMarks()
    }
}