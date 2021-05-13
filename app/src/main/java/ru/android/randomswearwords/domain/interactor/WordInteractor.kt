package ru.android.randomswearwords.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.android.randomswearwords.base.interactor.Interactor
import ru.android.randomswearwords.data.model.WordsResponsesBody
import ru.android.randomswearwords.domain.ApiRepository
import ru.android.randomswearwords.presentation.SelectLanguage

class WordInteractor(
    private val apiRepository: ApiRepository
) : Interactor<WordInteractor.Params, Flow<WordsResponsesBody>> {

    override fun execute(params: Params): Flow<WordsResponsesBody> {
        return apiRepository.getWord(params.language)
    }

    data class Params(
        val language: String
    )

}