package ru.android.randomswearwords.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.android.randomswearwords.data.model.dto.WordsResponsesBodyData

class PostResponseDataSource {

    fun getWord(language: String): Flow<WordsResponsesBodyData> = flow {
        emit(
            PostApiClient.getApiClient().getWord(
                language = language,
                type = "json"
            )
        )
    }

}