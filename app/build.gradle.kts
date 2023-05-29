plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("com.google.firebase.appdistribution")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.codes.githubapp"
    compileSdk = 33


    defaultConfig {
        applicationId = "com.codes.githubapp"
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
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }


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
    testOptions {
        managedDevices {

        }
        unitTests {
            isIncludeAndroidResources = true
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    // Modules
    implementation(project(":domain"))
    implementation(project(":common"))
    implementation(project(":data:repository"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.android.appCompat)

    //implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")


    implementation(libs.bundles.compose)

//    implementation(libs.compose)

    // Test
    androidTestImplementation(libs.compose.ui.test.junit)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

    testImplementation(libs.compose.ui.test.junit)
    testImplementation(libs.test.roboelectric)
    testImplementation(libs.junit)

    // Material
    implementation(libs.material.compose)

    // Accompanist
    implementation("com.google.accompanist:accompanist-pager:0.31.2-alpha")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.31.2-alpha")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.5.3")

    // Coil
    implementation(libs.coil.compose)

    // Timber
    implementation(libs.logger.timber)

    // Lifecycle
    implementation(libs.lifecycle.runtime)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.viewmodel.compose)

    // Coroutine
    implementation(libs.coroutine.android)
    implementation(libs.coroutine.core)
    implementation(libs.coroutine.testing)

    implementation(libs.android.hilt.nav.compose)
    // Hilt
    implementation(libs.android.hilt)
    kapt(libs.android.hilt.compiler)

}