package com.nativeuicomponentsample

import com.facebook.react.bridge.ReadableArray
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class RainbowViewManager : SimpleViewManager<RainbowView>() {
    override fun getName(): String {
        return "RainbowView"
    }

    override fun createViewInstance(reactContext: ThemedReactContext): RainbowView {
        return RainbowView(reactContext)
    }

    @ReactProp(name = "updateMillis", defaultInt = 1000)
    fun setUpdateMillis(view: RainbowView, updateMillis: Int) {
        view.updateMillis = updateMillis
    }

    override fun getExportedViewConstants(): Map<String, Any> {
        return mapOf("DEFAULT_INT_VALUE" to 1, "DEFAULT_STRING_VALUE" to "hoge")
    }

    override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any> {
        return mutableMapOf(
            "topColorChanged" // イベントを送信する際に指定する名前
                to mutableMapOf("registrationName" to "onColorChanged") // React Native 側でイベントを参照する際に使う名前
        )
    }

    override fun getCommandsMap(): Map<String, Int> {
        return mapOf("start" to COMMAND_START, "stop" to COMMAND_STOP)
    }

    override fun receiveCommand(view: RainbowView, commandId: String, args: ReadableArray?) {
        super.receiveCommand(view, commandId, args)

        when (commandId.toInt()) {
            COMMAND_START -> {
                view.startChangeColor()
            }
            COMMAND_STOP -> {
                view.stopChangeColor()
            }
        }
    }

    companion object {
        private const val COMMAND_START = 1
        private const val COMMAND_STOP = 2
    }
}
