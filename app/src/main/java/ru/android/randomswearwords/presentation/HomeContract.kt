package ru.android.randomswearwords.presentation

interface HomeContract: SelectLanguage

interface SelectLanguage {
    fun language(item: String)
}