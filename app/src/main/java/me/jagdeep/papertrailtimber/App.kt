package me.jagdeep.papertrailtimber

import android.app.Application
import me.jagdeep.papertrail.timber.PapertrailTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val tree = PapertrailTree(
                "My-Awesome-App",
                "Papertrail",
                BuildConfig.PAPERTRAIL_HOST,
                BuildConfig.PAPERTRAIL_PORT
        )

        Timber.plant(tree, Timber.DebugTree())
    }

}
