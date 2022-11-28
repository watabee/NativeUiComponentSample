package com.nativeuicomponentsample

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.RCTEventEmitter

class RainbowView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr), Runnable {

    var updateMillis: Int = 1000
    private var index = 0

    override fun onDetachedFromWindow() {
        handler.removeCallbacks(this)
        super.onDetachedFromWindow()
    }

    private fun sendMessage() {
        handler.postDelayed(this, updateMillis.toLong())
    }

    override fun run() {
        if (index >= COLORS.size) {
            index = 0
        }
        val color = COLORS[index++]
        sendColorChangedEventToJs(color)

        setBackgroundColor(color)
        sendMessage()
    }

    fun startChangeColor() {
        stopChangeColor()
        sendMessage()
    }

    fun stopChangeColor() {
        handler.removeCallbacks(this)
    }

    private fun sendColorChangedEventToJs(color: Int) {
        val arguments: WritableMap = Arguments.createMap().apply {
            putString("color", "0x${color.toUInt().toString(16)}")
        }
        (context as ReactContext)
            .getJSModule(RCTEventEmitter::class.java)
            .receiveEvent(id, "topColorChanged", arguments)
    }

    companion object {
        private val COLORS = listOf(
            Color.RED, 0xFFFFA500.toInt(), Color.YELLOW, 0xFF008000.toInt(), Color.CYAN, Color.BLUE, 0xFF800080.toInt()
        )
    }
}
