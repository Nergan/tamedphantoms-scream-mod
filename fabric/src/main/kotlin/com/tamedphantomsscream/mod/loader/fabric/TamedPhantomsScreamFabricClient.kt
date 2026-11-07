package com.tamedphantomsscream.mod.loader.fabric

import com.tamedphantomsscream.mod.client.MoonSickness
import com.tamedphantomsscream.mod.network.MoonPulsePayload
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking

class TamedPhantomsScreamFabricClient : ClientModInitializer {
    override fun onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register { MoonSickness.tick() }
        ClientPlayNetworking.registerGlobalReceiver(MoonPulsePayload.TYPE) { _, context ->
            context.client().execute { MoonSickness.trigger() }
        }
    }
}
