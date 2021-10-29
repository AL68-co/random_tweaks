package net.albertlarsan.al68_tweaks.item;

import java.util.Optional;

import net.albertlarsan.al68_tweaks.CommonConstants;
import net.albertlarsan.al68_tweaks.block.Blocks;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

/**
 * Contains all this mod's items
 */
public class Items {

    public static final Item CHARCOAL_BLOCK;

    public static final Item FLIGHT_ITEM;
    public static final Item GOD_ITEM;
    public static final Item COMMAND_BLOCK_OPENER;

    public static final ItemGroup ITEMS_ITEM_GROUP;
    public static final ItemGroup BLOCKS_ITEM_GROUP;

    private static Item register_fuel(Block block, Optional<ItemGroup> group, Integer burningTime) {
        Item item = register(block, group);
        FuelRegistry.INSTANCE.add(item, burningTime);
        return item;
    }

    private static Item register(Block block, Optional<ItemGroup> group) {
        if (group.isPresent()) {
            return register(new BlockItem(block, (new Item.Settings()).group(group.get())));
        } else {
            return register(new BlockItem(block, (new Item.Settings()).group(ItemGroup.SEARCH)));
        }
    }

    private static Item register(BlockItem item) {
        return register((Block) item.getBlock(), (Item) item);
    }

    protected static Item register(Block block, Item item) {
        return register(Registry.BLOCK.getId(block), item);
    }

    private static Item register(String id, Item item) {
        return register(new Identifier(CommonConstants.NAMESPACE, id), item);
    }

    private static Item register(Identifier id, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return (Item) Registry.register(Registry.ITEM, (Identifier) id, item);
    }

    static {

        ITEMS_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(CommonConstants.NAMESPACE, "items"))
                .icon(() -> new ItemStack(net.minecraft.item.Items.BOWL)).build();
        BLOCKS_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(CommonConstants.NAMESPACE, "blocks"))
                .icon(() -> new ItemStack(net.minecraft.item.Items.COBBLESTONE)).build();

        CHARCOAL_BLOCK = register_fuel(Blocks.CHARCOAL_BLOCK, Optional.of(BLOCKS_ITEM_GROUP), 16000);

        FLIGHT_ITEM = register("flight_item",
                new FlightItem(new FabricItemSettings().fireproof().group(ITEMS_ITEM_GROUP).rarity(Rarity.EPIC)));

        GOD_ITEM = register("god_item",
                new GodItem(new FabricItemSettings().fireproof().group(ITEMS_ITEM_GROUP).rarity(Rarity.EPIC)));
        COMMAND_BLOCK_OPENER = register("command_block_opener", new CommandBlockOpenerItem(
                new FabricItemSettings().fireproof().group(ITEMS_ITEM_GROUP).rarity(Rarity.EPIC)));

    }
}