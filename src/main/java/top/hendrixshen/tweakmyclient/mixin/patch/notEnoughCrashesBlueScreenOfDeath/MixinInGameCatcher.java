package top.hendrixshen.tweakmyclient.mixin.patch.notEnoughCrashesBlueScreenOfDeath;

import fudge.notenoughcrashes.mixinhandlers.InGameCatcher;
import net.minecraft.CrashReport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.hendrixshen.magiclib.api.dependency.annotation.Dependencies;
import top.hendrixshen.magiclib.api.dependency.annotation.Dependency;
import top.hendrixshen.tweakmyclient.TweakMyClient;
import top.hendrixshen.tweakmyclient.config.Configs;
import top.hendrixshen.tweakmyclient.util.notenoughcrashes.BlueScreen;

//#if MC > 11502
import org.jetbrains.annotations.NotNull;
//#endif

@Dependencies(require = @Dependency("notenoughcrashes"))
@Mixin(InGameCatcher.class)
public class MixinInGameCatcher {
    @Inject(
            method = "displayCrashScreen",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/Minecraft;setScreen(Lnet/minecraft/client/gui/screens/Screen;)V"
            ),
            cancellable = true
    )
    //#if MC > 11502
    private static void replaceScreen(CrashReport report, int crashCount, boolean clientCrash, @NotNull CallbackInfo ci) {
    //#else
    //$$ private static void replaceScreen(CrashReport report, CallbackInfo ci) {
    //#endif
        if (Configs.notEnoughCrashesBlueScreenOfDeath.getBooleanValue()) {
            TweakMyClient.getMinecraftClient().setScreen(new BlueScreen(report));
            ci.cancel();
        }
    }
}
