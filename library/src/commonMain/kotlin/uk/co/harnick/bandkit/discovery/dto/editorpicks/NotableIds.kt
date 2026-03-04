package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
internal value class NotableIds private constructor(internal val ids: List<Long>)
