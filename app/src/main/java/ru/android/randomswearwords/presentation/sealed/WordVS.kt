package ru.android.randomswearwords.presentation.sealed

import ru.android.randomswearwords.domain.model.WordBody

sealed class WordVS {
    class Post(val postVM: WordBody): WordVS()
    class Error(val message: String?): WordVS()
    class ShowLoader(val showLoader: Boolean): WordVS()
}
