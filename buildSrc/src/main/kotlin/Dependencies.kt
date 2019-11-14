object Version {
    const val kotlin = "1.3.50"
    const val gradle = "3.5.2"
    const val mavenGradle = "2.1"

    const val junit = "4.12"
    const val appCompact = "1.1.0"
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
}
