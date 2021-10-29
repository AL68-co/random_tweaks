package net.albertlarsan.al68_tweaks.item;

import net.albertlarsan.al68_tweaks.AL68Tweaks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;

public class CommandBlockOpenerItem extends Item {

    public CommandBlockOpenerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockEntity clickedBlockEntity = context.getWorld().getBlockEntity(context.getBlockPos());
        if (clickedBlockEntity.getType() == BlockEntityType.COMMAND_BLOCK) {
            context.getPlayer().openCommandBlockScreen(context.getWorld()
                    .getBlockEntity(context.getBlockPos(), BlockEntityType.COMMAND_BLOCK).orElseThrow());
            if (context.getWorld().isClient()) {
                AL68Tweaks.LOGGER.info("Client");
            } else {
                AL68Tweaks.LOGGER.info("Server");
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

}
