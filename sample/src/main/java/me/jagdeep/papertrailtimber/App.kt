package me.jagdeep.papertrailtimber

import android.app.Application
import me.jagdeep.papertrail.timber.PapertrailTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val system = "PapertrailTimber"

        // "v1"
        val program = "v${BuildConfig.VERSION_CODE}"

        // "1.0"
        val logger = BuildConfig.VERSION_NAME

        val tree = PapertrailTree.Builder()
            .system(system)
            .program(program)
            .logger(logger)
            .host(BuildConfig.PAPERTRAIL_HOST)
            .port(BuildConfig.PAPERTRAIL_PORT)
            .build()

        Timber.plant(tree, Timber.DebugTree())
    }

}
