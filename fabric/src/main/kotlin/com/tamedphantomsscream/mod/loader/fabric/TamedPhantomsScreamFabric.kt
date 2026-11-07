package com.tamedphantomsscream.mod.loader.fabric

import com.tamedphantomsscream.mod.TamedPhantomsScream
import com.tamedphantomsscream.mod.network.MoonPulsePayload
import com.tamedphantomsscream.mod.network.ScreamNetwork
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking

class TamedPhantomsScreamFabric : ModInitializer {
    override fun onInitialize() {
        FabricScreamSettings.bind()
        PayloadTypeRegistry.playS2C().register(MoonPulsePayload.TYPE, MoonPulsePayload.STREAM_CODEC)
        ScreamNetwork.sendToDimension = { level, payload ->
            for (player in level.players()) {
                ServerPlayNetworking.send(player, payload)
            }
        }
        TamedPhantomsScream.init()
    }
}
