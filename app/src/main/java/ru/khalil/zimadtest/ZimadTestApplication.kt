package ru.khalil.zimadtest

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ru.khalil.zimadtest.data.network.ZimadApiService
import ru.khalil.zimadtest.data.repository.TabRepository
import ru.khalil.zimadtest.data.repository.TabRepositoryImpl
import ru.khalil.zimadtest.ui.cat.list.CatListViewModelFactory
import ru.khalil.zimadtest.ui.dog.list.DogListViewModelFactory

class ZimadTestApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy {

        bind() from singleton { ZimadApiService() }
        bind<TabRepository>() with singleton {
            TabRepositoryImpl(instance())
        }

        bind() from provider { CatListViewModelFactory(instance()) }
        bind() from provider { DogListViewModelFactory(instance()) }
    }
}