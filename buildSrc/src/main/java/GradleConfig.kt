object Kotlin {
    const val VERSION = "1.4.31"
}

object ProjectConfig {
    const val GRADLE = "com.android.tools.build:gradle:4.0.0"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.VERSION}"
    const val DAGGER_HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:2.28-alpha"
    const val JUNIT_5_PLUGIN = "de.mannodermaus.gradle.plugins:android-junit5:1.7.1.1"

}

object AndroidConfig {
    const val COMPILE_AND_TARGET_SDK = 29
    const val APPLICATION_ID = "com.kids"
    const val MIN_SDK = 21
    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0.0"
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
}

object JetBrain {
    private const val JDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Kotlin.VERSION}"
}

object Google {
    const val MATERIAL = "com.google.android.material:material:1.1.0"
}

object TestConfig {
    private const val JUNIT = "junit:junit:4.12"
    private const val JUNIT_VERSION = "5.7.1"

    const val EXT_JUNIT = "androidx.test.ext:junit:1.1.1"
    const val ESPRESSO = "androidx.test.espresso:espresso-core:3.2.0"
    const val CORE_TESTING = "androidx.arch.core:core-testing:2.1.0"
    const val JUNIT_JUPITER_API = "org.junit.jupiter:junit-jupiter-api:$JUNIT_VERSION"
    const val JUNIT_JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:$JUNIT_VERSION"
    const val JUNIT_JUPITER_PARAMS = "org.junit.jupiter:junit-jupiter-params:$JUNIT_VERSION"
    const val ASSERT_CORE = "org.assertj:assertj-core:3.18.0"

    const val MOCKK = "io.mockk:mockk:1.10.6"

}

object AndroidDxConfig {
    private const val LIFECYCLE_VERSION = "2.2.0"
    private const val NAVIGATION_VERSION = "2.3.0"
    private const val ROOM_VERSION = "2.3.0"
    private const val PAGING_VERSION = "3.0.0-alpha01"

    const val APPCOMPAT = "androidx.appcompat:appcompat:1.1.0"

    const val CORE_KTX = "androidx.core:core-ktx:1.3.0"
    const val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_VERSION"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VERSION"
    const val LIFECYCLE_EXT = "androidx.lifecycle:lifecycle-extensions:$LIFECYCLE_VERSION"

    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"

    //ActivityResultContract
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:1.2.0-alpha06"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:1.3.0-alpha06"

    //Navigation
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment:$NAVIGATION_VERSION"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui:$NAVIGATION_VERSION"
    const val NAVIGATION_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
    const val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"

    //Room
    const val ROOM_RUNTIME = "androidx.room:room-runtime:$ROOM_VERSION"
    const val ROOM_COMPILER = "androidx.room:room-compiler:$ROOM_VERSION"
    const val ROOM_TESTING = "androidx.room:room-testing:$ROOM_VERSION"

    //Paging 3.0 core dependencies Injection
    const val PAGING = "androidx.paging:paging-runtime:$PAGING_VERSION"

}


object Dependencies {

    private const val GLIDE_VERSION = "4.11.0"
    private const val COROUTINE_VERSION = "1.5.1"

    private const val HILT_VER = "2.33-beta"

    //Logger
    const val TIMBER = "com.jakewharton.timber:timber:4.7.1"

    //Glide
    const val GLIDE = "com.github.bumptech.glide:glide:$GLIDE_VERSION"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:$GLIDE_VERSION"

    //Coroutine
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINE_VERSION"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINE_VERSION"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.1"

    //dagger-hilt
    const val HILT_ANDROID = "com.google.dagger:hilt-android:$HILT_VER"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:$HILT_VER"
    const val HILT_TESTING = "com.google.dagger:hilt-android-testing:$HILT_VER"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:$HILT_VER"

    //TedPermmision
    const val TED_PERMISION = "gun0912.ted:tedpermission-rx2:2.2.3"

}

object NetworkDependencies {
    private const val RETROFIT_VERSION = "2.9.0"
    private const val MOSHI_VERSION = "1.9.2"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val RETROFIT_MOCK = "com.squareup.retrofit2:retrofit-mock:$RETROFIT_VERSION"
    const val GSON = "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION"
    const val CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION"
    const val LOGGING = "com.squareup.okhttp3:logging-interceptor:4.7.2"

    const val MOSHI = "com.squareup.moshi:moshi:$MOSHI_VERSION"
    const val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:$MOSHI_VERSION"
    const val MOSHI_KOTLIN_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VERSION"
}