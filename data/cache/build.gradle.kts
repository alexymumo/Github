plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.codes.cache"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles = "consumer-rules.pro"
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
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
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.android.appCompat)

    //testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("com.google.truth:truth:1.1.3")
    androidTestImplementation("android.arch.core:core-testing:1.1.1")

    // Roboelectric
    testImplementation(libs.test.roboelectric)

    implementation("androidx.test:core-ktx:1.5.0")

    // Timber
    testImplementation(libs.logger.timber)

    // Room
    implementation(libs.room.ktx)
    kapt(libs.room.compiler)
    annotationProcessor(libs.room.compiler)
    api(libs.room.runtime)
    testImplementation(libs.room.testing)

    // Timber
    implementation(libs.logger.timber)

    // Coroutine
    implementation(libs.coroutine.android)
    implementation(libs.coroutine.core)
    implementation(libs.coroutine.testing)

    // Hilt
    implementation(libs.android.hilt)
    kapt(libs.android.hilt.compiler)
}