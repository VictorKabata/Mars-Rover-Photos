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

    implementation(libs.ktor.mock)
    implementation(libs.ktor.contentNegotiation)
    implementation(libs.ktor.json)
    implementation(libs.ktor.logging)
    implementation(libs.kotlinX.serializationJson)

}
