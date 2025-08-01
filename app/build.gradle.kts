plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt") // For KAPT
}

android {
    namespace = "com.example.routetask"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.routetask"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures{
        viewBinding= true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //retrofit and gson converter and okHttp
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.okhttp)

    //Logging interceptor
    implementation(libs.logging.interceptor)


    //Hilt with Ksp
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)



    //splash screen api
    implementation(libs.androidx.core.splashscreen)

    //glide
    implementation(libs.glide)

    //coroutines
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //room database
    implementation(libs.androidx.room.runtime)
//    ksp(libs.androidx.room.compiler)
    kapt("androidx.room:room-compiler:2.7.2")
    annotationProcessor(libs.androidx.room.compiler)
}