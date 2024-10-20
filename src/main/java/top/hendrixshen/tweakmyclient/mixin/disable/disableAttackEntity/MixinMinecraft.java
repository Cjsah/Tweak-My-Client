package top.hendrixshen.tweakmyclient.mixin.disable.disableAttackEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import top.hendrixshen.tweakmyclient.config.Configs;

//#if MC > 11701
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//#else
//$$ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//#endif

//#if MC > 11902
import net.minecraft.core.registries.BuiltInRegistries;
//#else
//$$ import net.minecraft.core.Registry;
//#endif

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Shadow
    @Nullable
    public HitResult hitResult;

    @Shadow
    @Nullable
    public LocalPlayer player;

    @Inject(
            method = "startAttack",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/multiplayer/MultiPlayerGameMode;attack(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/entity/Entity;)V"
            ),
            cancellable = true
    )
    //#if MC > 11701
    private void onStartAttack(CallbackInfoReturnable<Boolean> cir) {
    //#else
    //$$ private void onStartAttack(CallbackInfo ci) {
    //#endif
        if (this.hitResult != null && this.player != null) {
            Entity entity = ((EntityHitResult) hitResult).getEntity();
            //#if MC > 11902
            String entityID = BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString();
            //#else
            //$$ String entityID = Registry.ENTITY_TYPE.getKey(entity.getType()).toString();
            //#endif
            String entityName = entity.getName().getString();

            if (Configs.disableAttackEntity.getBooleanValue() && Configs.listDisableAttackEntity.getStrings().stream().anyMatch(s -> entityID.contains(s) || entityName.contains(s))) {
                player.swing(InteractionHand.MAIN_HAND);
                //#if MC > 11701
                cir.setReturnValue(false);
                //#else
                //$$ ci.cancel();
                //#endif
            }
        }
    }
}
