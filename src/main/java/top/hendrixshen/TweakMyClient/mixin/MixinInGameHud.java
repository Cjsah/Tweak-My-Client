package top.hendrixshen.TweakMyClient.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.scoreboard.ScoreboardObjective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.hendrixshen.TweakMyClient.config.Configs;

@Mixin(InGameHud.class)
public abstract class MixinInGameHud {
    @Shadow
    protected abstract void renderPumpkinOverlay();

    @Inject(
            method = "renderScoreboardSidebar",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    private void onRenderScoreboardSidebar(MatrixStack matrices, ScoreboardObjective objective, CallbackInfo ci) {
        if (Configs.Disable.DISABLE_SCOREBOARD_RENDERING.getBooleanValue()) {
            ci.cancel();
        }
    }

    @Redirect(
            method = "renderScoreboardSidebar",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/options/GameOptions;getTextBackgroundColor(F)I",
                    ordinal = 1
            )
    )
    private int changeSidebarTitleBackgroundColor(GameOptions gameOptions, float fallbackOpacity) {
        if (Configs.Feature.FEATURE_CUSTOM_SIDEBAR_BACKGROUND_COLOR.getBooleanValue()) {
            return Configs.Color.COLOR_SIDEBAR_TITLE.getIntegerValue();
        }
        return gameOptions.getTextBackgroundColor(fallbackOpacity);
    }

    @Redirect(
            method = "renderScoreboardSidebar",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/options/GameOptions;getTextBackgroundColor(F)I",
                    ordinal = 0
            )
    )
    private int changeSidebarContentBackgroundColor(GameOptions gameOptions, float fallbackOpacity) {
        if (Configs.Feature.FEATURE_CUSTOM_SIDEBAR_BACKGROUND_COLOR.getBooleanValue()) {
            return Configs.Color.COLOR_SIDEBAR_CONTENT.getIntegerValue();
        }
        return gameOptions.getTextBackgroundColor(fallbackOpacity);
    }

    @Redirect(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;renderPumpkinOverlay()V"
            )
    )
    private void onRenderPumpkinOverlay(InGameHud inGameHud) {
        if (!Configs.Disable.DISABLE_RENDER_OVERLAY_PUMPKIN.getBooleanValue()) {
            renderPumpkinOverlay();
        }
    }
}
