rootProject.name = "MARS ROVER"

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include (":app")
include (":domain")
include (":data:network")
include (":data:repository")
include (":data:cache")
