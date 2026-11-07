package com.tamedphantomsscream.mod.loader.fabric.mixin;

import com.tamedphantomsscream.mod.client.MoonSickness;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
public abstract class PhantomFogMixin {
    @Shadow private static float fogRed;
    @Shadow private static float fogGreen;
    @Shadow private static float fogBlue;

    @Inject(method = "setupColor", at = @At("RETURN"))
    private static void tamedphantomsscream$fog(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, CallbackInfo ci) {
        MoonSickness.FogTint tint = MoonSickness.INSTANCE.tint(fogRed, fogGreen, fogBlue);
        if (tint == null) return;
        fogRed = tint.getRed();
        fogGreen = tint.getGreen();
        fogBlue = tint.getBlue();
    }
}
