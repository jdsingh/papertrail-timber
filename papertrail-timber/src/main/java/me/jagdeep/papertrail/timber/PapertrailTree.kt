package me.jagdeep.papertrail.timber

import android.util.Log
import org.slf4j.LoggerFactory
import timber.log.Timber

/**
 * Timber Tree for sending logs to PaperTrail.
 *
 * It will send logs to papertrail with format:
 * {MMM dd HH:mm:ss} {system} {program}: {logger} {level} {message}
 */
class PapertrailTree private constructor(
    system: String,
    program: String,
    logger: String,
    host: String,
    port: Int
) : Timber.DebugTree() {

    private val logger = LoggerFactory.getLogger(logger)

    init {
        Papertrail.init(system, program, host, port)
    }

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

    class Builder {
        private lateinit var _system: String
        private lateinit var _program: String
        private lateinit var _logger: String
        private lateinit var _host: String
        private var _port: Int = 0

        fun system(system: String): Builder {
            _system = system
            return this
        }

        fun program(program: String): Builder {
            _program = program
            return this
        }

        fun logger(logger: String): Builder {
            _logger = logger
            return this
        }

        fun host(host: String): Builder {
            _host = host
            return this
        }

        fun port(port: Int): Builder {
            _port = port
            return this
        }

        fun build(): PapertrailTree {
            require(::_system.isInitialized) { "system is required" }
            require(::_program.isInitialized) { "program is required" }
            require(::_logger.isInitialized) { "logger is required" }
            require(::_host.isInitialized) { "host is required" }
            require(_port != 0) { "port is required" }

            return PapertrailTree(
                _system,
                _program,
                _logger,
                _host,
                _port
            )
        }
    }

}
