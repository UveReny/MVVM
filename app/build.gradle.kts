plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.mvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvm"
        minSdk = 18
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding=true
    }
}

dependencies {
    val recyclerview_version = "1.3.2"
    val lifecycle_version = "2.6.2"
    val coroutine_version = "1.6.4"
    val room_version = "2.6.0"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    // Add RecyclerView
    implementation("androidx.recyclerview:recyclerview:$recyclerview_version")
    // Add LifeCycle&LiveData&ViewModel
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    // Add Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutine_version")
    // Add Room
    implementation("androidx.room:room-runtime:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
        // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
        // To use Kotlin Symbol Processing (KSP)
    // ksp("androidx.room:room-compiler:$room_version")

    testImplementation("junit:junit:4.13.2")
    // optional - Test helpers for Room
    testImplementation("androidx.room:room-testing:$room_version")

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}