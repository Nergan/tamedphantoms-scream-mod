package com.tamedphantomsscream.mod.loader.fabric

import com.tamedphantomsscream.mod.TamedPhantomsScream
import com.tamedphantomsscream.mod.cry.ScreamConfig
import net.fabricmc.loader.api.FabricLoader
import java.nio.file.Files

/** `config/tamedphantomsscream-server.toml`. Отдельного выключателя крика нет. */
object FabricScreamSettings {
    fun bind() {
        val path = FabricLoader.getInstance().configDir.resolve("tamedphantomsscream-server.toml")
        val values = HashMap<String, String>()
        if (!Files.exists(path)) {
            path.parent?.let { Files.createDirectories(it) }
            Files.writeString(
                path,
                """
                [scream]
                scream_radius = 32.0
                scream_cooldown_seconds = 4
                stacked_screams = true
                """.trimIndent() + "\n",
            )
        } else {
            for (raw in Files.readString(path).lineSequence()) {
                val line = raw.substringBefore('#').trim()
                val eq = line.indexOf('=')
                if (eq <= 0 || line.startsWith("[")) continue
                values[line.substring(0, eq).trim()] = line.substring(eq + 1).trim()
            }
        }
        val radius = values["scream_radius"]?.toDoubleOrNull() ?: 32.0
        val cooldown = values["scream_cooldown_seconds"]?.toIntOrNull() ?: 4
        val stacked = values["stacked_screams"]?.toBooleanStrictOrNull() ?: true
        ScreamConfig.settings = object : ScreamConfig.Settings {
            override fun radius() = radius
            override fun cooldownSeconds() = cooldown
            override fun stacked() = stacked
        }
        TamedPhantomsScream.LOGGER.info("Крик: радиус {}, перезарядка {} с, сложение {}.", radius, cooldown, stacked)
    }
}
