package top.hendrixshen.tweakmyclient.config;

import com.google.common.collect.ImmutableList;
import top.hendrixshen.magiclib.api.dependency.annotation.Dependencies;
import top.hendrixshen.magiclib.api.dependency.annotation.Dependency;
import top.hendrixshen.magiclib.api.malilib.annotation.Config;
import top.hendrixshen.magiclib.api.malilib.annotation.Statistic;
import top.hendrixshen.magiclib.api.malilib.config.MagicConfigManager;
import top.hendrixshen.magiclib.impl.malilib.config.MagicConfigFactory;
import top.hendrixshen.magiclib.impl.malilib.config.option.MagicConfigBoolean;
import top.hendrixshen.magiclib.impl.malilib.config.option.MagicConfigColor;
import top.hendrixshen.magiclib.impl.malilib.config.option.MagicConfigDouble;
import top.hendrixshen.magiclib.impl.malilib.config.option.MagicConfigHotkey;
import top.hendrixshen.magiclib.impl.malilib.config.option.MagicConfigInteger;
import top.hendrixshen.magiclib.impl.malilib.config.option.MagicConfigOptionList;
import top.hendrixshen.magiclib.impl.malilib.config.option.MagicConfigString;
import top.hendrixshen.magiclib.impl.malilib.config.option.MagicConfigStringList;
import top.hendrixshen.tweakmyclient.TweakMyClientReference;
import top.hendrixshen.tweakmyclient.event.CallBacks;
import top.hendrixshen.tweakmyclient.helper.*;
import top.hendrixshen.tweakmyclient.util.IconUtil;

public class Configs {
    private static final MagicConfigManager cm = TweakMyClientReference.getConfigManager();
    private static final MagicConfigFactory cf = Configs.cm.getConfigFactory();

    // Generic configs
    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigInteger autoDropInterval = cf.newConfigInteger("autoDropInterval", 0, 0, 1200);


    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigInteger autoReconnectTimer = cf.newConfigInteger("autoReconnectTimer", 5, 0, 60);

    @Config(category = ConfigCategory.GENERIC/*, predicate = TweakMyClientPredicate.AllowBreakAnimation.class*/)
    public static MagicConfigOptionList breakAnimationMode = cf.newConfigOptionList("breakAnimationMode", BreakAnimationMode.NONE);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigOptionList crystalBeamsDisableMode = cf.newConfigOptionList("crystalBeamsDisableMode", CrystalBeamsDisableMode.ALL);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigBoolean customBlockHitBoxOverlayDisableDepthTest = cf.newConfigBoolean("customBlockHitBoxOverlayDisableDepthTest", false);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigBoolean customBlockHitBoxOverlayFillRainbow = cf.newConfigBoolean("customBlockHitBoxOverlayFillRainbow", false);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigInteger customBlockHitBoxOverlayFillRainbowSpeed = cf.newConfigInteger("customBlockHitBoxOverlayFillRainbowSpeed", 80, 1, 100);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigBoolean customBlockHitBoxOverlayLinkedAdapter = cf.newConfigBoolean("customBlockHitBoxOverlayLinkedAdapter", true);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigBoolean customBlockHitBoxOverlayOutlineRainbow = cf.newConfigBoolean("customBlockHitBoxOverlayOutlineRainbow", false);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigInteger customBlockHitBoxOverlayOutlineRainbowSpeed = cf.newConfigInteger("customBlockHitBoxOverlayOutlineRainbowSpeed", 80, 1, 100);

    @Config(category = ConfigCategory.GENERIC)
    @Dependencies(conflict = @Dependency(value = "minecraft", versionPredicates = "<1.15"))
    public static MagicConfigBoolean customWindowTitleEnableActivity = cf.newConfigBoolean("customWindowTitleEnableActivity", true);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigBoolean customWindowTitleRandomly = cf.newConfigBoolean("customWindowTitleRandomly", false);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigInteger daylightOverrideTime = cf.newConfigInteger("daylightOverrideTime", 6000, 0, 24000);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigOptionList enderPortalRenderMode = cf.newConfigOptionList("enderPortalRenderMode", EnderPortalRenderMode.ACTUAL);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigHotkey getTargetBlockPosition = cf.newConfigHotkey("getTargetBlockPosition");

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigDouble lowHealthThreshold = cf.newConfigDouble("lowHealthThreshold", 6, 0, 1000);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigHotkey memoryCleaner = cf.newConfigHotkey("memoryCleaner");

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigHotkey openConfigGui = cf.newConfigHotkey("openConfigGui", "T,C");

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigHotkey syncInventory = cf.newConfigHotkey("syncInventory");

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigHotkey syncBlocks = cf.newConfigHotkey("syncBlocks");

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigInteger targetBlockMaxTraceDistance = cf.newConfigInteger("targetBlockMaxTraceDistance", 100, 0, 200);

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigString targetBlockPositionFormat = cf.newConfigString("targetBlockPositionFormat", "I'm looking at [x: {X}, y: {Y}, z: {Z}]");

    @Config(category = ConfigCategory.GENERIC)
    public static MagicConfigOptionList targetBlockPositionPrintMode = cf.newConfigOptionList("targetBlockPositionPrintMode", TargetBlockPositionPrintMode.PRIVATE);

    // Patch configs
    @Config(category = ConfigCategory.PATCH)
    @Dependencies(conflict = {
            @Dependency(value = "forgetmechunk"),
            @Dependency(value = "minecraft", versionPredicates = ">1.19.4")
    })
    public static MagicConfigBoolean chunkEdgeLagFix = cf.newConfigBoolean("chunkEdgeLagFix", false);

    @Config(category = ConfigCategory.PATCH)
    @Dependencies(require = @Dependency(value = "litematica"), conflict = @Dependency(value = "masa_gadget_mod", versionPredicates = ">=2.0.6"))
    public static MagicConfigBoolean disableLitematicaEasyPlaceFailTip = cf.newConfigBoolean("disableLitematicaEasyPlaceFailTip", false);

    @Config(category = ConfigCategory.PATCH)
    @Dependencies(require = @Dependency(value = "litematica"))
    public static MagicConfigBoolean disableLitematicaSchematicVersionCheck = cf.newConfigBoolean("disableLitematicaSchematicVersionCheck", false);

    @Config(category = ConfigCategory.PATCH)
    public static MagicConfigBoolean disableResourcePackIncompatibleTip = cf.newConfigBoolean("disableResourcePackIncompatibleTip", false);

    @Config(category = ConfigCategory.PATCH)
    public static MagicConfigBoolean endPortalRendererFix = cf.newConfigBoolean("endPortalRendererFix", false);

    @Config(category = ConfigCategory.PATCH)
    public static MagicConfigBoolean forceDebugInfoDetailed = cf.newConfigBoolean("forceDebugInfoDetailed", false);

    @Config(category = ConfigCategory.PATCH)
    @Dependencies(require = @Dependency(value = "minecraft", versionPredicates = ">=1.16"))
    public static MagicConfigBoolean forcePistonWithoutAffectByTool = cf.newConfigBoolean("forcePistonWithoutAffectByTool", false);

    @Config(category = ConfigCategory.PATCH)
    @Dependencies(require = {
            @Dependency(value = "carpet", versionPredicates = ">1.4.113"),
            @Dependency(value = "minecraft", versionPredicates = ">1.20.1")
    })
    public static MagicConfigBoolean legacyCarpetHandshake = cf.newConfigBoolean("legacyCarpetHandshake", false);

    @Config(category = ConfigCategory.PATCH)
    @Dependencies(require = @Dependency("notenoughcrashes"))
    public static MagicConfigBoolean notEnoughCrashesBlueScreenOfDeath = cf.newConfigBoolean("notEnoughCrashesBlueScreenOfDeath", false);

    // List configs
    @Config(category = ConfigCategory.LIST)
    public static MagicConfigStringList listAutoDropBlackList = cf.newConfigStringList("listAutoDropBlackList", ImmutableList.of("minecraft:bow", "minecraft:crossbow", "minecraft:diamond_axe", "minecraft:diamond_boots", "minecraft:diamond_chestplate", "minecraft:diamond_helmet", "minecraft:diamond_hoe", "minecraft:diamond_leggings", "minecraft:diamond_pickaxe", "minecraft:diamond_shovel", "minecraft:diamond_sword", "minecraft:elytra", "minecraft:enchanted_golden_apple", "minecraft:flint_and_steel", "minecraft:fishing_rod", "minecraft:golden_apple", "minecraft:golden_axe", "minecraft:golden_boots", "minecraft:golden_chestplate", "minecraft:golden_helmet", "minecraft:golden_hoe", "minecraft:golden_leggings", "minecraft:golden_pickaxe", "minecraft:golden_shovel", "minecraft:golden_sword", "minecraft:iron_axe", "minecraft:iron_boots", "minecraft:iron_chestplate", "minecraft:iron_helmet", "minecraft:iron_hoe", "minecraft:iron_leggings", "minecraft:iron_pickaxe", "minecraft:iron_shovel", "minecraft:iron_sword", "minecraft:netherite_axe", "minecraft:netherite_boots", "minecraft:netherite_chestplate", "minecraft:netherite_helmet", "minecraft:netherite_hoe", "minecraft:netherite_leggings", "minecraft:netherite_pickaxe", "minecraft:netherite_shovel", "minecraft:netherite_sword", "minecraft:shears", "minecraft:shield", "minecraft:totem_of_undying", "minecraft:trident", "minecraft:turtle_helmet"));

    @Config(category = ConfigCategory.LIST)
    public static AutoDropListType listAutoDropType = AutoDropListType.WHITELIST;

    @Config(category = ConfigCategory.LIST)
    public static MagicConfigStringList listAutoDropWhiteList = cf.newConfigStringList("listAutoDropWhiteList", ImmutableList.of("minecraft:stone", "minecraft:dirt", "minecraft:cobblestone", "minecraft:gravel", "minecraft:rotten_flesh"));

    @Config(category = ConfigCategory.LIST)
    public static MagicConfigStringList listBreakingRestrictionBoxBlacklist = cf.newConfigStringList("listBreakingRestrictionBoxBlacklist", ImmutableList.of("-1 -1 -1 1 1 1"));

    @Config(category = ConfigCategory.LIST)
    public static MagicConfigOptionList listBreakingRestrictionBoxType = cf.newConfigOptionList("listBreakingRestrictionBoxType", BreakingRestrictionBoxType.WHITELIST);

    @Config(category = ConfigCategory.LIST)
    public static MagicConfigStringList listBreakingRestrictionBoxWhitelist = cf.newConfigStringList("listBreakingRestrictionBoxWhitelist", ImmutableList.of("-1 -1 -1 1 1 1"));

    @Config(category = ConfigCategory.LIST)
    public static MagicConfigStringList listCustomWindowTitle = cf.newConfigStringList("listCustomWindowTitle", ImmutableList.of("Minecraft {mc_version} with TweakMyClient {tmc_version} | Player {mc_username} | FPS: {mc_fps}"));

    @Config(category = ConfigCategory.LIST)
    @Dependencies(conflict = @Dependency(value = "minecraft", versionPredicates = "<1.15")/*, predicate = TweakMyClientPredicate.CustomWindowTitleEnableActivity.class*/)
    public static MagicConfigStringList listCustomWindowTitleWithActivity = cf.newConfigStringList("listCustomWindowTitleWithActivity", ImmutableList.of("Minecraft {mc_version} ({mc_activity}) with TweakMyClient {tmc_version} | Player {mc_username} | FPS: {mc_fps}"));

    @Config(category = ConfigCategory.LIST)
    public static MagicConfigStringList listDisableAttackEntity = cf.newConfigStringList("listDisableAttackEntity", ImmutableList.of("player"));

    @Config(category = ConfigCategory.LIST)
    public static MagicConfigStringList listDisableClientEntityUpdates = cf.newConfigStringList("listDisableClientEntityUpdates", ImmutableList.of("zombi"));

    @Config(category = ConfigCategory.LIST)
    public static MagicConfigStringList listDisableClientEntityRendering = cf.newConfigStringList("listDisableClientEntityRendering", ImmutableList.of("zombi"));

    @Config(category = ConfigCategory.LIST)
    public static MagicConfigStringList listItemGlowingBlacklist = cf.newConfigStringList("listItemGlowingBlacklist", ImmutableList.of("minecraft:enchanted_book", "potion"));

    // Color configs
    @Config(category = ConfigCategory.COLOR)
    public static MagicConfigColor colorBlockHitBoxOverlayOutline = cf.newConfigColor("colorBlockHitBoxOverlayOutline", "66000000");

    @Config(category = ConfigCategory.COLOR)
    public static MagicConfigColor colorBlockHitBoxOverlayFill = cf.newConfigColor("colorBlockHitBoxOverlayFill", "#2CFFFF10");

    @Config(category = ConfigCategory.COLOR)
    public static MagicConfigColor colorBreakingRestrictionBoxBlacklistMode = cf.newConfigColor("colorBreakingRestrictionBoxBlacklistMode", "#7FFF0000");

    @Config(category = ConfigCategory.COLOR)
    public static MagicConfigColor colorBreakingRestrictionBoxWhitelistMode = cf.newConfigColor("colorBreakingRestrictionBoxWhitelistMode", "#7F00FF00");

    @Config(category = ConfigCategory.COLOR)
    public static MagicConfigColor colorGuiStart = cf.newConfigColor("colorGuiStart", "#C00F0F0F");

    @Config(category = ConfigCategory.COLOR)
    public static MagicConfigColor colorGuiStop = cf.newConfigColor("colorGuiStop", "#D00F0F0F");

    @Config(category = ConfigCategory.COLOR)
    public static MagicConfigColor colorSidebarContent = cf.newConfigColor("colorSidebarContent", "#4C000000");

    @Config(category = ConfigCategory.COLOR)
    public static MagicConfigColor colorSidebarTitle = cf.newConfigColor("colorSidebarTitle", "#66000000");

    @Config(category = ConfigCategory.COLOR)
    @Dependencies(require = @Dependency(value = "minecraft", versionPredicates = ">=1.16"))
    public static MagicConfigColor colorWaterOpen = cf.newConfigColor("colorWaterOpen", "#7F00FF00");

    @Config(category = ConfigCategory.COLOR)
    @Dependencies(require = @Dependency(value = "minecraft", versionPredicates = ">=1.16"))
    public static MagicConfigColor colorWaterShallow = cf.newConfigColor("colorWaterShallow", "#7FFF0000");

    // Feature configs
    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureAutoClimb = cf.newConfigBoolean("featureAutoClimb", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureAutoDrop = cf.newConfigBoolean("featureAutoDrop", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureAutoReconnect = cf.newConfigBoolean("featureAutoReconnect", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureAutoRespawn = cf.newConfigBoolean("featureAutoRespawn", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureAutoTotem = cf.newConfigBoolean("featureAutoTotem", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureBreakingRestrictionBox = cf.newConfigBoolean("featureBreakingRestrictionBox", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureCustomBlockHitBoxOverlayFill = cf.newConfigBoolean("featureCustomBlockHitBoxOverlayFill", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureCustomBlockHitBoxOverlayOutline = cf.newConfigBoolean("featureCustomBlockHitBoxOverlayOutline", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureCustomGuiBackgroundColor = cf.newConfigBoolean("featureCustomGuiBackgroundColor", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureCustomSidebarBackgroundColor = cf.newConfigBoolean("featureCustomSidebarBackgroundColor", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureCustomWindowIcon = cf.newConfigBoolean("featureCustomWindowIcon", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureCustomWindowTitle = cf.newConfigBoolean("featureCustomWindowTitle", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureDaylightOverride = cf.newConfigBoolean("featureDaylightOverride", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureGlobalEventListener = cf.newConfigBoolean("featureGlobalEventListener", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureLowHealthWarning = cf.newConfigBoolean("featureLowHealthWarning", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    @Dependencies(require = @Dependency(value = "minecraft", versionPredicates = ">=1.16"))
    public static MagicConfigBoolean featureOpenWaterHelper = cf.newConfigBoolean("featureOpenWaterHelper", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.FEATURE)
    public static MagicConfigBoolean featureUnfocusedCPU = cf.newConfigBoolean("featureUnfocusedCPU", false);

    // Disable configs
    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableAttackEntity = cf.newConfigBoolean("disableAttackEntity", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableClientBlockEvents = cf.newConfigBoolean("disableClientBlockEvents", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableClientEntityInListUpdates = cf.newConfigBoolean("disableClientEntityInListUpdates", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableClientEntityTNTUpdates = cf.newConfigBoolean("disableClientEntityTNTUpdates", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableClientEntityWitherUpdates = cf.newConfigBoolean("disableClientEntityWitherUpdates", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableClientEntityZombieVillagerUpdates = cf.newConfigBoolean("disableClientEntityZombieVillagerUpdates", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableClientEntityInListRendering = cf.newConfigBoolean("disableClientEntityInListRendering", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableClientEntityTNTRendering = cf.newConfigBoolean("disableClientEntityTNTRendering", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableClientEntityWitherRendering = cf.newConfigBoolean("disableClientEntityWitherRendering", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableClientEntityZombieVillagerRendering = cf.newConfigBoolean("disableClientEntityZombieVillagerRendering", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableCrystalBeams = cf.newConfigBoolean("disableCrystalBeams", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableFovAffectedBySpeed = cf.newConfigBoolean("disableFovAffectedBySpeed", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableGuiShadowLayer = cf.newConfigBoolean("disableGuiShadowLayer", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableItemGlowing = cf.newConfigBoolean("disableItemGlowing", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableRenderBossBar = cf.newConfigBoolean("disableRenderBossBar", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableRenderEffectBox = cf.newConfigBoolean("disableRenderEffectBox", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableRenderOverlayFire = cf.newConfigBoolean("disableRenderOverlayFire", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    @Dependencies(require = @Dependency(value = "minecraft", versionPredicates = ">=1.17"))
    public static MagicConfigBoolean disableRenderOverlayPowderSnow = cf.newConfigBoolean("disableRenderOverlayPowderSnow", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableRenderOverlayPumpkin = cf.newConfigBoolean("disableRenderOverlayPumpkin", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableRenderScoreboard = cf.newConfigBoolean("disableRenderScoreboard", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableRenderToast = cf.newConfigBoolean("disableRenderToast", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableSlowdown = cf.newConfigBoolean("disableSlowdown", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DISABLE)
    public static MagicConfigBoolean disableSwimming = cf.newConfigBoolean("disableSwimming", false);

    // Debug config
    @Config(category = ConfigCategory.DEBUG)
    public static MagicConfigBoolean debugMode = cf.newConfigBoolean("debugMode", false);

    @Config(category = ConfigCategory.DEBUG/*, predicate = TweakMyClientPredicate.DebugMode.class*/)
    public static MagicConfigBoolean debugExperimentalMode = cf.newConfigBoolean("debugExperimentalMode", false);

    @Config(category = ConfigCategory.DEBUG/*, predicate = TweakMyClientPredicate.ExperimentalMode.class*/)
    @Dependencies(require = @Dependency(value = "minecraft", versionPredicates = ">=1.17"))
    public static MagicConfigBoolean expCustomBlockHitBoxOverlayLinkedAdapterSupportPointedDripstoneBlock = cf.newConfigBoolean("expCustomBlockHitBoxOverlayLinkedAdapterSupportPointedDripstoneBlock", false);

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DEBUG/*, predicate = TweakMyClientPredicate.ExperimentalMode.class*/)
    public static MagicConfigHotkey expNullPointerExceptionTest = cf.newConfigHotkey("expNullPointerExceptionTest");

    @Statistic(hotkey = false)
    @Config(category = ConfigCategory.DEBUG/*, predicate = TweakMyClientPredicate.ExperimentalMode.class*/)
    public static MagicConfigHotkey expUnsafeIllegalPutTest = cf.newConfigHotkey("expUnsafeIllegalPutTest");

    @Config(category = ConfigCategory.DEBUG/*, predicate = TweakMyClientPredicate.ExpXiBao.class*/)
    public static MagicConfigBoolean expXiBao = cf.newConfigBoolean("expXiBao", false);

    public static void init() {
        Configs.cm.parseConfigClass(Configs.class);
        // Set callback for all BooleanHotkeyed config.
        /* TODO
        Legacy MagicLib impl
        cm.forEach(
                iConfigBase -> {
                    if (iConfigBase instanceof ConfigBooleanHotkeyed) {
                        ((ConfigBooleanHotkeyed) iConfigBase).getKeybind().setCallback(new CallBacks.KeyCallbackToggleBooleanConfigWithMessage((IConfigBoolean) iConfigBase, iConfigBase.getConfigGuiDisplayName()));
                    }
                }
        );*/

        // Generic config callbacks.
        getTargetBlockPosition.getKeybind().setCallback(CallBacks::getTargetBlockPositionCallback);
        openConfigGui.getKeybind().setCallback(CallBacks::openConfigGuiCallback);
        memoryCleaner.getKeybind().setCallback(CallBacks::memoryCleanerCallback);
        syncBlocks.getKeybind().setCallback(CallBacks::syncBlocksCallback);
        syncInventory.getKeybind().setCallback(CallBacks::syncInventoryCallback);

        customWindowTitleEnableActivity.setValueChangeCallback(CallBacks::customWindowTitleEnableActivityCallback);
        customWindowTitleRandomly.setValueChangeCallback(CallBacks::featureCustomWindowTitleCallback);

        // List config callbacks.
        listCustomWindowTitle.setValueChangeCallback(CallBacks::featureCustomWindowTitleCallback);
        listCustomWindowTitleWithActivity.setValueChangeCallback(CallBacks::featureCustomWindowTitleCallback);

        // Feature config callbacks.
        featureCustomBlockHitBoxOverlayFill.setValueChangeCallback(CallBacks::featureCustomBlockHitBoxOverlayFillCallBack);
        featureCustomBlockHitBoxOverlayOutline.setValueChangeCallback(CallBacks::featureCustomBlockHitBoxOverlayOutlineCallBack);
        featureCustomWindowIcon.setValueChangeCallback(option -> IconUtil.updateIcon());
        featureCustomWindowTitle.setValueChangeCallback(CallBacks::featureCustomWindowTitleCallback);

        // Disable config callbacks.
        disableRenderToast.setValueChangeCallback(CallBacks::disableRenderToastCallback);

        // Debug config callbacks.
        expNullPointerExceptionTest.getKeybind().setCallback(CallBacks::expNullPointerExceptionTestCallback);
        expUnsafeIllegalPutTest.getKeybind().setCallback(CallBacks::expUnsafeIllegalAllocateTestCallback);



        debugMode.setValueChangeCallback(CallBacks::debugModeCallBack);
        debugExperimentalMode.setValueChangeCallback(CallBacks::debugExperimentalModeCallBack);

        // Init
        CallBacks.featureCustomBlockHitBoxOverlayFillCallBack(null);
        CallBacks.featureCustomBlockHitBoxOverlayOutlineCallBack(null);
        CallBacks.debugModeCallBack(null);
    }
}
