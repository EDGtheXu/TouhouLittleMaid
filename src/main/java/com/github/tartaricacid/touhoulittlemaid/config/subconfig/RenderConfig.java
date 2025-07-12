package com.github.tartaricacid.touhoulittlemaid.config.subconfig;

import net.minecraftforge.common.ForgeConfigSpec;

public class RenderConfig {
    public static ForgeConfigSpec.BooleanValue ENABLE_COMPASS_TIP;
    public static ForgeConfigSpec.BooleanValue ENABLE_GOLDEN_APPLE_TIP;
    public static ForgeConfigSpec.BooleanValue ENABLE_POTION_TIP;
    public static ForgeConfigSpec.BooleanValue ENABLE_MILK_BUCKET_TIP;
    public static ForgeConfigSpec.BooleanValue ENABLE_GLASS_BOTTLE_TIP;
    public static ForgeConfigSpec.BooleanValue ENABLE_NAME_TAG_TIP;
    public static ForgeConfigSpec.BooleanValue ENABLE_LEAD_TIP;
    public static ForgeConfigSpec.BooleanValue ENABLE_SADDLE_TIP;
    public static ForgeConfigSpec.BooleanValue ENABLE_SHEARS_TIP;

    public static void init(ForgeConfigSpec.Builder builder) {
        builder.push("render");

        ENABLE_COMPASS_TIP = builder.define("EnableCompassTip", true);
        ENABLE_GOLDEN_APPLE_TIP = builder.define("EnableGoldenAppleTip", true);
        ENABLE_POTION_TIP = builder.define("EnablePotionTip", true);
        ENABLE_MILK_BUCKET_TIP = builder.define("EnableMilkBucketTip", true);
        ENABLE_GLASS_BOTTLE_TIP = builder.define("EnableGlassBottleTip", true);
        ENABLE_NAME_TAG_TIP = builder.define("EnableNameTagTip", true);
        ENABLE_LEAD_TIP = builder.define("EnableLeadTip", true);
        ENABLE_SADDLE_TIP = builder.define("EnableSaddleTip", true);
        ENABLE_SHEARS_TIP = builder.define("EnableShearsTip", true);

        builder.pop();
    }
}
