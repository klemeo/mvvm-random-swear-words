package ru.android.randomswearwords.app

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.android.randomswearwords.data.ApiRepositoryImpl
import ru.android.randomswearwords.data.PostResponseDataSource
import ru.android.randomswearwords.domain.ApiRepository
import ru.android.randomswearwords.domain.interactor.WordInteractor
import ru.android.randomswearwords.presentation.home.HomeViewModel

private val postModule = module {

    //region ViewModel

    viewModel {
        HomeViewModel(
            wordInteractor = get()
        )
    }
    //endregion

    //region Interactor
    single {
        WordInteractor(
            apiRepository = get()
        )
    }

    //endregion

    //region Repository
    single<ApiRepository> {
        ApiRepositoryImpl(
            apiResponseDataSource = get()
        )
    }
    //endregion

    //region Datastore
    single {
        PostResponseDataSource()
    }
    //endregion
}

val modules = listOf(postModule)