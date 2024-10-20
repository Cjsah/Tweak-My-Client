package top.hendrixshen.tweakmyclient.mixin.exp.expXiBao;

import fudge.notenoughcrashes.gui.ProblemScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import top.hendrixshen.magiclib.api.dependency.annotation.Dependencies;
import top.hendrixshen.magiclib.api.dependency.annotation.Dependency;
import top.hendrixshen.tweakmyclient.config.Configs;
import top.hendrixshen.tweakmyclient.util.AutoReconnectUtil;

//#if MC > 11502
import com.mojang.blaze3d.vertex.PoseStack;
import org.jetbrains.annotations.NotNull;
//#endif

@Dependencies(require = @Dependency("notenoughcrashes"))
@Mixin(value = ProblemScreen.class)
public abstract class MixinProblemScreen extends Screen {
    protected MixinProblemScreen(Component component) {
        super(component);
    }

    //#if MC < 12000
    //$$ // TODO: 1.20
    //$$ @ModifyArg(
    //$$         method = "addSuspectedModsWidget",
    //$$         at = @At(
    //$$                 value = "INVOKE",
    //$$                 target = "Lfudge/notenoughcrashes/gui/util/TextWidget;<init>(Lnet/minecraft/network/chat/Component;ILnet/minecraft/client/gui/Font;II)V"
    //$$         ),
    //$$         index = 4
    //$$ )
    //$$ private int offsetSuspectedMods(int value) {
    //$$     return Configs.expXiBao ? value + 15 : value;
    //$$ }
    //$$
    //$$ @Override
    //#if MC > 11903
    //$$ public void renderBackground(@NotNull PoseStack poseStack) {
    //#elseif MC > 11502
    //$$ public void renderBackground(@NotNull PoseStack poseStack, int i) {
    //#else
    //$$ public void renderBackground(int i) {
    //#endif
    //$$     if (Configs.expXiBao) {
    //$$         AutoReconnectUtil.renderXibao(this);
    //$$     } else {
            //#if MC > 11903
            //$$ super.renderBackground(poseStack);
            //#elseif MC > 11502
            //$$ super.renderBackground(poseStack, i);
            //#else
            //$$ super.renderBackground(i);
            //#endif
    //$$     }
    //$$ }
    //#endif
}
