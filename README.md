# About Bookshelf Application
This is a bookshelf app developed using Kotlin and [Jetpack compose](https://developer.android.com/jetpack/compose) 
displaying books obtained from the Google books Api service. This app uses [Retrofit](https://square.github.io/retrofit/) 
to access data stored on a REST web server. [Coil](https://coil-kt.github.io/coil/) is used to load and display 
photos from the internet. The application follows Modern Android Design guidelines.

## About Google Books API
The Google Books API provides a method that returns a list of books based on a particular search 
term, as described in [Using the API](https://developers.google.com/books/docs/v1/using?authuser=1#PerformingSearch).

## Concepts applied
- Composable functions
- Modern architecture including; viewModel
- Coroutines for long-running tasks
- Clean architecture by separating the network calls into a repository
- Use the Coil library used to load and display photos from the internet in the app
- Use of Retrofit to make REST requests to the web server

## Pictures of the final app
<img src = "https://github.com/JimmyAlele/Bookshelf/blob/master/app/src/main/res/drawable/kotlin_screenshot.png" width = "30%">
<img src = "https://github.com/JimmyAlele/Bookshelf/blob/master/app/src/main/res/drawable/cat_screenshot.png" width = "30%">
<img src = "https://github.com/JimmyAlele/Bookshelf/assets/135094151/71432bf6-a5b4-49b6-89c0-ae5e9ff0999c" width = "30%">
