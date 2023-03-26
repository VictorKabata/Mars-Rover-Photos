plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.vickbt.test"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

    }
}

dependencies {

    implementation(project(":domain"))
    implementation(project(":data:network"))

}
