package com.moviechart.data.source.local

data class MovieDetailEntity(
    var movieId: String,
    var director: String,
    var overview: String,
    var trailerLink: String,
    var trailerThumbnail: String,
    var cast: ArrayList<ActorEntity>
)
