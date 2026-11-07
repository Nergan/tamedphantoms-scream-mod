package com.tamedphantomsscream.mod.cry

/** Радиус, перезарядка и сложение криков. Выключателя нет: аддон установлен — крик есть. */
object ScreamConfig {
    interface Settings {
        fun radius(): Double
        fun cooldownSeconds(): Int
        fun stacked(): Boolean
    }

    var settings: Settings = Defaults

    fun radius(): Double = settings.radius().coerceIn(4.0, 128.0)

    fun cooldownSeconds(): Int = settings.cooldownSeconds().coerceIn(1, 600)

    fun stacked(): Boolean = settings.stacked()

    private object Defaults : Settings {
        override fun radius() = 32.0
        override fun cooldownSeconds() = 4
        override fun stacked() = true
    }
}
