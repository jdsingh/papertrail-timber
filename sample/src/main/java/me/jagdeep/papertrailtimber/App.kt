package me.jagdeep.papertrailtimber

import android.app.Application
import me.jagdeep.papertrail.timber.PapertrailTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // "1.0,v1"
        val logger = buildString {
            append(BuildConfig.VERSION_NAME)
            append(",")
            append("v")
            append(BuildConfig.VERSION_CODE)
        }

        val tree = PapertrailTree.Builder()
            .system("Android")
            .program("Papertrail")
            .logger(logger)
            .host(BuildConfig.PAPERTRAIL_HOST)
            .port(BuildConfig.PAPERTRAIL_PORT)
            .build()

        Timber.plant(tree, Timber.DebugTree())
    }

}
