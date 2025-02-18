// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.ksp) apply false
//    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.hilt) version libs.versions.hilt apply false
    alias(libs.plugins.kotlin.compose) apply false
}
//allprojects {
//    configurations.all {
//        resolutionStrategy.eachDependency {
//            if (this.requested.group == "com.google.dagger") {
//                this.useVersion("HEAD-SNAPSHOT")
//            }
//        }
//    }
//}
