# BandKit

A small Kotlin Multiplatfrom library to interface with Bandcamp's API.

## Features
BandKit contains helper functions to fetch (and sometime scrape) both user and library data from
Bandcamp's website, along with respective DTOs and some classes for general serialization.

Supports both JVM and Native projects.

## Usage
All relevant functions are contained within the BandcampApi object. You can reference it wherever
you like.

```kotlin
override suspend fun getLibrarySummary(
    token: String
): Flow<ResponseState<PersistentList<Long>>> = flow {
    emit(ResponseState.Fetching())

    val summaryDto = BandcampApi.fetchSummary(token)

    val summaryList = summaryDto.collectionSummary.trAlbumLookupList
        .map { it.value.itemId }
        .toPersistentList()

    emit(ResponseState.Success(summaryList))
}
```

## Contribution
Feel free to provide issues, pull requests, or suggestions. This is my first library published, so
any help is greatly appreciated!