# Papertrail
-keep class ch.qos.** { *; }
-keep class org.slf4j.** { *; }
-keep class com.papertrailapp.logback.Syslog4jAppender
-keep class org.productivity.java.syslog4j.** { *; }

-dontwarn ch.qos.logback.core.net.*
-dontwarn org.apache.log4j.**
-dontwarn org.apache.commons.**
-dontwarn com.sun.jna.*

-dontwarn org.productivity.java.syslog4j.impl.log4j.Syslog4jAppenderSkeleton
-dontwarn org.productivity.java.syslog4j.impl.unix.socket.UnixSocketSyslog