package uk.co.harnick.bandkit.domain.model

import uk.co.harnick.bandkit.data.remote.items.TrackDto

data class Track(
    val id: Long,
    val title: String,
    val artist: String,
    val duration: Float,
    val streamUrl: String
)

fun TrackDto.toTrack(): Track {
    return Track(id, title, artist, duration, streamUrl.values.first())
}
