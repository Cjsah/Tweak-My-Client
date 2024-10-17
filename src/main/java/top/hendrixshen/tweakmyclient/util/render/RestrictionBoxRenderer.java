package top.hendrixshen.tweakmyclient.util.render;

import com.mojang.blaze3d.systems.RenderSystem;
import lombok.Getter;
import org.lwjgl.opengl.GL11;
import top.hendrixshen.tweakmyclient.TweakMyClient;
import top.hendrixshen.tweakmyclient.config.Configs;
import top.hendrixshen.tweakmyclient.helper.AreaBox;
import top.hendrixshen.tweakmyclient.helper.BreakingRestrictionBoxType;
import top.hendrixshen.tweakmyclient.helper.Cache;

public class RestrictionBoxRenderer implements IRenderer {
    @Getter(lazy = true)
    private static final RestrictionBoxRenderer instance = new RestrictionBoxRenderer();

    @Override
    public void render() {
        switch (Configs.listBreakingRestrictionBoxType.getOptionListValue()) {
            case BreakingRestrictionBoxType.BLACKLIST:
                for (AreaBox areaBox : Cache.getInstance().getBreakingRestrictionBoxBlacklist()) {
                    GL11.glEnable(GL11.GL_LINE_SMOOTH);
                    GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
                    GL11.glPolygonOffset(-1.0F, -1.0F);
                    RenderSystem.disableDepthTest();
                    RenderUtil.renderAreaOutline(areaBox, Cache.getInstance().getBreakingRestrictionBoxBlacklistModeOutlineColor());
                    RenderSystem.enableDepthTest();
                    RenderUtil.renderAreaOverlay(areaBox, Configs.colorBreakingRestrictionBoxBlacklistMode.getColor());
                    GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL);
                    GL11.glDisable(GL11.GL_LINE_SMOOTH);
                }
                break;
            case BreakingRestrictionBoxType.WHITELIST:
                for (AreaBox areaBox : Cache.getInstance().getBreakingRestrictionBoxWhiteList()) {
                    GL11.glEnable(GL11.GL_LINE_SMOOTH);
                    GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
                    GL11.glPolygonOffset(-1.0F, -1.0F);
                    RenderSystem.disableDepthTest();
                    RenderUtil.renderAreaOutline(areaBox, Cache.getInstance().getBreakingRestrictionBoxWhitelistModeOutlineColor());
                    RenderSystem.enableDepthTest();
                    RenderUtil.renderAreaOverlay(areaBox, Configs.colorBreakingRestrictionBoxWhitelistMode.getColor());
                    GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL);
                    GL11.glDisable(GL11.GL_LINE_SMOOTH);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean shouldRender() {
        return Configs.featureBreakingRestrictionBox.getBooleanValue() && TweakMyClient.getMinecraftClient().level != null;
    }
}
