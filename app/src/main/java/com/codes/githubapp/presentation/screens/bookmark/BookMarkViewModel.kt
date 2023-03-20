package com.codes.githubapp.presentation.screens.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codes.cache.entity.BookmarkEntity
import com.codes.repository.repository.BookMarkRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(private val bookMarkRepository: BookMarkRepositoryImpl): ViewModel() {

    val bookMarks = bookMarkRepository.getBookMarks()
    fun saveBookMark(bookmarkEntity: BookmarkEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            bookMarkRepository.saveBookMark(bookmarkEntity)
        }
    }
    fun deleteBookMark() {
        viewModelScope.launch(Dispatchers.IO) {
            bookMarkRepository.deleteBookMark()
        }
    }
}