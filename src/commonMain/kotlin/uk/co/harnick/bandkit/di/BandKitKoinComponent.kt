package uk.co.harnick.bandkit.di

import org.koin.core.component.KoinComponent

abstract class BandKitKoinComponent : KoinComponent {
    override fun getKoin() = BandKitKoinContext.koin
}
