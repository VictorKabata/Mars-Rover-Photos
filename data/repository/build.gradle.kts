plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.vickbt.repository"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // consumerProguardFiles = "consumer-rules.pro"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":domain"))
    api(project(":data:network"))

    testImplementation(libs.ktor.contentNegotiation)
    testImplementation(libs.ktor.json)
    testImplementation(libs.ktor.logging)
    testImplementation(libs.kotlinX.serializationJson)

    testImplementation(project(":core:test"))
    testImplementation(libs.jUnit)
    testImplementation(libs.kotlinX.coroutines.test)
    testImplementation(libs.googleTruth)
}
