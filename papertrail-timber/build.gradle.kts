plugins {
    id("com.android.library")
    kotlin("android")
    id("com.github.dcendents.android-maven")
}

group = "com.github.jdsingh"

android {
    compileSdkVersion(Android.targetSdk)

    defaultConfig {
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        consumerProguardFile("consumer-proguard-rules.pro")
    }

    // TODO replace with https://issuetracker.google.com/issues/72050365 once released.
    libraryVariants.all {
        generateBuildConfig?.enabled = false
    }

    lintOptions {
        isAbortOnError = true
        htmlReport = true
        setHtmlOutput(file("${project.buildDir}/reports/lint/lint.html"))
        setLintConfig(file("lint.xml"))
    }
}

dependencies {
    testImplementation(Libraries.junit)
    api(Libraries.kotlin)
    api(Libraries.timber)
    api(Libraries.slf4j)
    api(Libraries.logbackAndroidCore)
    api(Libraries.logbackAndroidClassic) {
        exclude("com.google.android", "android")
    }
    api(Libraries.logbackSyslog4j) {
        exclude("ch.qos.logback")
    }
}
