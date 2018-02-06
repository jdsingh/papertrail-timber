package me.jagdeep.papertrail.timber

import ch.qos.logback.classic.AsyncAppender
import ch.qos.logback.classic.Logger
import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.PatternLayout
import ch.qos.logback.classic.spi.ILoggingEvent
import com.papertrailapp.logback.Syslog4jAppender
import org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslogConfig
import org.slf4j.LoggerFactory

/**
 * Configure Papertrail with Android logback.
 */
internal object Papertrail {

    fun init(appName: String, host: String, port: Int) {
        // Reset the default context (which may already have been initialized)
        // since we want to reconfigure it
        val loggerContext = (LoggerFactory.getILoggerFactory() as LoggerContext).apply {
            reset()
        }

        val config = SSLTCPNetSyslogConfig().apply {
            this.host = host
            this.port = port
            isSendLocalName = false
            isSendLocalTimestamp = false
            maxMessageLength = 128000
        }

        val patternLayout = PatternLayout().apply {
            context = loggerContext
            pattern = "%d{MMM dd HH:mm:ss} Android $appName: %logger{35} %-5level %m%n"
            start()
        }

        val syslog4jAppender = Syslog4jAppender<ILoggingEvent>().apply {
            context = loggerContext
            syslogConfig = config
            layout = patternLayout
            start()
        }

        val asyncAppender = AsyncAppender().apply {
            addAppender(syslog4jAppender)
            start()
        }

        // Add the newly created Appender to the root logger;
        val logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME) as Logger
        logger.addAppender(asyncAppender)
    }

}
