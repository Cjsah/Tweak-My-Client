package top.hendrixshen.tweakmyclient.util.render;

import lombok.Getter;
//#if MC > 11502
import com.mojang.blaze3d.systems.RenderSystem;
import fi.dy.masa.malilib.util.Color4f;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.projectile.FishingHook;
import org.lwjgl.opengl.GL11;
import top.hendrixshen.tweakmyclient.TweakMyClient;
import top.hendrixshen.tweakmyclient.config.Configs;
import top.hendrixshen.tweakmyclient.helper.AreaBox;
import top.hendrixshen.tweakmyclient.mixin.accessor.FishingHookAccessor;
//#endif

public class OpenWaterHelperRenderer implements IRenderer {
    @Getter(lazy = true)
    private static final OpenWaterHelperRenderer instance = new OpenWaterHelperRenderer();

    @Override
    public void render() {
        //#if MC > 11502
        assert TweakMyClient.getMinecraftClient().player != null;
        FishingHook fishHook = TweakMyClient.getMinecraftClient().player.fishing;
        assert fishHook != null;
        BlockPos fishHookPos = fishHook.blockPosition();
        Color4f color = ((FishingHookAccessor) fishHook).invokeCalculateOpenWater(fishHook.blockPosition()) ? Configs.colorWaterOpen.getColor() : Configs.colorWaterShallow.getColor();
        AreaBox areaBox = new AreaBox(fishHookPos.getX() - 2, fishHookPos.getY() - 3, fishHookPos.getZ() - 2,
                fishHookPos.getX() + 2, fishHookPos.getY(), fishHookPos.getZ() + 2);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        RenderSystem.disableDepthTest();
        RenderUtil.renderAreaOutline(areaBox, color);
        RenderSystem.enableDepthTest();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        //#endif
    }

    @Override
    public boolean shouldRender() {
        //#if MC > 11502
        return Configs.featureOpenWaterHelper.getBooleanValue() && TweakMyClient.getMinecraftClient().player != null &&
                TweakMyClient.getMinecraftClient().player.fishing != null;
        //#else
        //$$ return false;
        //#endif
    }
}
