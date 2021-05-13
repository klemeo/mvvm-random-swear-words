package ru.android.randomswearwords.domain

import kotlinx.coroutines.flow.Flow
import ru.android.randomswearwords.data.model.WordsResponsesBody

interface ApiRepository {

    fun getWord(language: String): Flow<WordsResponsesBody>

}