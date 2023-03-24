plugins {
    // id ("java-library")
    alias(libs.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_7
    targetCompatibility = JavaVersion.VERSION_1_7
}

dependencies{
    api(libs.kotlinX.coroutines)
    api(libs.koin.core)
    api(libs.paging.kotlin)
}