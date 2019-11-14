import java.net.URI

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(BuildScript.gradle)
        classpath(BuildScript.kotlin)
        classpath(BuildScript.mavenGradle)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = URI("https://jitpack.io") }
    }
}

task("clean") {
    delete(rootProject.buildDir)
}
