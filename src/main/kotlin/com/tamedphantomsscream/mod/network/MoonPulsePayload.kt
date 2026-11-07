package com.tamedphantomsscream.mod.network

import com.tamedphantomsscream.mod.TamedPhantomsScream
import net.minecraft.network.RegistryFriendlyByteBuf
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.minecraft.resources.ResourceLocation

/** Полнолунный крик: на секунду луна и туман становятся болезненно жёлтыми. */
object MoonPulsePayload : CustomPacketPayload {
    override fun type(): CustomPacketPayload.Type<MoonPulsePayload> = TYPE

    val ID: ResourceLocation = ResourceLocation.fromNamespaceAndPath(TamedPhantomsScream.MOD_ID, "moon_pulse")
    val TYPE: CustomPacketPayload.Type<MoonPulsePayload> = CustomPacketPayload.Type(ID)
    val STREAM_CODEC: StreamCodec<RegistryFriendlyByteBuf, MoonPulsePayload> = StreamCodec.unit(MoonPulsePayload)
}
