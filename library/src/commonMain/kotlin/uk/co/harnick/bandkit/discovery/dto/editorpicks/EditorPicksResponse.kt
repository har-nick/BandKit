package uk.co.harnick.bandkit.discovery.dto.editorpicks

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class EditorPicksResponse internal constructor(public val items: NotableItem)
