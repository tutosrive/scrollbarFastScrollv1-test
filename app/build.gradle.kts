plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.srm.scrollbar_fastscroll_v1"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.srm.scrollbar_fastscroll_v1"
        minSdk = 37
        targetSdk = 37
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
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

    // Source: https://mvnrepository.com/artifact/io.github.l4digital/fastscroll
    implementation("io.github.l4digital:fastscroll:3.0.0-beta.3")
}