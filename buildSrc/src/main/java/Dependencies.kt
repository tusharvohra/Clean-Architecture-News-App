object Versions {
    const val core = "1.7.0"
    const val appcompat = "1.6.1"
    const val androidMaterial = "1.8.0"
    const val constraintLayout = "2.1.4"

    const val testImplJunit = "4.13.2"
    const val androidTestImplJunit = "1.1.4"
    const val androidTestEspresso = "3.5.1"

    const val retrofit = "2.9.0"
    const val gsonConvertor = "2.9.0"
    const val okHttp = "4.10.0"

    //    const val scalerConvertor = "2.1.0"
    const val loggingInterceptor = "4.10.0"

    const val kotlinCoroutines = "1.6.4"

    const val coroutineLifecycleScope = "2.5.1"

    const val glide = "4.12.0"

    const val viewModelDeligate = "1.6.0"

    const val dagger = "2.45"
    const val hiltCompiler = "1.0.0"

    const val swipeRefresh = "1.1.0"

    const val ssp = "1.1.0"
    const val sdp = "1.1.0"
}

object Deps {

    const val core = "androidx.core:core-ktx:${Versions.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

}

object TestImplementation {

    const val junit = "junit:junit:${Versions.testImplJunit}"
}

object AndroidTestImplementation {

    const val junit = "androidx.test.ext:junit:${Versions.androidTestImplJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}"

}


object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.gsonConvertor}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val loggingIntercepter =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
//    const val scalersConvertors =
//        "com.squareup.retrofit2:converter-scalars:${Versions.scalerConvertor}"
}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinCoroutines}"
}

object CoroutinesLifecycleScope {
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.coroutineLifecycleScope}"
    const val lifeCycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutineLifecycleScope}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val annotationProcessor = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object ViewModelDelegate {
    const val viewModelDeligate = "androidx.activity:activity-ktx:${Versions.viewModelDeligate}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
}

object CircularProgressBar {
    const val swipeRefresh =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefresh}"
}

object Dimensions {
    const val ssp = "com.intuit.ssp:ssp-android:${Versions.ssp}"
    const val sdp = "com.intuit.sdp:sdp-android:${Versions.sdp}"
}
