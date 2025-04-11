plugins {
    id("com.android.library")
}

android {
    namespace = "com.microsoft.tiktok"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    //... other dependencies
    implementation("com.github.tiktok:tiktok-business-android-sdk:1.3.8");
    //to listen for app life cycle
    implementation("androidx.lifecycle:lifecycle-process:2.3.1");
    implementation("androidx.lifecycle:lifecycle-common-java8:2.3.1");
    //to get Google install referrer
    implementation("com.android.installreferrer:installreferrer:2.2");
}
