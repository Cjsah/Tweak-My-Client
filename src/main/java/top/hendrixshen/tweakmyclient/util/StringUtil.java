package top.hendrixshen.tweakmyclient.util;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.commands.arguments.item.ItemParser;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.hendrixshen.tweakmyclient.TweakMyClientReference;
import top.hendrixshen.tweakmyclient.helper.AreaBox;

import java.util.HashSet;
import java.util.List;

//#if MC > 11902
import net.minecraft.core.registries.BuiltInRegistries;
//#elseif MC > 11802
//$$ import net.minecraft.core.HolderLookup;
//$$ import net.minecraft.core.Registry;
//#endif

public class StringUtil extends top.hendrixshen.magiclib.util.StringUtil {
    public static @NotNull HashSet<Item> getItemStackSets(@NotNull List<String> items) {
        HashSet<Item> itemStackSet = new HashSet<>();

        for (String str : items) {
            ItemStack stack = StringUtil.toItemStack(str);

            if (!stack.isEmpty()) {
                itemStackSet.add(stack.getItem());
            }
        }

        return itemStackSet;
    }

    public static ItemStack toItemStack(String string) {
        try {
            //#if MC > 11902
            ItemParser.ItemResult result = ItemParser.parseForItem(BuiltInRegistries.ITEM.asLookup(), new StringReader(string));
            Item item = result.item().value();
            //#elseif MC > 11802
            //$$ ItemParser.ItemResult result = ItemParser.parseForItem(new HolderLookup.RegistryLookup<>(Registry.ITEM), new StringReader(string));
            //$$ Item item = result.item().value();
            //#else
            //$$ ItemParser reader = new ItemParser(new StringReader(string), true);
            //$$ reader.parse();
            //$$ Item item = reader.getItem();
            //#endif

            if (item != null) {
                ItemStack stack = new ItemStack(item);
                //#if MC >= 11900
                stack.setTag(result.nbt());
                //#else
                //$$ stack.setTag(reader.getNbt());
                //#endif
                return stack;
            }
        } catch (CommandSyntaxException e) {
            TweakMyClientReference.getLogger().error("Invalid item '{}'", string);
        }

        return ItemStack.EMPTY;
    }

    public static @NotNull HashSet<AreaBox> getAreaBoxSets(@NotNull List<String> poses) {
        HashSet<AreaBox> areaBoxes = new HashSet<>();

        for (String str : poses) {
            AreaBox areaBox = StringUtil.toAreaBox(str);

            if (areaBox != null) {
                areaBoxes.add(areaBox);
            }
        }

        return areaBoxes;
    }

    @Nullable
    public static AreaBox toAreaBox(@NotNull String string) {
        String[] split = string.split(" ");

        if (split.length == 6) {
            try {
                return new AreaBox(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]),
                        Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]));
            } catch (NumberFormatException e) {
                TweakMyClientReference.getLogger().debug("Invalid area '{}'", string);
            }
        }

        return null;
    }

    public static String tr(String node) {
        return I18n.get(String.format("%s.%s", TweakMyClientReference.getModIdentifier(), node));
    }

    public static String tr(String node, Object... obj) {
        return I18n.get(String.format("%s.%s", TweakMyClientReference.getModIdentifier(), node), obj);
    }
}
