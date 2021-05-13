package ru.android.randomswearwords.presentation.mapper

import ru.android.randomswearwords.base.mapper.Mapper
import ru.android.randomswearwords.data.model.WordsResponsesBody
import ru.android.randomswearwords.domain.model.WordBody

class WordMapper : Mapper<WordsResponsesBody, WordBody> {

    override fun map(origin: WordsResponsesBody) = WordBody(
        number = origin.number,
        language = origin.language,
        insult = origin.insult,
        created = origin.created,
        show = origin.show,
        createdby = origin.createdby,
        active = origin.active,
        comment = origin.comment
    )

}