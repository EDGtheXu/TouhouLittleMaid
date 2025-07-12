package com.github.tartaricacid.touhoulittlemaid.compat.kubejs;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import com.github.tartaricacid.touhoulittlemaid.api.event.RegisterKubeJSEvent;
import com.github.tartaricacid.touhoulittlemaid.client.overlay.MaidTipsOverlay;
import com.github.tartaricacid.touhoulittlemaid.compat.kubejs.event.CommonEventsPostJS;
import com.github.tartaricacid.touhoulittlemaid.compat.kubejs.event.MaidEventsJS;
import com.github.tartaricacid.touhoulittlemaid.compat.kubejs.event.compat.JadeEventsPostJS;
import com.github.tartaricacid.touhoulittlemaid.compat.kubejs.event.compat.TopEventsPostJS;
import com.github.tartaricacid.touhoulittlemaid.compat.kubejs.recipe.AltarOutputJS;
import com.github.tartaricacid.touhoulittlemaid.compat.kubejs.recipe.AltarRecipeSchema;
import com.github.tartaricacid.touhoulittlemaid.compat.kubejs.register.MaidRegisterJS;
import com.github.tartaricacid.touhoulittlemaid.entity.task.TaskManager;
import com.github.tartaricacid.touhoulittlemaid.init.InitRecipes;
import com.github.tartaricacid.touhoulittlemaid.item.bauble.BaubleManager;
import com.github.tartaricacid.touhoulittlemaid.util.ItemsUtil;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class ModKubeJSPlugin extends KubeJSPlugin {
    @Override
    public void init() {
        ModKubeJSCompat.ENABLE = true;
        MinecraftForge.EVENT_BUS.register(new CommonEventsPostJS());
        if (ModList.get().isLoaded("jade")) {
            MinecraftForge.EVENT_BUS.register(new JadeEventsPostJS());
        }
        if (ModList.get().isLoaded("theoneprobe")) {
            MinecraftForge.EVENT_BUS.register(new TopEventsPostJS());
        }
    }

    @Override
    public void onServerReload() {
        // 客户端部分内容重载，哎，都怪 KJS 没给客户端热重载的方法
        if (FMLEnvironment.dist == Dist.CLIENT) {
            MaidTipsOverlay.init();
        }
        BaubleManager.init();
        TaskManager.init();
    }

    @Override
    public void registerEvents() {
        EventGroup group = MaidEventsJS.GROUP;
        MinecraftForge.EVENT_BUS.post(new RegisterKubeJSEvent(group));
        group.register();
    }

    @Override
    public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
        event.namespace(TouhouLittleMaid.MOD_ID)
                .register(InitRecipes.ALTAR_RECIPE_SERIALIZER.getId().getPath(), AltarRecipeSchema.SCHEMA);
    }

    @Override
    public void registerBindings(BindingsEvent event) {
        event.add("MaidAltarOutput", AltarOutputJS.class);
        event.add("MaidRegister", MaidRegisterJS.class);
        event.add("MaidItemsUtil", ItemsUtil.class);
    }
}
