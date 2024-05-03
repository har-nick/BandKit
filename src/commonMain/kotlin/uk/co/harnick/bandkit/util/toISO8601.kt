package uk.co.harnick.bandkit.util

internal fun String.toISO8601(): String {
    val parts = split(" ")
    val months =
        listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    val day = parts[0].toInt()
    val month = (months.indexOf(parts[1]) + 1).toString().padStart(2, '0')
    val year = parts[2]
    val timeParts = parts[3].split(":")
    val hour = timeParts[0]
    val minute = timeParts[1]
    val second = timeParts[2].substring(0, 2)

    return "$year-$month-${day.toString().padStart(2, '0')}T${hour}:${minute}:${second}Z"
}
