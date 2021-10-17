package top.hendrixshen.TweakMyClient;

import fi.dy.masa.malilib.config.ConfigManager;
import fi.dy.masa.malilib.event.InputEventHandler;
import fi.dy.masa.malilib.event.RenderEventHandler;
import fi.dy.masa.malilib.interfaces.IRenderer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.hendrixshen.TweakMyClient.config.Configs;
import top.hendrixshen.TweakMyClient.event.InputHandler;
import top.hendrixshen.TweakMyClient.event.RenderHandler;

public class TweakMyClient implements ModInitializer {
    private static final Logger logger = LogManager.getLogger(TweakMyClientReference.getModId());
    private static final MinecraftClient minecraftClient = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
        ConfigManager.getInstance().registerConfigHandler(TweakMyClientReference.getModId(), new Configs());
        InputEventHandler.getKeybindManager().registerKeybindProvider(InputHandler.getInstance());

        IRenderer renderer = new RenderHandler();
        RenderEventHandler.getInstance().registerWorldLastRenderer(renderer);
        String modName = TweakMyClientReference.getModName();
        logger.info(String.format("[%s]: Mod initialized - Version: %s (%s)", modName, TweakMyClientReference.getModVersion(), TweakMyClientReference.getModVersionType()));
        logger.info(String.format("[%s]: AuthMe was %sdetectect.", modName, (TweakMyClientMixinPlugin.isAuthMeLoaded ? "" : "not ")));
        logger.info(String.format("[%s]: InGameAccountSwitcher was %sdetectect.", modName, (TweakMyClientMixinPlugin.isInGameAccountSwitcherLoaded ? "" : "not ")));
        logger.info(String.format("[%s]: Litematica was %sdetectect.", modName, (TweakMyClientMixinPlugin.isLitematicaLoaded ? "" : "not ")));
        logger.info(String.format("[%s]: ReAuth was %sdetectect.", modName, (TweakMyClientMixinPlugin.isReAuthLoaded ? "" : "not ")));
    }

    public static MinecraftClient getMinecraftClient() {
        return minecraftClient;
    }

    public static Logger getLogger() {
        return logger;
    }
}
