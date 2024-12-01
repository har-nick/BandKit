package uk.co.harnick.bandkit.util

public enum class Encoding(
    public val apiRef: String
) {
    AAC("aac-hi"),
    AIFF("aiff-lossless"),
    ALAC("alac"),
    FLAC("flac"),
    MP3320("mp3-320"),
    MP3V0("mp3-v0"),
    OGG("vorbis"),
    WAV("wav")
}
