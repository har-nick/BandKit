package uk.co.harnick.bandkit.discovery.util

import io.ktor.http.Parameters
import io.ktor.http.formUrlEncode
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

internal inline fun <reified T> urlEncode(data: T): String {
    val jsonObj = Json.encodeToJsonElement(data).jsonObject
    val params = Parameters.build {
        jsonObj.forEach { (key, value) ->
            append(key, value.jsonPrimitive.content)
        }
    }
    return params.formUrlEncode()
}
