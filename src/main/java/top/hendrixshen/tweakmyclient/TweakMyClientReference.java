package top.hendrixshen.tweakmyclient;

import lombok.Getter;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.hendrixshen.magiclib.api.malilib.config.MagicConfigManager;
import top.hendrixshen.magiclib.impl.malilib.config.GlobalConfigManager;
import top.hendrixshen.magiclib.impl.malilib.config.MagicConfigHandler;
import top.hendrixshen.magiclib.util.VersionUtil;

public class TweakMyClientReference {
    @Getter
    private static final String modIdentifier = "@MOD_IDENTIFIER@";
    @Getter
    private static final String modIdentifierCurrent = "@MOD_IDENTIFIER@-@MINECRAFT_VERSION_IDENTIFY@";
    @Getter
    private static final String modName = "@MOD_NAME@";
    @Getter
    private static final String modNameCurrent = FabricLoader.getInstance().getModContainer(modIdentifierCurrent).orElseThrow(RuntimeException::new).getMetadata().getName();
    @Getter
    private static final String modVersion = FabricLoader.getInstance().getModContainer(modIdentifierCurrent).orElseThrow(RuntimeException::new).getMetadata().getVersion().getFriendlyString();
    @Getter
    private static final String modVersionType = VersionUtil.getVersionType(modVersion);
    @Getter
    private static final Logger logger = LogManager.getLogger(TweakMyClientReference.getModIdentifier());

    private static final int configVersion = 1;
    @Getter
    private static final MagicConfigManager configManager = GlobalConfigManager.getConfigManager(modIdentifier);
    @Getter
    private static final MagicConfigHandler configHandler = new MagicConfigHandler(configManager, configVersion);

    public static boolean isAuthMeLoaded = FabricUtil.isModLoaded("authme");
    public static boolean isHwylaLoaded = FabricUtil.isModLoaded("waila");
    public static boolean isInGameAccountSwitcherLoaded = FabricUtil.isModLoaded("ias");
    public static boolean isJadeLoaded = FabricUtil.isModLoaded("jade");
    public static boolean isOAuthLoaded = FabricUtil.isModLoaded("oauth-fabric");
    public static boolean isReAuthLoaded = FabricUtil.isModLoaded("reauth");
    public static boolean isWthitLoaded = FabricUtil.isModLoaded("wthit");
}
