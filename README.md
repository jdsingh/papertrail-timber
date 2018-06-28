# papertrail-timber [![](https://jitpack.io/v/jdsingh/papertrail-timber.svg)](https://jitpack.io/#jdsingh/papertrail-timber)

Timber tree for Papertrail logging.

### How to use

Config Papertrail with your papertrail host and port. Application class is good place for this.

#### Kotlin
```kotlin
val tree = PapertrailTree.Builder()
            .system("Android")
            .program("Papertrail")
            .logger("My-App")
            .host(BuildConfig.PAPERTRAIL_HOST)
            .port(BuildConfig.PAPERTRAIL_PORT)
            .build()
            
Timber.plant(tree)
```

#### Java
```java
final PapertrailTree tree = new PapertrailTree.Builder()
            .system("Android")
            .program("Papertrail")
            .logger("My-App")
            .host(BuildConfig.PAPERTRAIL_HOST)
            .port(BuildConfig.PAPERTRAIL_PORT)
            .build()
            
Timber.plant(tree)
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
    implementation 'com.github.jdsingh:papertrail-timber:1.0.1'
}
```

### Proguard

`consumer-proguard-rules.pro` is included in the library, so you don't need to include these
proguard rules separately. These are the proguard rules used for this library.

```proguard
# Papertrail
-keep class org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslog
-keep class org.productivity.java.syslog4j.impl.net.tcp.ssl.SSLTCPNetSyslogWriter

-dontwarn org.productivity.java.syslog4j.impl.**
-dontwarn ch.qos.logback.core.net.*

```

Thanks
------

Thanks to @tony19 for [logback-android](https://github.com/tony19/logback-android).
