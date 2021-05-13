package ru.android.randomswearwords.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.android.randomswearwords.data.mapper.WordsDataMapper
import ru.android.randomswearwords.data.model.WordsResponsesBody
import ru.android.randomswearwords.domain.ApiRepository

class ApiRepositoryImpl(
    private val apiResponseDataSource: PostResponseDataSource
) : ApiRepository {

    private val wordsDataMapper by lazy { WordsDataMapper() }

    override fun getWord(language: String): Flow<WordsResponsesBody> =
        apiResponseDataSource.getWord(language).map {
            wordsDataMapper.map(it)
        }

}