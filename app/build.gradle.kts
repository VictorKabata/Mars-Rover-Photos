plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.vickbt.marsrover"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.vickbt.marsrover"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    /*testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }*/

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        // kotlinCompilerExtensionVersion = libs.versions.composeCompiler
        kotlinCompilerExtensionVersion = "1.4.0"
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":data:repository"))

    implementation(libs.androidx.core)
    implementation(libs.lifecycle.runtime)
    implementation(libs.compose.activity)
    implementation(libs.compose.ui)
    implementation(libs.compose.preview)
    implementation(libs.compose.material)

    implementation(libs.material)

    implementation(libs.paging.compose)

    implementation(libs.navigation.compose)

    implementation(libs.coil)

    implementation(libs.palette)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)

    testImplementation(project(":core:test"))
    testImplementation(libs.jUnit)
    testImplementation(libs.androidx.jUnit)
    testImplementation(kotlin("test")) //ToDo
    testImplementation(libs.kotlinX.coroutines.test)
    testImplementation(libs.instantTaskExecutor)
    testImplementation(libs.mockk)
    testImplementation(libs.android.test.espresso)
    testImplementation(libs.compose.ui.test)
    testImplementation(libs.robolectric)
    testImplementation(libs.test.runner)
    testImplementation(libs.test.rules)

    androidTestImplementation(libs.androidx.jUnit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.compose.ui.test)

    debugImplementation(libs.compose.tooling)
    debugImplementation(libs.compose.testManifest)
}
