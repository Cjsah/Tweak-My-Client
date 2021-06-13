package top.hendrixshen.TweakMyClient.config;

import fi.dy.masa.malilib.config.options.ConfigColor;
import fi.dy.masa.malilib.util.StringUtils;

public class TranslatableConfigColor extends ConfigColor {
    private final String guiDisplayName;

    public TranslatableConfigColor(String prefix, String name, String defaultValue) {
        super(name, defaultValue, String.format("%s.%s.comment", prefix, name));
        this.guiDisplayName = String.format("%s.%s.name", prefix, name);
    }

    @Override
    public String getConfigGuiDisplayName() {
        return StringUtils.translate(this.guiDisplayName);
    }
}
