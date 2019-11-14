plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(Android.targetSdk)

    defaultConfig {
        applicationId = "me.jagdeep.papertrailtimber"
        minSdkVersion(Android.minSdk)
        targetSdkVersion(Android.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "PAPERTRAIL_HOST", "\"logsX.papertrailapp.com\"")
        buildConfigField("int", "PAPERTRAIL_PORT", "30123")
    }

    android {
        lintOptions {
            isAbortOnError = false
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isZipAlignEnabled = true
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    testImplementation(Libraries.junit)
    implementation(Libraries.kotlin)
    implementation(Libraries.appCompact)

    implementation(project(":papertrail-timber"))
}
