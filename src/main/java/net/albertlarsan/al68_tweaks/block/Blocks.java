package net.albertlarsan.al68_tweaks.block;

import net.albertlarsan.al68_tweaks.CommonConstants;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * Contains all this mod's blocks
 */
public class Blocks {

    public static final Block CHARCOAL_BLOCK;

    private static Block register(String id, Block block) {
        return (Block) Registry.register(Registry.BLOCK, new Identifier(CommonConstants.NAMESPACE, id), block);
    }

    static {
        CHARCOAL_BLOCK = register("charcoal_block",
                new Block(FabricBlockSettings.of(Material.STONE, MapColor.BLACK).requiresTool().strength(5.0F, 6.0F)));

    }

}
