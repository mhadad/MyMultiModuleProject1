pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
        maven("https://maven.google.com")
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.google.com")
    }
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
}


rootProject.name = "My Multi Module Application1"
include(":app")
include(":products_list_viewer")
include(":products_list_search")
