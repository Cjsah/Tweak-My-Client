package top.hendrixshen.tweakmyclient.mixin.patch.chunkEdgeLagFix;

import org.spongepowered.asm.mixin.Mixin;

//#if MC > 11904
import top.hendrixshen.magiclib.api.preprocess.DummyClass;
//#else
//$$ import net.minecraft.client.multiplayer.ClientPacketListener;
//$$ import org.spongepowered.asm.mixin.injection.At;
//$$ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//$$ import top.hendrixshen.magiclib.api.dependency.annotation.Dependencies;
//$$ import top.hendrixshen.magiclib.api.dependency.annotation.Dependency;
//$$ import top.hendrixshen.tweakmyclient.config.Configs;
//$$
//#if MC > 11701
//$$ import net.minecraft.network.protocol.game.ClientboundForgetLevelChunkPacket;
//$$ import org.spongepowered.asm.mixin.injection.Inject;
//#else
//$$ import net.minecraft.core.SectionPos;
//$$ import net.minecraft.world.level.lighting.LevelLightEngine;
//$$ import org.spongepowered.asm.mixin.injection.Redirect;
//#endif
//#endif

//#if MC > 11904
@Mixin(DummyClass.class)
//#else
//$$ @Dependencies(not = @Dependency(value = "forgetmechunk"))
//$$ @Mixin(ClientPacketListener.class)
//#endif
public class MixinClientPacketListener {
    //#if MC < 12000
    //#if MC > 11701
    //$$ @Inject(
    //$$         method = "handleForgetLevelChunk",
    //$$         at = @At(
    //$$                 value = "INVOKE",
    //$$                 target = "Lnet/minecraft/client/multiplayer/ClientPacketListener;queueLightUpdate(Lnet/minecraft/network/protocol/game/ClientboundForgetLevelChunkPacket;)V"
    //$$         ),
    //$$         cancellable = true
    //$$ )
    //$$ private void chunkEdgeLagFix(ClientboundForgetLevelChunkPacket clientboundForgetLevelChunkPacket, CallbackInfo ci) {
    //$$     if (Configs.chunkEdgeLagFix) {
    //$$         ci.cancel();
    //$$     }
    //$$ }
    //#else
    //$$ @Redirect(
    //$$         method = "handleForgetLevelChunk",
    //$$         at = @At(
    //$$                 value = "INVOKE",
    //$$                 target = "Lnet/minecraft/world/level/lighting/LevelLightEngine;updateSectionStatus(Lnet/minecraft/core/SectionPos;Z)V"
    //$$         )
    //$$ )
    //$$ private void chunkEdgeLagFix(LevelLightEngine instance, SectionPos sectionPos, boolean bl) {
    //$$     if (!Configs.chunkEdgeLagFix) {
    //$$          instance.updateSectionStatus(sectionPos, bl);
    //$$     }
    //$$ }
    //#endif
    //#endif
}
