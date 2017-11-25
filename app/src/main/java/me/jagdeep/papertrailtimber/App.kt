package me.jagdeep.papertrailtimber

import android.app.Application
import me.jagdeep.papertrail.timber.Papertrail
import me.jagdeep.papertrail.timber.PapertrailTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()


        Papertrail.init("Papertrail",
                BuildConfig.PAPERTRAIL_HOST,
                BuildConfig.PAPERTRAIL_PORT)

        Timber.plant(PapertrailTree("My-Awesome-App"))
    }

}