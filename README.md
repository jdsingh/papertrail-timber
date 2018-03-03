# papertrail-timber [![](https://jitpack.io/v/jdsingh/papertrail-timber.svg)](https://jitpack.io/#jdsingh/papertrail-timber)

Timber tree for Papertrail logging.

### How to use

Config Papertrail with your papertrail host and port. Application class is good place for this.

#### Kotlin
```kotlin
Timber.plant(PapertrailTree("logger-name", "AppName", "PAPERTRAIL_HOST", PAPERTRAIL_PORT))
```

#### Java
```java
Timber.plant(new PapertrailTree("logger-name", "AppName", "PAPERTRAIL_HOST", PAPERTRAIL_PORT))
```

Once this setup is done, all Timber logs will be sent to Papertrail.

### Download

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```groovy
dependencies {
    implementation 'com.github.jdsingh:papertrail-timber:0.0.7'
}
```

### Proguard

```proguard
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
```

Thanks
------

Thanks to @tony19 for [logback-android](https://github.com/tony19/logback-android).
