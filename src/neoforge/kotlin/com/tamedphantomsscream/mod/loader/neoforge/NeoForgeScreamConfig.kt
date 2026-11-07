package com.tamedphantomsscream.mod.loader.neoforge

import com.tamedphantomsscream.mod.cry.ScreamConfig
import net.neoforged.neoforge.common.ModConfigSpec

class NeoForgeScreamConfig(builder: ModConfigSpec.Builder) {
    companion object {
        val SPEC: ModConfigSpec
        val CONFIG: NeoForgeScreamConfig

        init {
            val pair = ModConfigSpec.Builder().configure(::NeoForgeScreamConfig)
            CONFIG = pair.getLeft()
            SPEC = pair.getRight()
        }

        fun bind() {
            val cfg = CONFIG
            ScreamConfig.settings = object : ScreamConfig.Settings {
                override fun radius() = if (SPEC.isLoaded) cfg.radius.get() else 32.0
                override fun cooldownSeconds() = if (SPEC.isLoaded) cfg.cooldown.get() else 4
                override fun stacked() = if (SPEC.isLoaded) cfg.stacked.get() else true
            }
        }
    }

    val radius: ModConfigSpec.DoubleValue
    val cooldown: ModConfigSpec.IntValue
    val stacked: ModConfigSpec.BooleanValue

    init {
        builder.push("scream")
        radius = builder
            .comment("Радиус крика в блоках: мобы в этом радиусе разбегаются.")
            .translation("tamedphantomsscream.configuration.radius")
            .defineInRange("scream_radius", 32.0, 4.0, 128.0)
        cooldown = builder
            .comment("Перезарядка крика в секундах. Общая для хозяина, самозащиты, игры и полнолуния.")
            .translation("tamedphantomsscream.configuration.cooldown")
            .defineInRange("scream_cooldown_seconds", 4, 1, 600)
        stacked = builder
            .comment(
                "Несколько криков сразу усиливают друг друга.",
                "Два крика — слепота вдвое дольше. С трёх добавляется урон. Девять — потолок.",
            )
            .translation("tamedphantomsscream.configuration.stacked")
            .define("stacked_screams", true)
        builder.pop()
    }
}
