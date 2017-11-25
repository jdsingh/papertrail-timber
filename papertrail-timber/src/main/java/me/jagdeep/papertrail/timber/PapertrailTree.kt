package me.jagdeep.papertrail.timber

import android.util.Log
import org.slf4j.LoggerFactory
import timber.log.Timber

/**
 * Timber Tree for sending logs to PaperTrail.
 */
class PapertrailTree(logger: String) : Timber.DebugTree() {

    private val logger = LoggerFactory.getLogger(logger)

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE) {
            return
        }

        val msg = if (tag != null) "[$tag]: $message" else message

        when (priority) {
            Log.DEBUG -> logger.debug(msg)
            Log.INFO -> logger.info(msg)
            Log.WARN -> logger.warn(msg)
            Log.ERROR -> logger.error(msg)
        }
    }

}