package com.funnythingz.funnyflash

import processing.core.PApplet

class Sketch : PApplet() {

    private enum class BackgroundColor {
        BLACK,
        RANDOM
    }

    private var backgroundColor: BackgroundColor? = null

    private fun switchBackgroundColor() {
        when (this.backgroundColor) {
            Sketch.BackgroundColor.BLACK -> {
                this.backgroundColor = BackgroundColor.RANDOM
                background(random(256f), random(256f), random(256f))
            }
            Sketch.BackgroundColor.RANDOM -> {
                this.backgroundColor = BackgroundColor.BLACK
                background(0)
            }
        }
    }

    private fun selectBackgroundColor(backgroundColor: BackgroundColor) {
        this.backgroundColor = backgroundColor
        when (this.backgroundColor) {
            Sketch.BackgroundColor.BLACK -> background(0)
            Sketch.BackgroundColor.RANDOM -> background(random(256f), random(256f), random(256f))
        }
    }

    override fun settings() {
        fullScreen()
    }

    private var wpx: Float = 0f
    private var hpx: Float = 0f

    override fun setup() {
        selectBackgroundColor(BackgroundColor.BLACK)
        wpx = displayWidth / 10f
        hpx = displayHeight / 16f
    }

    override fun draw() {
        if (mousePressed) {
            switchBackgroundColor()
        }
        var x: Float = 0f
        while (x < width) {
            var y: Float = 0f
            while (y < height) {
                noFill()
                stroke(random(255f), random(255f), random(255f))
                rect(x, y, wpx, hpx)
                y += hpx
            }
            x += wpx
        }
        noFill()
        stroke(random(255f), random(255f), random(255f))
        rect(wpx * 9 - 1, hpx * 15 - 1, wpx, hpx)
    }

    override fun mouseReleased() {
        super.mouseReleased()
        selectBackgroundColor(BackgroundColor.BLACK)
    }
}