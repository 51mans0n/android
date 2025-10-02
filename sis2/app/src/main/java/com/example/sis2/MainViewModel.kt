package com.example.sis2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _posts = MutableStateFlow(MockData.posts())
    val posts: StateFlow<List<Post>> = _posts.asStateFlow()

    fun toggleLike(id: Int) {
        _posts.value = _posts.value.map { p ->
            if (p.id == id) p.copy(liked = !p.liked) else p
        }
    }
}
