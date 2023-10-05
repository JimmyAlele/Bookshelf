package com.alele.bookshelf

import android.app.Application
import com.alele.bookshelf.data.AppContainer
import com.alele.bookshelf.data.DefaultAppContainer

class BookshelfApplication: Application() {
    /** AppContainer containing instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}