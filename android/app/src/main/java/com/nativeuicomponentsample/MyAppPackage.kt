package com.nativeuicomponentsample

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext

class MyAppPackage : ReactPackage {
    override fun createNativeModules(reactContext: ReactApplicationContext) =
        emptyList<NativeModule>()

    override fun createViewManagers(reactContext: ReactApplicationContext) =
        mutableListOf(RainbowViewManager())
}
