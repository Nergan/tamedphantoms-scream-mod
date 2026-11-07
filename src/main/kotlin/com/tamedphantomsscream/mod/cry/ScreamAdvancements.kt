package com.tamedphantomsscream.mod.cry

import com.tamedphantomsscream.mod.TamedPhantomsScream
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer

object ScreamAdvancements {
    private val WINGED_BEAST = ResourceLocation.fromNamespaceAndPath(TamedPhantomsScream.MOD_ID, "winged_beast")
    private val SICK_MOON = ResourceLocation.fromNamespaceAndPath(TamedPhantomsScream.MOD_ID, "sick_moon")

    fun grantWingedBeast(player: ServerPlayer) = grant(player, WINGED_BEAST, "screamed")

    fun grantSickMoon(player: ServerPlayer) = grant(player, SICK_MOON, "heard_moon")

    private fun grant(player: ServerPlayer, advancementId: ResourceLocation, criterion: String) {
        try {
            val holder = player.server.advancements.get(advancementId)
            if (holder == null) {
                TamedPhantomsScream.LOGGER.warn("Достижение {} не загружено.", advancementId)
                return
            }
            player.advancements.award(holder, criterion)
        } catch (error: Throwable) {
            TamedPhantomsScream.LOGGER.warn("Не удалось выдать достижение {}", advancementId, error)
        }
    }
}
