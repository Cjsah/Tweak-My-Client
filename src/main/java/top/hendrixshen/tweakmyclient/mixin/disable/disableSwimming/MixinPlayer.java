package top.hendrixshen.tweakmyclient.mixin.disable.disableSwimming;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.hendrixshen.tweakmyclient.config.Configs;
import top.hendrixshen.tweakmyclient.util.MiscUtil;

@Mixin(Player.class)
public abstract class MixinPlayer {
    @SuppressWarnings("ConstantConditions")
    @Inject(
            method = "isSwimming",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    private void isSwimming(CallbackInfoReturnable<Boolean> cir) {
        if (Configs.disableSwimming.getBooleanValue() && MiscUtil.cast(this) instanceof LocalPlayer) {
            cir.setReturnValue(false);
        }
    }
}
