package com.tamedphantomsscream.mod.cry

import com.tamedphantoms.mod.api.TamedPhantomsApi
import com.tamedphantoms.mod.entity.TamedPhantomEntity
import com.tamedphantomsscream.mod.network.ScreamNetwork
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.server.MinecraftServer
import net.minecraft.server.level.ServerLevel
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.Mob
import net.minecraft.world.entity.monster.Phantom
import net.minecraft.world.entity.player.Player
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

/** Вся жизнь крика. Без этого объекта родительский мод молчит. */
object PhantomCry : TamedPhantomsApi.Cry {
    private const val PLAY_CHANCE = 0.08f
    private const val PLAY_RANGE = 12.0
    private const val PLAY_PAUSE = 600
    private const val ROLL_QUIET = 5 * 20

    private class Memory {
        var cooldown: Int = 0
        var lock: Int = 0
        var ticks: Int = 0
        var fears: Boolean = false
        var pause: Int = PLAY_PAUSE
    }

    private val memory = ConcurrentHashMap<UUID, Memory>()

    fun register() {
        TamedPhantomsApi.registerCry(this)
    }

    fun answer(phantom: TamedPhantomEntity) {
        val level = phantom.level() as? ServerLevel ?: return
        if (!phantom.isAlive || !phantom.tamed) return
        begin(phantom, level, redEyes = true, blindness = true, awardOwner = null)
    }

    override fun onRollBurst(phantom: TamedPhantomEntity) {
        val state = memory(phantom)
        if (ROLL_QUIET > state.lock) state.lock = ROLL_QUIET
    }

    override fun onRiderKey(phantom: TamedPhantomEntity, player: Player) {
        if (player.vehicle !== phantom || !phantom.isOwnedBy(player)) return
        val serverPlayer = player as? ServerPlayer ?: return
        val state = memory(phantom)
        if (state.lock > 0) {
            tell(serverPlayer, state.lock)
            return
        }
        if (state.cooldown > 0) {
            tell(serverPlayer, state.cooldown)
            return
        }
        val level = phantom.level() as? ServerLevel ?: return
        begin(phantom, level, redEyes = true, blindness = true, awardOwner = serverPlayer)
        PhantomScream.echo(level, phantom, serverPlayer)
    }

    override fun tick(phantom: TamedPhantomEntity, level: ServerLevel) {
        val state = memory(phantom)
        if (state.lock > 0) state.lock--
        if (state.cooldown > 0) state.cooldown--
        if (state.ticks > 0) {
            PhantomScream.frighten(level, phantom, state.fears)
            state.ticks--
            if (state.ticks <= 0) {
                phantom.screamEyeTicks = 0
                state.fears = false
            }
            return
        }
        if (state.cooldown > 0 || !phantom.isAlive) return
        if (phantom.isDefending()) {
            begin(phantom, level, redEyes = true, blindness = true, awardOwner = null)
            return
        }
        if (!phantom.tamed && phantom.tickCount % 20 == 0 &&
            PhantomScream.isFullMoonNight(level) &&
            phantom.random.nextFloat() < 0.12f
        ) {
            begin(phantom, level, redEyes = false, blindness = false, awardOwner = null, moonPulse = true)
            return
        }
        if (state.pause > 0) {
            state.pause--
            return
        }
        if (!phantom.tamed && !phantom.isVehicle && phantom.tickCount % 20 == 0 && phantom.random.nextFloat() < PLAY_CHANCE) {
            val prey = level.getEntitiesOfClass(Mob::class.java, phantom.boundingBox.inflate(PLAY_RANGE)) {
                it !is Phantom && it.isAlive
            }.minByOrNull { it.distanceToSqr(phantom) } ?: return
            phantom.glanceTarget = prey
            begin(phantom, level, redEyes = false, blindness = false, awardOwner = null)
            state.pause = PLAY_PAUSE + phantom.random.nextInt(PLAY_PAUSE)
        }
    }

    override fun flush(server: MinecraftServer) {
        PhantomScream.flush(server)
    }

    override fun exportState(phantom: TamedPhantomEntity): String? {
        val state = memory[phantom.uuid] ?: return null
        return "${state.cooldown},${state.lock},${state.ticks},${if (state.fears) 1 else 0},${state.pause}"
    }

    override fun importState(phantom: TamedPhantomEntity, data: String) {
        val parts = data.split(',')
        if (parts.size != 5) return
        val state = memory(phantom)
        state.cooldown = parts[0].toIntOrNull()?.coerceAtLeast(0) ?: 0
        state.lock = parts[1].toIntOrNull()?.coerceAtLeast(0) ?: 0
        state.ticks = parts[2].toIntOrNull()?.coerceAtLeast(0) ?: 0
        state.fears = parts[3] == "1"
        state.pause = parts[4].toIntOrNull()?.coerceAtLeast(0) ?: PLAY_PAUSE
    }

    private fun begin(
        phantom: TamedPhantomEntity,
        level: ServerLevel,
        redEyes: Boolean,
        blindness: Boolean,
        awardOwner: ServerPlayer?,
        moonPulse: Boolean = false,
    ) {
        val state = memory(phantom)
        state.cooldown = ScreamConfig.cooldownSeconds() * 20
        state.ticks = PhantomScream.EFFECT_TICKS
        state.fears = blindness
        phantom.screamEyeTicks = if (redEyes) PhantomScream.EFFECT_TICKS else 0
        phantom.addEffect(MobEffectInstance(MobEffects.GLOWING, PhantomScream.EFFECT_TICKS, 0, false, false, false))
        PhantomScream.play(level, phantom)
        PhantomScream.note(level, phantom, blindness)
        PhantomScream.frighten(level, phantom, blindness)
        if (moonPulse) {
            ScreamNetwork.moon(level)
            for (listener in PhantomScream.listeners(level, phantom)) {
                ScreamAdvancements.grantSickMoon(listener)
            }
        }
        if (awardOwner != null) {
            ScreamAdvancements.grantWingedBeast(awardOwner)
        }
    }

    private fun memory(phantom: TamedPhantomEntity): Memory = memory.getOrPut(phantom.uuid) { Memory() }

    private fun tell(player: ServerPlayer, ticks: Int) {
        val seconds = (ticks + 19) / 20
        player.displayClientMessage(
            Component.translatable("tamedphantomsscream.cooldown", seconds).withStyle(ChatFormatting.RED),
            true,
        )
    }
}
