package com.tamedphantomsscream.mod.client

import net.minecraft.util.Mth

/** Секунда болезненно-жёлтой луны после полнолунного крика. */
object MoonSickness {
    @Volatile
    var ticks: Int = 0

    fun trigger() {
        ticks = 20
    }

    fun tick() {
        if (ticks > 0) ticks--
    }

    fun strength(): Float = (ticks / 20f).coerceIn(0f, 1f)

    data class FogTint(val red: Float, val green: Float, val blue: Float)

    fun tint(red: Float, green: Float, blue: Float): FogTint? {
        val strength = strength()
        if (strength <= 0.02f) return null
        return FogTint(
            Mth.lerp(strength, red, 0.62f),
            Mth.lerp(strength, green, 0.48f),
            Mth.lerp(strength, blue, 0.08f),
        )
    }
}
