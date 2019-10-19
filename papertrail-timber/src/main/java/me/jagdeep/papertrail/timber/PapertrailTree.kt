package me.jagdeep.papertrail.timber

import android.util.Log
import me.jagdeep.papertrail.timber.internal.Configuration
import org.slf4j.Logger
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
    port: Int,
    private val logPriority: Int
) : Timber.DebugTree() {

    private val log: Logger = LoggerFactory.getLogger(logger)

    init {
        Configuration(system, program, host, port)
    }

    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority < logPriority) {
            return
        }

        val msg = if (tag != null) "[$tag]: $message" else message

        when (priority) {
            Log.DEBUG -> log.debug(msg)
            Log.INFO -> log.info(msg)
            Log.WARN -> log.warn(msg)
            Log.ERROR -> log.error(msg)
        }
    }

    class Builder {
        private lateinit var _system: String
        private lateinit var _program: String
        private lateinit var _logger: String
        private lateinit var _host: String
        private var _port: Int = 0
        private var _priority: Int = Log.DEBUG

        /** System name for Papertrail logs. */
        fun system(system: String): Builder {
            _system = system
            return this
        }

        /** Program name for Papertrail logs. */
        fun program(program: String): Builder {
            _program = program
            return this
        }

        /** Logger name for Papertrail logs. */
        fun logger(logger: String): Builder {
            _logger = logger
            return this
        }

        /** Host for Papertrail logs. */
        fun host(host: String): Builder {
            _host = host
            return this
        }

        /** Port for Papertrail logs. */
        fun port(port: Int): Builder {
            _port = port
            return this
        }

        /**
         * Priority level filter. Logs with priority level of equal or higher will be
         * sent to papertrail.
         *
         * Priority levels:
         * DEBUG = 3
         * INFO = 4
         * WARN = 5
         * ERROR = 6
         *
         * Default is DEBUG
         *
         * @param priority Priority level filter.
         */
        fun priority(priority: Int): Builder {
            _priority = priority
            return this
        }

        fun build(): PapertrailTree {
            require(::_system.isInitialized) { "system is required" }
            require(::_program.isInitialized) { "program is required" }
            require(::_logger.isInitialized) { "logger is required" }
            require(::_host.isInitialized) { "host is required" }
            require(_port != 0) { "port is required" }

            return PapertrailTree(
                _system, _program, _logger, _host, _port, _priority
            )
        }
    }

}
