package top.hendrixshen.TweakMyClient.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.SlotActionType;
import top.hendrixshen.TweakMyClient.TweakMyClient;
import top.hendrixshen.TweakMyClient.config.Configs;

import java.util.HashSet;

public class AutoDropUtils {
    public static int waitTime;
    public static HashSet<Item> itemStacksWhitelist;
    public static HashSet<Item> itemStacksBlackList;

    public static void doDrop() {
        MinecraftClient mc = TweakMyClient.getMinecraftClient();
        ClientPlayerInteractionManager interactionManager = mc.interactionManager;
        if (mc.currentScreen instanceof HandledScreen && !(mc.currentScreen instanceof InventoryScreen)) {
            return;
        }

        for (int slot = 9; slot < 45; slot++) {
            int adjustedSlot = slot;
            if (adjustedSlot >= 36)
                adjustedSlot -= 36;
            assert mc.player != null;
            ItemStack stack = mc.player.inventory.getStack(adjustedSlot);

            if (stack.isEmpty())
                continue;

            Configs.AutoDropListType mode = (Configs.AutoDropListType) Configs.List.LIST_AUTO_DROP_TYPE.getOptionListValue();
            switch (mode) {
                case BLACKLIST:
                    if (!itemStacksBlackList.contains(stack.getItem())) {
                        assert interactionManager != null;
                        interactionManager.clickSlot(0, slot, 1, SlotActionType.THROW, TweakMyClient.getMinecraftClient().player);
                    }
                    break;
                case WHITELIST:
                    if (itemStacksWhitelist.contains(stack.getItem())) {
                        assert interactionManager != null;
                        interactionManager.clickSlot(0, slot, 1, SlotActionType.THROW, TweakMyClient.getMinecraftClient().player);
                    }
                    break;
            }
        }
    }
}
