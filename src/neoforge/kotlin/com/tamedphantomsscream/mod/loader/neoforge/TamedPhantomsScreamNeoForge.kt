package com.tamedphantomsscream.mod.loader.neoforge

import com.tamedphantomsscream.mod.TamedPhantomsScream
import com.tamedphantomsscream.mod.client.MoonSickness
import com.tamedphantomsscream.mod.network.MoonPulsePayload
import com.tamedphantomsscream.mod.network.ScreamNetwork
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import net.neoforged.fml.loading.FMLEnvironment
import net.neoforged.neoforge.client.event.ClientTickEvent
import net.neoforged.neoforge.client.event.ViewportEvent
import net.neoforged.neoforge.common.NeoForge
import net.neoforged.neoforge.network.PacketDistributor
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent

@Mod(TamedPhantomsScream.MOD_ID)
class TamedPhantomsScreamNeoForge(bus: IEventBus, container: ModContainer) {
    init {
        container.registerConfig(ModConfig.Type.SERVER, NeoForgeScreamConfig.SPEC)
        NeoForgeScreamConfig.bind()
        bus.addListener(::registerPayloads)
        ScreamNetwork.sendToDimension = { level, payload ->
            PacketDistributor.sendToPlayersInDimension(level, payload)
        }
        TamedPhantomsScream.init()
        if (FMLEnvironment.dist == Dist.CLIENT) {
            val events = NeoForge.EVENT_BUS
            events.addListener { _: ClientTickEvent.Post -> MoonSickness.tick() }
            events.addListener { event: ViewportEvent.ComputeFogColor ->
                val tint = MoonSickness.tint(event.red, event.green, event.blue) ?: return@addListener
                event.red = tint.red
                event.green = tint.green
                event.blue = tint.blue
            }
        }
    }

    private fun registerPayloads(event: RegisterPayloadHandlersEvent) {
        event.registrar(TamedPhantomsScream.MOD_ID).playToClient(
            MoonPulsePayload.TYPE,
            MoonPulsePayload.STREAM_CODEC,
        ) { _, context ->
            context.enqueueWork { MoonSickness.trigger() }
        }
    }
}
