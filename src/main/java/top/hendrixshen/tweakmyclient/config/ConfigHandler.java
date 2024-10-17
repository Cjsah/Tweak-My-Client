package top.hendrixshen.tweakmyclient.config;

import fi.dy.masa.malilib.config.ConfigManager;
import top.hendrixshen.magiclib.impl.malilib.config.MagicConfigHandler;
import top.hendrixshen.tweakmyclient.helper.Cache;

public class ConfigHandler extends MagicConfigHandler {
    public ConfigHandler(String modId, ConfigManager configManager, int configVersion) {
        super(modId, configManager, configVersion);
    }

    @Override
    public void load() {
        super.load();
        Cache.getInstance().rebuildAllCache();
    }
}
