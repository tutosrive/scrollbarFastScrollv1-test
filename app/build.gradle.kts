/*
 * Copyright (c) 2026 tutosrive. All rights reserved.
 *
 * Author: tutosrive
 * GitHub: https://github.com/tutosrive
 *
 * This source code is PROPRIETARY and CONFIDENTIAL.
 * Unauthorized copying, modification, or distribution of this file,
 * via any medium, is strictly prohibited.
 *
 * This software is provided "as is", without warranty of any kind.
 * In no event shall the author be liable for any claim or damages.
 */

plugins {
    alias(libs.plugins.android.application)
}

android {
    signingConfigs {
        create("release") {
            storeFile = file("D:\\CODE\\AndroidStudio\\sign-tutosrive-key")
            storePassword = "trg;2026;"
            keyAlias = "tutosrive0"
            keyPassword = "trg;2026;"
        }
    }
    namespace = "com.srm.scrollbar_fastscroll_v1"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.srm.scrollbar_fastscroll_v1"
        minSdk = 27
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        signingConfig = signingConfigs.getByName("release")
    }

    splits {
        abi {
            isEnable = true
            reset()
            include("x86", "x86_64", "armeabi-v7a", "arm64-v8a")
            isUniversalApk = false
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true // Just when is release
//            isShrinkResources = false // Just in AAB Release
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            applicationIdSuffix = ".r"

            packaging {
                jniLibs {
                    useLegacyPackaging = false
                }
            }
        }
        getByName("debug") {
            applicationIdSuffix = ".d"
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