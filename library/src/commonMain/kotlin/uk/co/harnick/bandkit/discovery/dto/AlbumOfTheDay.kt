package uk.co.harnick.bandkit.discovery.dto

import kotlinx.serialization.Serializable

@Serializable
public class AlbumOfTheDay internal constructor(
    public val albumId: Long,

    public val title: String,

    public val blurb: String,

    public val imageId: Long,

    public val articleUrl: String,

    public val genre: String,

    public val contributor: String,

    public val publishedDate: String
)
