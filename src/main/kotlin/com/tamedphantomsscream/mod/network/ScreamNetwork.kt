package com.tamedphantomsscream.mod.network

import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.minecraft.server.level.ServerLevel

object ScreamNetwork {
    var sendToDimension: (ServerLevel, CustomPacketPayload) -> Unit = { _, _ -> }

    fun moon(level: ServerLevel) {
        sendToDimension(level, MoonPulsePayload)
    }
}
