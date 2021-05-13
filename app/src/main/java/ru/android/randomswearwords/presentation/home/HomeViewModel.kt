package ru.android.randomswearwords.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.android.randomswearwords.base.interactor.Interactor
import ru.android.randomswearwords.base.platform.BaseViewModel
import ru.android.randomswearwords.base.utils.io
import ru.android.randomswearwords.base.utils.ui
import ru.android.randomswearwords.domain.interactor.WordInteractor
import ru.android.randomswearwords.presentation.mapper.WordMapper
import ru.android.randomswearwords.presentation.sealed.WordVS

class HomeViewModel(
    private val wordInteractor: WordInteractor
) : BaseViewModel() {

    val viewState: LiveData<WordVS> get() = mViewState
    private val mViewState = MutableLiveData<WordVS>()

    private val mWordMapper by lazy { WordMapper() }

    var language = "en"

    fun getWord() {
        viewModelScope.launch {
            mViewState.value = WordVS.ShowLoader(true)
            try {
                io {
                    wordInteractor.execute(
                        WordInteractor.Params(
                            language = language
                        )
                    )
                        .collect {
                            ui {
                                mViewState.value = WordVS.Post(mWordMapper.map(it))
                            }
                        }
                }
            } catch (e: Exception) {
                ui {
                    mViewState.value = WordVS.Error(e.message)
                }
            }
            mViewState.value = WordVS.ShowLoader(false)
        }
    }

}