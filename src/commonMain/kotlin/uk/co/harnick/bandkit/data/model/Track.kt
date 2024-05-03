package uk.co.harnick.bandkit.data.model

import kotlinx.serialization.Serializable
import uk.co.harnick.bandkit.data.remote.dto.items.TrackDto

/**
 * An instance of a Bandcamp track.
 * @param [artId] The ID of the album art. Inherited by its parent LibraryItem instance.
 * @param [id] The unique ID for this track.
 * @param [title] The title of this track.
 * @param [artist] The performing artist or band for this track.
 * @param [duration] The duration of the track.
 * @param [index] The index of this track in its parent item.
 * @param [adaptiveStreamUrl] A URL providing a stream in MP3 V0 format.
 */
@Serializable
public data class Track internal constructor(
    public val artId: Long,
    public val id: Long,
    public val title: String,
    public val artist: String,
    public val duration: Float,
    public val index: Int,
    public val adaptiveStreamUrl: String
)

internal fun TrackDto.toTrack(artId: Long) =
    Track(artId, id, title, artist, duration, index ?: 0, adaptiveStreamUrl.values.first())
