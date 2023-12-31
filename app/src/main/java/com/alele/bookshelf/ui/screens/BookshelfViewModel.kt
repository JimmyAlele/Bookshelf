package com.alele.bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.alele.bookshelf.BookshelfApplication
import com.alele.bookshelf.data.BookRepository
import kotlinx.coroutines.launch
import java.io.IOException

/** mutable state for the Home screen */
sealed interface BookshelfUiState {
    data class Success(val books: MutableList<String>): BookshelfUiState
    object Error: BookshelfUiState
    object Loading: BookshelfUiState
}

class BookshelfViewModel (private val bookRepository: BookRepository): ViewModel() {
    /** the mutable state that stores the status of the most recent request  */
    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
    /**
     * Call getAmphibiansData() on init so we can display status immediately.
     */
    init {
        getAllBookData()
    }

    /**
     * get all data from the bookApi retrofit service and updates the bookshelfUiState
     */
    fun getAllBookData() {
        viewModelScope.launch{
            bookshelfUiState = BookshelfUiState.Loading
            bookshelfUiState = try{
                // generate list of books details
                val listBooks = bookRepository.getAllBookData().items
                // create mutable list to store the thumbnail urls
                val listBookImages = mutableListOf<String>()
                // add thumbnail urls to the mutable list
                for (element in listBooks) {
                    val url = element.volumeInfo.imageLinks.thumbnail.replace("http", "https")
                    listBookImages.add(url)
                }
                BookshelfUiState.Success(listBookImages)
            } catch (e: IOException) {
                BookshelfUiState.Error
            }
        }
    }
    /**
     * Factory for [BookshelfViewModel] that takes [BookRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BookshelfApplication)
                val bookRepository = application.container.bookRepository
                BookshelfViewModel(bookRepository = bookRepository)
            }
        }
    }
}