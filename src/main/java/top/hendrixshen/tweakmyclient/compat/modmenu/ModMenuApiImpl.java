package top.hendrixshen.tweakmyclient.compat.modmenu;

import top.hendrixshen.magiclib.api.compat.modmenu.ModMenuApiCompat;
import top.hendrixshen.tweakmyclient.TweakMyClientConfigGui;
import top.hendrixshen.tweakmyclient.TweakMyClientReference;

public class ModMenuApiImpl implements ModMenuApiCompat {
    @Override
    public ModMenuApiCompat.ConfigScreenFactoryCompat<?> getConfigScreenFactoryCompat() {
        return (screen) -> {
            TweakMyClientConfigGui gui = TweakMyClientConfigGui.getInstance();
            //#if MC > 11903
            gui.setParent(screen);
            //#else
            //$$ gui.setParentGui(screen);
            //#endif
            return gui;
        };
    }

    @Override
    public String getModIdCompat() {
        return TweakMyClientReference.getModIdentifierCurrent();
    }
}