plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.hasantuncay.practise"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hasantuncay.practise"
        minSdk = 22
        targetSdk = 34
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    dependencies {
        val paging_version = "3.2.1"

        implementation("androidx.paging:paging-runtime:$paging_version")

        // alternatively - without Android dependencies for tests
        testImplementation("androidx.paging:paging-common:$paging_version")

        // optional - RxJava2 support
        implementation("androidx.paging:paging-rxjava2:$paging_version")

        // optional - RxJava3 support
        implementation("androidx.paging:paging-rxjava3:$paging_version")

        // optional - Guava ListenableFuture support
        implementation("androidx.paging:paging-guava:$paging_version")

        // optional - Jetpack Compose integration
        implementation("androidx.paging:paging-compose:3.3.0-alpha02")
    }
    val nav_version = "2.7.6"

    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.6")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

   implementation("androidx.compose.ui:ui:1.6.0")
 implementation("androidx.compose.material:material:1.6.0")



}