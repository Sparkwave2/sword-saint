package dev.titanite.sparkwave.sword_saint;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public final class SwordSaint {
    public static final String MOD_ID = "sword_saint";
    
    // Creative Tab Registry
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    
    // Items Registry
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);

    // Register Custom Sword
    public static final RegistrySupplier<Item> BLAZE_SWORD = ITEMS.register("blaze_sword", 
        () -> new SwordItem(Tiers.IRON, new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 3, -2.4F))));
    
    // Create the Creative Tab
    public static final RegistrySupplier<CreativeModeTab> SWORD_SAINT_TAB = TABS.register("sword_saint_tab", 
        () -> CreativeTabRegistry.create(builder -> 
            builder
                .title(Component.translatable("itemGroup." + MOD_ID + ".sword_saint_tab"))
                .icon(() -> new ItemStack(BLAZE_SWORD.get()))
                .displayItems((parameters, output) -> {
                    output.accept(Items.IRON_SWORD);
                    output.accept(BLAZE_SWORD.get());
                })
        )
    );

    public static void init() {
        // Register the creative tab
        TABS.register();
        
        // Register items
        ITEMS.register();
        
        // Write common init code here.
    }
}
