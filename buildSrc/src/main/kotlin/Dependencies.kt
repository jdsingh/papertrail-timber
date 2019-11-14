object Version {
    const val kotlin = "1.3.50"
    const val gradle = "3.5.2"
    const val mavenGradle = "2.1"

    const val junit = "4.12"
    const val appCompact = "1.1.0"
    const val timber = "4.7.1"
    const val slf4j = "1.7.29"
    const val logbackAndroidCore = "1.1.1-6"
    const val logbackAndroidClassic = "1.1.1-6"
    const val logbackSyslog4j = "1.0.0"
}

object BuildScript {
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
    const val mavenGradle = "com.github.dcendents:android-maven-gradle-plugin:${Version.mavenGradle}"
}

object Android {
    const val minSdk = 19
    const val targetSdk = 29
}

object Libraries {
    const val junit = "junit:junit:${Version.junit}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
    const val appCompact = "androidx.appcompat:appcompat:${Version.appCompact}"
    const val timber = "com.jakewharton.timber:timber:${Version.timber}"
    const val slf4j = "org.slf4j:slf4j-api:${Version.slf4j}"
    const val logbackAndroidCore = "com.github.tony19:logback-android-core:${Version.logbackAndroidCore}"
    const val logbackAndroidClassic = "com.github.tony19:logback-android-classic:${Version.logbackAndroidClassic}"
    const val logbackSyslog4j = "com.papertrailapp:logback-syslog4j:${Version.logbackSyslog4j}"
}
