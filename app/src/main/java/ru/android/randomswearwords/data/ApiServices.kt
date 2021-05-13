package ru.android.randomswearwords.data

import retrofit2.http.*
import ru.android.randomswearwords.data.model.dto.WordsResponsesBodyData

interface ApiServices {

    @GET("generate_insult.php")
    suspend fun getWord(
        @Query("lang") language: String,
        @Query("type") type: String
    ): WordsResponsesBodyData

}