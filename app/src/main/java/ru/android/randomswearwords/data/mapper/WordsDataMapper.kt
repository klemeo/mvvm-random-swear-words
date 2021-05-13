package ru.android.randomswearwords.data.mapper

import ru.android.randomswearwords.base.mapper.Mapper
import ru.android.randomswearwords.data.model.WordsResponsesBody
import ru.android.randomswearwords.data.model.dto.WordsResponsesBodyData

class WordsDataMapper : Mapper<WordsResponsesBodyData, WordsResponsesBody> {

    override fun map(origin: WordsResponsesBodyData) = WordsResponsesBody(
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