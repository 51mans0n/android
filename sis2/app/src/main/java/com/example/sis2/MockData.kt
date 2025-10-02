package com.example.sis2


object MockData {
    fun posts(): List<Post> = listOf(
        Post(1, "Sunset over the city", "https://picsum.photos/id/1011/800/500"),
        Post(2, "Mountains and clouds", "https://picsum.photos/id/1003/800/500"),
        Post(3, "Forest pathway", "https://picsum.photos/id/1020/800/500"),
        Post(4, "Calm lake", "https://picsum.photos/id/1015/800/500"),
        Post(5, "Street vibes", "https://picsum.photos/id/1035/800/500")
    )
}