package top.hendrixshen.tweakmyclient.mixin.patch.endPortalRendererFix;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.TheEndPortalBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.hendrixshen.tweakmyclient.config.Configs;
import top.hendrixshen.tweakmyclient.helper.EnderPortalRenderMode;

@Mixin(TheEndPortalBlockEntity.class)
public class MixinTheEndPortalBlockEntity {
    @Inject(
            method = "shouldRenderFace",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    private void shouldRenderFace(Direction direction, CallbackInfoReturnable<Boolean> cir) {
        if (Configs.endPortalRendererFix.getBooleanValue()) {
            //#if MC > 11605
            if (Configs.enderPortalRenderMode.getOptionListValue() == EnderPortalRenderMode.LEGACY) {
                cir.setReturnValue(direction == Direction.UP);
            } else if (Configs.enderPortalRenderMode.getOptionListValue() != EnderPortalRenderMode.MODERN) {
            //#else
            //$$ if (Configs.enderPortalRenderMode == EnderPortalRenderMode.MODERN) {
            //$$     cir.setReturnValue(direction.getAxis() == Direction.Axis.Y);
            //$$ } else if (Configs.enderPortalRenderMode != EnderPortalRenderMode.LEGACY) {
            //#endif
                cir.setReturnValue(true);
            }
        }
    }
}
